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
	table{margin:0 auto;}
	input{width:100px;}
</style>
</head>
<body>
	${path }
	<form method="get" action="${path }/buyCheck.do">
		<table border=1>
			<tr>
				<th>물건명</th>
				<th><input name="name"></th>
			</tr>
			<tr>
				<th>가격</th>
				<th><input type="number" name="price" value="0"></th>
			</tr>
			<tr>
				<th>갯수</th>
				<th><input type="number" name="cnt" value="0"></th>
			</tr>
			<tr>
				<th colspan="2"><button type="submit">구매요청</button></th>
			</tr>						
		</table>
	</form>
	${msg }
</body>
</html>