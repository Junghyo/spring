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
<script src="${path}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
	});
	var msg="${msg}";
	if(msg!=""){
		alert(msg);
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<h1>회원등록</h1>
	<form method="post" action="${path }/reCheck.do">
		<table>
			<tr>
				<th>아이디</th>
				<th><input name="id"></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="password" name="pwd"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input name="name"></th>
			</tr>
			<tr>
				<th>e-mail</th>
				<th><input type="email" name="email"></th>
			</tr>
			<tr>
				<th>포인트</th>
				<th><input type="number" name="point"></th>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="등록"></th>
			</tr>												
		</table>
	</form>
</body>
</html>