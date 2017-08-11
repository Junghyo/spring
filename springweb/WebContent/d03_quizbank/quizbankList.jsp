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
<link rel="stylesheet" href="${path }/a00_com/a00_com.css">
<script src="${path}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var queType="${quizbank.queType}";
		if(queType!=''){
			$("select[name=queType]").val(queType);
		}	
		$("#schbtn").click(function(){
			$("form").submit();
		});
		// 등록 버튼 클릭시
		$("#regbtn").click(function(){
			// 등록 화면으로 이동!!!
			$(location).attr("href","${path}/quizbank.do?method=insert");
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h3>문제은행</h3>
		<!-- 조회 항목 -->
	<form method="post">
		<table>
			<tr><td>문제</td><td><input type="text" name="que" 
									value="${quizbank.que}"/></td>
				<td>정답</td><td><input type="text" name="coransw"
									value="${quizbank.coransw}"/></td></tr>
			<tr><td>유형</td><td>
					<select name="queType">
						<option value="">전체</option>
						<option >주관식</option>
						<option >객관식</option>
					</select></td>
				<td></td><td>	
			<tr><td colspan="4" style="text-align:right;">
					<input type="button" id="regbtn" value="등록"/>
					<input type="button" id="schbtn" value="검색"/>
				</td></tr>	
		</table>
	</form>
	<table>
		<tr><th width="10%">번호</th><th width="50%">문제</th>
			<th width="20%">정답</th><th width="20%">유형</th>
		</tr>
		<c:forEach var="quiz" items="${quizList}">
			<tr>
				<td>${quiz.no}</td>
				<td>${quiz.que}</td>
				<td>${quiz.coransw}</td>
				<td>${quiz.queType}</td>	
			</tr>
		</c:forEach>
		<c:if test="${quizlist.size()==0}">
			<tr><td colspan="4">검색된 데이터가 없습니다!!</td></tr>
		</c:if>
	</table>
</body>
</html>