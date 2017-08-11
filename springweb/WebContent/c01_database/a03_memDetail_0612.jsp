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
		$("#goMain").click(function(){
			$(location).attr("href","${path}/memList_mybatis.do");
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post" action="${path }/memUpdate_mybatis.do">
			<input type="hidden" name="id" value="${mem.id }"/>
		<table>
			<tr>
				<th>아이디</th>
				<th>${mem.id }</th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input name="pwd" value="${mem.pwd }"/></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input name="name" value="${mem.name }"/></th>
			</tr>
			<tr>
				<th>포인트</th>
				<th><input name="point" value="${mem.point }"/></th>
			<tr>
			</tr>
			<tr>
				<th>권한</th>
				<th>${mem.author }</th>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정"/>
					<input type="button" id="goMain" value="메인화면"/>
				</th>
			</tr>													
		</table>
	</form>
</body>
</html>