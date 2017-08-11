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
	<h1>구매금액 누적 확인</h1>
	<form method="post">
		<table>
			<tr>
				<th>물건가격</th>
				<th><input type="number" name="price" value="${prod.price }"/></th>
			</tr>
			<tr>
				<th>물건갯수</th>
				<th><input type="number" name="cnt" value="${prod.cnt }"/></th>
			</tr>
			<tr>
				
				<th colspan="2">
					<input type="submit" value="누적금액 확인"/>
				</th>
			</tr>			
		</table>
		<input type="hidden" name="sum" value="${prod.sum }">
		<h2>현재누적금액: ${prod.sum }원</h2>
	</form>

</body>
</html>