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
		$("#ename").keyup(function(){
			var sendData = "ename"+$(this).val();
			$.ajax({
				type:"post",
				url:"ajax.do?method=jsonList",
				dataType:"json",
				data:sendData,
				success:function(data){
					// controller의 모델 이름
					var list=data.emplist;
					for(var idx=0; idx<list.length; idx++){
						show+="<h3>"+list[idx].ename+" : "+list.job[idx].job+"</h3>";
					}
					$("#show").html(show);
				}
			});
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h1>emp ajaxList</h1>
	이름:<input id="ename" name="ename"/><br>
	<div id="show">
	</div>
</body>
</html>