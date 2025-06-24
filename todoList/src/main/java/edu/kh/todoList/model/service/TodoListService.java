package edu.kh.todoList.model.service;

import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

// 유지보수성과 확장성, 테스트 용이성 때문..
// -> Controller 는 ServiceImpl을 직접 쓰지 않고, Service 인터페이스를 의존하므로,
//	  나중에 구현체가 바뀌어도 Controller는 영향을 받지 않음
// -> ServiceImpl 대신 NewServiceImpl 을 만들어서 새로운 로직을 적용하고 싶을 때
//	  쉽게 교체가 가능
public interface TodoListService {

	/** 할 일 목록 반환 서비스
	 * @return todoList + 완료개수 map
	 */
	Map<String, Object> todoListFullView() throws Exception;

	/** 할 일 추가 서비스
	 * @param title
	 * @param detail
	 * @return int 성공 시 추가된 행의 개수 / 실패 시 0 반환
	 * @throws Exception
	 */
	int todoAdd(String title, String detail) throws Exception;

	Todo todoDetail(int i)throws Exception;

	int todoComplete(int todoNo) throws Exception;

	int updateTodo(int todoNo, String todoTitle, String updateDetail) throws Exception;

	int todoDelete(int todoNo) throws Exception;

	int todoUpdate(int todoNo, String title, String detail) throws Exception;

	
	
	
}
