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
			$(this).css("background","tomato");
		},function(){
			$(this).css("background","#ffffff");
		});
		$("tr").dblclick(function(){
			var deptno = $(this).children(0).html();
			$(location).attr("href","${path}/deptDetail_mybatis.do?deptno="+deptno);
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<table>
		<c:forEach var="dept" items="${deptList }">
			<tr>
				<th>${dept.deptno }</th>
				<th>${dept.dname }</th>
				<th>${dept.loc }</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>