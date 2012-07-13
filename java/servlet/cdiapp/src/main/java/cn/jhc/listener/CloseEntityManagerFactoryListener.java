package cn.jhc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.jhc.resource.Resources;

@WebListener
public class CloseEntityManagerFactoryListener implements
		ServletContextListener {

	public void contextDestroyed(ServletContextEvent e) {
		Resources.closeFactory();
	}

	public void contextInitialized(ServletContextEvent e) {

	}

}
