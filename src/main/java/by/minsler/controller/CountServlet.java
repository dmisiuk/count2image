package by.minsler.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.helper.Counter;

public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");

		ServletContext context = getServletContext();
		Counter counter = (Counter) context.getAttribute("counter");

		OutputStream out = response.getOutputStream();
		counter.increment();
		ImageIO.write(counter.getImage(), "jpeg", out);
	}
}
