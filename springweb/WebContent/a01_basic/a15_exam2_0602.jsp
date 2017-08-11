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
		var calIdx="${cal.calIdx}";
		$("select[name=calIdx]").val(calIdx);
	});

</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post">
		<input type="number" name="num01" value="${cal.num01 }">
		<select name="calIdx">
			<c:forEach var="code" items="${calcu }">
				<option value="${code.key }">${code.value }</option>
			</c:forEach>
		</select>
		<input type="number" name="num02" value="${cal.num02 }">=
		<input type="number" name="result" value="${cal.result }">
		<button type="submit">확인</button>
	</form>
	${msg }
</body>
</html>