
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import rncontroller.MainController;

import com.google.api.services.drive.model.File;

import gglconnector.GGLConnector;
import gglconnector.GGLFileManager;

public class Main extends HttpServlet {

//	public static void main(String[] args) throws GeneralSecurityException, IOException {
//		GGLFileManager fileManager = new GGLFileManager();
//		
//		fileManager.insertFile(GGLConnector.getDrive(), "TEST DOCUMENT", "document description", "", "text/plain", "document1.txt");
		
		/*List<File> files = fileManager.retrieveAllFiles(GGLConnector.getDrive());
		Iterator<File> iterator = files.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}*/
//	}
	       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("src/main/webapp/index.jsp").forward(request, response);
//		response.getWriter().print("request.getContextPath() ----> "+request.getContextPath());
//		response.getWriter().print("Hello world!!");
	}

	
	public static void main(String[] args) throws Exception {
	    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    context.setContextPath("/");
	    server.setHandler(context);
	    context.addServlet(new ServletHolder(new Main()),"/*");
	    server.start();
	    server.join();
	}

}