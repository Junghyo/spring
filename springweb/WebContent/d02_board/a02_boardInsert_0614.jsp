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

	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post" action="${path }/board3.do?method=insertProc">
		<table>
			<tr>
				<th>제목</th>
				<td colspan="3"><input name="subject"/></td>
			</tr>
			<tr>
				<th>작성자</th><td><input name="writer"/></td>
				<th>비밀번호</th><td><input name="pwd"/></td>
			</tr>
			<tr>
				<th colspan="4">내용</th>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content" cols="100" rows="50"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="등록"/></td>
			</tr>
		</table>
	</form>
</body>
</html>