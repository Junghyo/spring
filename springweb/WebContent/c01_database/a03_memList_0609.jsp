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
		$("tr").hover(function(){
			$(this).css("background","yellow");
		}, function(){
			$(this).css("background","#ffffff");
		});
		$("tr").click(function(){
			var id = $(this).children(0).html();
			$(location).attr("href","${path}/memDetail_mybatis.do?id="+id);
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h3>id 검색</h3>
	<form>
		ID<input name="id"/>
		<input type="submit" value="검색"/>
	</form>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>포인트</th>
			<th>권한</th>
		</tr>
		<c:forEach var="mem" items="${memList }">
			<tr>
				<th>${mem.id }</th>
				<th>${mem.pwd }</th>
				<th>${mem.name }</th>
				<th>${mem.point }</th>
				<th>${mem.author }</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>