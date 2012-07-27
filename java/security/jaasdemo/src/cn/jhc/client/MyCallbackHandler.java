package cn.jhc.client;

import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class MyCallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		Scanner sc = new Scanner(System.in);
		for(Callback callback : callbacks) {
			if(callback instanceof TextOutputCallback) {
				TextOutputCallback toc = (TextOutputCallback)callback;
				switch(toc.getMessageType()) {
				case TextOutputCallback.INFORMATION:
					System.out.println(toc.getMessage());
					break;
				case TextOutputCallback.WARNING:
					System.out.println("WARNING:" + toc.getMessage());
					break;
				case TextOutputCallback.ERROR:
					System.out.println("ERROR: " + toc.getMessage());
					break;
				default:
					throw new IOException("Unsupported message type: " + toc.getMessageType());
				}
			}
			else if(callback instanceof NameCallback) {
				NameCallback nc = (NameCallback)callback;
				System.out.println(nc.getPrompt());
				System.out.flush();
				nc.setName(sc.next());
			}
			else if(callback instanceof PasswordCallback) {
				PasswordCallback pc = (PasswordCallback)callback;
				System.out.println(pc.getPrompt());
				System.out.flush();
				pc.setPassword(sc.next().toCharArray());
			}
			else {
				throw new UnsupportedCallbackException(callback, "Unrecognized Callback.");
			}
		}
	}

}
