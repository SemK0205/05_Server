<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>

	<%-- 
		CSS, JS 파일은 브라우저에서 직접 요청하는 정적 파일.
		이런 정적 리소스들은 클라이언트(브라우저)에서 직접 접근 가능해야하므로
		webapp 폴더 또는 그 하위폴더에 있어야 함.
		
		WEB-INF 폴더 안에 넣으면 인식 X
		
		 webapp 폴더 기준으로 경로 작성 
	--%>
	<link rel="stylesheet" href="/resources/css/book.css">

</head>
<body>

	
	<h1>책 목록 조회</h1>
	
	<hr>
	<h3>전체 책 수량 : ${fn:length(bookList)}권</h3>
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격(원)</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${bookList}" var="book" varStatus="vs">
				<tr>
					<th>${vs.count}</th>
					<td>${book.title}</td>
					<td>${book.writer}</td>
					<td>${book.price}</td>
				</tr>
				
				<%-- 3배수 번째 반복 시 --%>
				<c:if test="${vs.count % 3 == 0}">
					<tr>
						<td class="blank" colspan="4">&nbsp;</td>
					</tr>
				</c:if>
			</c:forEach>
			
		</tbody>
	</table>
	
	
	


	<script src="/resources/js/book.js"></script>
</body>
</html>