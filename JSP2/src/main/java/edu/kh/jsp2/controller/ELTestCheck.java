package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/check")
public class ELTestCheck extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		ServletContext application = req.getServletContext();
		System.out.println( req.getAttribute("requestValue") );
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/check.jsp");
		dispatcher.forward(req, resp);
		
		System.out.println(session.getAttribute("sessionValue"));
		System.out.println(application.getAttribute("applicationValue"));
	
	}
	
	

}
