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
		var deptno="${sch.deptno}";
		if(deptno!=""){
			$("select[name=deptno]").val(deptno);
		}
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h1>사원검색</h1>
	<form method="post">
		사원명:<input name="ename" value="${sch.ename }"/><br>
		직책:<input name="job" value="${sch.job }"/><br>
		부서명:
		<select name="deptno">
			<c:forEach var="code" items="${deptList }">
				<option value="${code.key }">${code.value }</option>
			</c:forEach>
		</select>
		<button type="submit">검색</button>
	</form>
	<table>
		<tr>
			<th>사원명</th>
			<th>사원번호</th>
			<th>직책</th>
			<th>입사일</th>
			<th>연봉</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${list }">
			<tr>
				<th>${emp.ename }</th>
				<th>${emp.empno }</th>
				<th>${emp.job }</th>
				<th>${emp.hiredate }</th>
				<th>${emp.sal }</th>
				<th>${emp.comm }</th>
				<th>${emp.deptno }</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>