import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import rncontroller.MainController;


public class MainClass extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
		response.getWriter().print("Hello from Java!");
	}

	
	public static void main(String[] args) throws Exception {
	    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    context.setContextPath("/");
	    server.setHandler(context);
	    context.addServlet(new ServletHolder(new MainController()),"/*");
	    server.start();
	    server.join();
	}

}
