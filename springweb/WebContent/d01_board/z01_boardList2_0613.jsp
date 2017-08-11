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
<link rel="stylesheet" href="${path}/a00_com/a00_com.css" >	
<script src="${path}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#schBtn").click(function(){
			$("form").submit();
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h2>게시판</h2>
	<form method="post">
		<table>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="${board2.title }"/></td>
				<td>내용</td><td><input type="text" name="content" value="${board2.content }"/></td>
				<td>작성자</td><td><input type="text" name="writer" value="${board2.writer }"/></td>
			</tr>
			<tr>
				<td colspan="6" style="text-align:right;">
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
			<th>등록일</th>
			<th>수정일</th>
		</tr>
		<c:forEach var="board2" items="${board2list }">
			<tr>
				<td>${board2.no }</td>
				<td>${board2.title }</td>
				<td>${board2.content }</td>
				<td>${board2.writer }</td>
				<td>${board2.credate }</td>
				<td>${board2.uptdate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>