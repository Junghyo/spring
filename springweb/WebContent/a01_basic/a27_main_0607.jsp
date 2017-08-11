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
		$("#btn1").click(function(){
			$("input[name=jspend]").val("1");
			$("form").submit();
		});
		$("#btn2").click(function(){
			$("input[name=jspend]").val("2");
			$("form").submit();
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h2>${mem.jid } 로그인 성공!</h2>
	<h2>${mem.jname }님 환영합니다.</h2>
	<form method="post">
		<input type="hidden" name="jspend">
	</form>
	<h2>현재포인트: ${mem.jpoint }</h2>
	<h3>팝콘+음료구매<input type="button" id="btn1" value="포인트차감(-1)"></h3>
	<h3>영화표1장구매<input type="button" id="btn2" value="포인트차감(-2)"></h3>
</body>
</html>