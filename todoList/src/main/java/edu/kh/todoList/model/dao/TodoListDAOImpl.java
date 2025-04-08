package edu.kh.todoList.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.model.dto.Todo;


public class TodoListDAOImpl implements TodoListDAO {

	// JDBC 객체 참조 변수 선언 + Properties 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; // sql.xml 파일을 읽어오기위한 prop

	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기
	public TodoListDAOImpl() {
		// TodoListDAOImpl 객체가 생성될 때 ( Service 단에서 new 연산자를 통해 객체화 될 때 )
		// sql.xml 파일의 내용을 읽어와 Properties prop 객체에 K:V 세팅
		
		try {
			String filePath = TodoListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			System.out.println("sql.xml 파일 로드 중 예외발생");
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Todo> todoListFullView(Connection conn) throws Exception {

		// 결과 저장용 변수 선언
		List<Todo> todoList = new ArrayList<Todo>();
		
		try {
			
			// SQL 작성
			String SQL = prop.getProperty("todoListFullView");
			
			stmt = conn.createStatement();
			
			// executeQuery() - select 수행 후 ResultSet 반환
			// executeUpdate() - DML(INSER/DELETE/UPDATE) 수행 후 결과 행의 개수 반환
			rs = stmt.executeQuery(SQL);
			
			
			while(rs.next()) {
				
				boolean complete = rs.getInt("TODO_COMPLETE") == 1;
				
				// Builder 패턴 : 특정 값으로 초기화된 객체를 쉽게 만드는 방법
				// -> Lombok 에서 제공하는 @Builder 어노테이션을 DTO에 작성.
				Todo todo = Todo.builder()
						.todoNo(rs.getInt("TODO_NO"))
						.todoTitle(rs.getString("TODO_TITLE"))
						.todoComplete(complete)
						.regDate(rs.getString("REG_DATE"))
						.build();
				
				todoList.add(todo);
				
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return todoList;
	}

	@Override
	public int getCompleteCount(Connection conn) throws Exception {

		int completeConut = 0;

		try {
			
			String SQL = prop.getProperty("getCompleteCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(SQL);
			
			if(rs.next()) {
				completeConut = rs.getInt(1);
			}
			
			
		} finally {
			
			close(rs);
			close(stmt);

		}
		
		
		return completeConut;
	}


	@Override
	public int todoAdd(Connection conn, String title, String detail) throws Exception {

		int result = 0;
		
		try {
			
			String SQL = prop.getProperty("todoAdd");
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, title);
			pstmt.setString(2, detail);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);

		}
		
		return result;
	}


	@Override
	public Todo todoDetail(Connection conn, int i) throws Exception {

		Todo todo = null;
		
		try {
			
			String SQL = prop.getProperty("todoDetail");
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, i);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boolean complete = rs.getInt("TODO_COMPLETE") == 1;
				
				todo = Todo.builder()
						.todoNo(i)
						.todoTitle(rs.getString("TODO_TITLE"))
						.todoDetail(rs.getString("TODO_DETAIL"))
						.todoComplete(complete)
						.regDate(rs.getString("REG_DATE"))
						.build();
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return todo;
	}


	@Override
	public int todoComplete(Connection conn, int todoNo) throws Exception {
		int result = 0;

		try {
			
			
			String SQL = prop.getProperty("todoComplete");
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	@Override
	public int updateTodo(Connection conn, int todoNo, String todoTitle, String updateDetail) throws Exception {

		int result = 0;
		
		try {
			
			String SQL = prop.getProperty("updateTodo");
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, todoNo);
			pstmt.setString(2, todoTitle);
			pstmt.setString(3, updateDetail);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

}
