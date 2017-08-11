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
			$(this).css("background","#b3ffb3");
		},function(){
			$(this).css("background","#ffffff");
		})
		$("tr").click(function(){
			var empno = $(this).children(0).html();
//			$(location).attr("href","${path}/empdetail_mybatis.do?empno="+empno); 
			$("input[name=empno]").val(empno);
			$("form").submit();
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h1>empList</h1>
	<form method="post">
		사원명<input name="ename" value="${emp.ename }"/>
		직책	 <input name="job" value="${emp.job }"/>
		<button type="submit">검색</button>
	</form>
	
	<form method="post" action="${path }/empdetail_mybatis.do">
	<input type="hidden" name="empno" value="${emp.empno }"/>
	<table border=1>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>입사일</th>
			<th>관리자번호</th>
			<th>급여</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${emplist }">
			<tr>
				<th>${emp.empno }</th>
				<th>${emp.ename }</th>
				<th>${emp.job }</th>
				<th><fmt:formatDate value="${emp.hiredate }" type="both" pattern="yyyy-MM-dd hh:mm:ss"/></th>
				<th>${emp.mgr }</th>
				<th><fmt:formatNumber value="${emp.sal }"/></th>
				<th>${emp.comm }</th>
				<th>${emp.deptno }</th>
			</tr>
		</c:forEach>
	</table>
	</form>

</body>
</html>