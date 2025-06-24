<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${todo.todoTitle} 상세 조회</title>
<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

	<h1>${sessionScope.loginMember}</h1>

	<div><h1 class="title">${todo.todoTitle}</h1></div>
	<div><input class="inputTitle hidden" style="font-weight: bold; font-size: 30px; margin-top: 20px;"></div>

    <div class="complete">
        완료 여부 : 
        <c:if test="${todo.todoComplete}">
            <span class="green">O</span>
        </c:if>

        <c:if test="${not todo.todoComplete}">
            <span class="red">X</span>
        </c:if>
    </div>

    <div>
        작성일 : ${todo.regDate}
    </div>

    <div class="content">${todo.todoDetail}</div>
    <div class="content2 hidden"><textarea class="updateDetail"></textarea></div>
    
    <div class="btn-container">
        <div>
            <button type="button" id="goToList">목록으로</button>
        </div>
        <div>
            <button id="completeBtn">완료 여부 변경</button>
            <button id="updateBtn">수정</button>
            <button id="deleteBtn">삭제</button>
        </div>
    </div>
    <div class="btn-container2 hidden">
        <div>
            <button type="button" id="goToList">목록으로</button>
        </div>
        <div>
            <button id="saveBtn">저장</button>
            <button id="backBtn">뒤로가기</button>
        </div>
    </div>
    
    <c:if test="${not empty sessionScope.message}">
    	<script>
    		alert("${message}");
    	</script>   	
    	
    	<c:remove var="message" scope="session"/>
    </c:if>


	
<script src="/resources/js/detail.js"></script>
</body>
</html>