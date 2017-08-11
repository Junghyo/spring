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
		$("#goMain").click(function(){
			$(location).attr("href","${path}/deptList_mybatis.do");
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post" action="${path }/deptUpt_mybatis.do">
		<input type="hidden" name="deptno" value="${dept.deptno }"/>
		<table>
			<tr>
				<th>부서번호</th>
				<th>${dept.deptno }</th>
			</tr>
			<tr>
				<th>부서명</th>
				<th><input name="dname" value="${dept.dname }"/></th>
			</tr>
			<tr>
				<th>부서위치</th>
				<th><input name="loc" value="${dept.loc }"/></th>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정"/>
					<input type="button" id="goMain" value="메인화면"/>
				</th>
			</tr>				
		</table>
	</form>
</body>
</html>