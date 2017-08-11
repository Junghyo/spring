<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="UTF-8"/> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%request.setCharacterEncoding("UTF-8"); 
  String path=request.getContextPath();	
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/a00_com/a00_com.css">
<script src="${path}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#schBtn").click(function(){
			$("form").submit();
		});
		$("#regBtn").click(function(){
			$(location).attr("href","${path}/board3.do?method=insert");
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h3>게시판 목록</h3>
	<form method="post">
		<table>
			<tr><th>제목</th><td><input name="subject" value="${board3Sch.subject }"/></td></tr>
			<tr><th>작성자</th><td><input name="writer" value="${board3Sch.writer }"/></td></tr>
			<tr><th>내용</th><td><input name="content" value="${board3Sch.content }"/></td></tr>
			<tr>
				<td colspan="2">
					<input type="button" id="regBtn" value="등록"/>
					<input type="button" id="schBtn" value="검색"/>
				</td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.no }</td>
				<td>${board.subject }</td>
				<td>${board.content }</td>
				<td>${board.writer }</td>
				<td>${board.regdate }</td>
				<td>${board.readcount }</td>
			</tr>
		</c:forEach>
		<c:if test="${boardList.size()==0 }">
			<tr>
				<th colspan="6">작성된 글이 없습니다!!</th>
			</tr>
		</c:if>
	</table>
</body>
</html>