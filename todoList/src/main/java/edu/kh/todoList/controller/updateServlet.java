package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/update")
public class updateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			String todoTitle = req.getParameter("title");
			String updateDetail = req.getParameter("detail");
			
			TodoListService service = new TodoListServiceImpl();
			
			int result = service.updateTodo(todoNo, todoTitle, updateDetail);
			

			String message = null;
			if(result > 0) {
				message = "수정 성공!";
				HttpSession session = req.getSession();
				session.setAttribute("message", message);
				resp.sendRedirect("/todo/detail?todoNo=" + todoNo);
				return;
			} else {
				message = "수정 실패...";
				HttpSession session = req.getSession();
				session.setAttribute("message", message);
				resp.sendRedirect("/todo/detail?todoNo=" + todoNo);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	
}
