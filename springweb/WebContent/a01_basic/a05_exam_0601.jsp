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
		var ranIdx = Math.floor(Math.random()*4);
		var symbol =['+','-','*','/'];
		$("#symbol").html(symbol[ranIdx]);
		$("input[name=symbol]").val(symbol[ranIdx]);

	
	});
	var msg = "${msg}";
	if(msg!=""){
		alert(msg);
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post" action="${path }/examCheck.do">
		<input type="hidden" name="num01" value="${exam.num01 }">
		<input type="hidden" name="num02" value="${exam.num02 }">
		<input type="hidden" name="symbol">
		<span id="num01">${exam.num01 }</span>
		<span id="symbol"></span>
		<span id="num02">${exam.num02 }</span>=
		<input type="number" name="sum">
		<button type="submit">확인</button>
	</form>
</body>
</html>
