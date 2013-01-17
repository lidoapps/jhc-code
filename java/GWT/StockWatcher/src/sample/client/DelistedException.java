package sample.client;

import java.io.Serializable;

public class DelistedException extends Exception implements Serializable {
	private String symbol;

	public DelistedException() {
		super();
	}

	public DelistedException(String message) {
		this.symbol = message;
	}

	public String getSymbol() {
		return symbol;
	}
	
}
