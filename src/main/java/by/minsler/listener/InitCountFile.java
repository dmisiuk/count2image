package by.minsler.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import by.minsler.helper.Counter;

@WebListener
public class InitCountFile implements ServletContextListener {

	public InitCountFile() {
		// TODO Auto-generated constructor stub
	}

	public void contextInitialized(ServletContextEvent event) {

		ServletContext context = event.getServletContext();
		String countfile = context.getInitParameter("countfile");
		String uniquecountfile = context.getInitParameter("uniquecountfile");

		String homeDir = context.getRealPath("/");
		File file = new File(homeDir, countfile);
		File uniquefile = new File(homeDir, uniquecountfile);
		Counter counter = new Counter(file);
		Counter uniqueCounter = new Counter(uniquefile);

		context.setAttribute("counter", counter);
		context.setAttribute("uniqueCounter", uniqueCounter);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
