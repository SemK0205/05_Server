package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		/*
		 * getParameter("name") : 같은 name 속성을 가진 여러개 값 중 첫번째 값만 반환
		 * getParameterValues("name") : 같은 name 속성을 가진 모든 값을 배열(String[])로 반환
		 * 
		 */
		
		String option = req.getParameter("opt");
		String optArr[] = req.getParameterValues("opt");
		
		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(option);
		
		// opt 미선택시 optArr == null
		if(optArr != null) {
			for(String e : optArr) {
				System.out.println(e);
			
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
	
		dispatcher.forward(req, resp);
		
	}
	
	
}
