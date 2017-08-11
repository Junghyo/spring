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
		$("#goList").click(function(){
			$(location).attr("href","${path}/emplist_mybatis.do");
		})
	});
</script>
<style type="text/css">
	body{text-align:center;}
	table{margin:auto; width:70%;}
	th{width:50%;}
</style>
</head>
<body>
	<h2>사원 상세정보</h2>
	<form method="post" action="${path }/emp_upt.do">
		<input type="hidden" name="empno" value="${emp.empno }"/>
		<table border=1>
			<tr>
				<th>사원번호</th>
				<th>${emp.empno }</th>
			</tr>
			<tr>
				<th>사원명</th>
				<th><input name="ename" value="${emp.ename }"/></th>
			</tr>
			<tr>
				<th>직책</th>
				<th><input name="job" value="${emp.job }"/></th>
			</tr>
			<tr>
				<th>입사일</th>
				<th>${emp.hiredate }</th>
			</tr>
			<tr>
				<th>관리자번호</th>
				<th><input name="mgr" type="number" value="${emp.mgr }"/></th>
			</tr>
			<tr>
				<th>급여</th>
				<th><input name="sal" type="number" value="${emp.sal }"/></th>
			</tr>
			<tr>
				<th>보너스</th>
				<th><input name="comm" type="number" value="${emp.comm }"/></th>
			</tr>
			<tr>
				<th>부서번호</th>
				<th><input name="deptno" type="number" value="${emp.deptno }"/></th>
			</tr>						
			<tr>
				<th colspan="2">
					<input type="submit" value="수정"/>
					<input type="button" id="goList" value="메인화면"/>
				</th>		
			</tr>																
		</table>
	</form>
</body>
</html>