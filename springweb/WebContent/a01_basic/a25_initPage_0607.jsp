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
		$("#init").click(function(){
			$("#phase").val("1");
			$("form").submit();
		});
		$("#save").click(function(){
			$("#phase").val("2");
			$("form").submit();
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<form method="post">
		<input type="hidden" name="phase"  id="phase" value="0"/>
		<table>
			<tr>
				<th>구매물건</th>
				<th>가격</th>
				<th>갯수</th>
			</tr>
			<tr>
				<th>사과</th>
				<th><input type="number" name="price"/></th>
				<th><input type="number" name="cnt"/></th>
			</tr>
			<tr>
				<th colspan="3">
					<input type="button" id="init" value="구매금액 초기화면"/>
					<input type="button" id="save" value="구매금액누적처리"/>
				</th>
			</tr>								
		</table>
	</form>
</body>
</html>