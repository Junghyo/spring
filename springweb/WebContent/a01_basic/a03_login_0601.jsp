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
		var msg="${msg}";
		if(msg!=""){
			alert(msg);
		}
	});
</script>
<style type="text/css">

</style>
</head>
<body>
<!-- 
 Controller 호출 action=""
 -->
	<form method="post" action="${path }/check.do">
	id: <input name="id"/><br>
	pwd: <input type="password" name="pwd"/>
	<button type="submit">로그인</button>
	</form>
</body>
</html>