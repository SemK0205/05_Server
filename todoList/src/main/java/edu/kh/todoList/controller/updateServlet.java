package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/updateServlet")
public class updateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			String todoTitle = req.getParameter("title");
			String updateDetail = req.getParameter("updateDeatil");
			
			TodoListService service = new TodoListServiceImpl();
			
			int result = service.updateTodo(todoNo, todoTitle, updateDetail);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	
}
