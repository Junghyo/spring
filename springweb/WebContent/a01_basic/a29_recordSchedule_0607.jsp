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
</script>
<style type="text/css">

</style>
</head>
<body>
	<h2>일정 등록</h2>
	<form method="post">
		<table>
			<tr>
				<th>일시</th>
				<th><input type="date" name="time"/></th>
			</tr>
			<tr>
				<th>내용</th>
				<th><input name="content"/></th>
			</tr>
			<tr>
				<th colspan="2"><button type="submit">등록</button></th>
			</tr>
		</table>
	</form>
	<h2>일정내용</h2>
	<h3>${schedule.time } : ${schedule.content }</h3>
	<a href="a01_basic/a30_scheduleCheck_0607.jsp">다음페이지에서 일정확</a>
</body>
</html>