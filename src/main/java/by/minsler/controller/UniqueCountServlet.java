package by.minsler.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.minsler.helper.Counter;

/**
 * Servlet implementation class UniqueCountServlet
 */
@WebServlet("/UniqueCountServlet")
public class UniqueCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		Counter uniqueCounter = (Counter) context.getAttribute("uniqueCounter");
		HttpSession session = request.getSession();

		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		System.out.println(session.getId());
		// Cookie cookie = new Cookie("userName", "dima");
		// cookie.setMaxAge(10 * 60);
		// response.addCookie(cookie);

		if (session.isNew()) {
			uniqueCounter.increment();
		}

		ImageIO.write(uniqueCounter.getImage(), "jpeg", out);
	}
}
