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
	<form method="get" action="${path }/prodCheck.do">
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Count</th>
			</tr>
			<tr>
				<th>사과</th>
				<th>2000</th>
				<th><input type="number" name="cnt01"></th>
			</tr>
			<tr>
				<th>바나나</th>
				<th>3000</th>
				<th><input type="number" name="cnt02"></th>
			</tr>			
			<tr>
				<th colspan="3"><button type="submit">확인</button></th>
			</tr>			
		</table>
	</form>
</body>
</html>