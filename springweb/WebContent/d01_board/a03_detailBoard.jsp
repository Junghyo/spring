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
		$("#refBtn").click(function(){
			var no = $("input[name=no]").val();
			$(location).attr("href", "${path}/boardex.do?method=insert&no="+no);
			
		});
		$("#listBtn").click(function(){
			$(location).attr("href","${path}/boardex.do?method=list");
		});
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<h2>게시판 상세</h2>
	<form method="post" action="${path}/boardex.do?method=insProc">
		<input type="hidden" name="refno" size="50" value="${board.no}"/>
		<table>
			<tr>
				<td width="30%">글번호</td>
				<td>${board.no}<input type="hidden" name="no" size="50" value="${board.no}"/></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.readcount }</td>
			</tr>		
			<tr>
				<td >제목</td>
				<td><input type="text" name="subject" value="${board.subject}" size="50"/></td>
			</tr>		
			<tr>
				<td>패드워드</td>
				<td><input type="password" name="pwd"  value="${board.pwd}" size="50"/></td>
			</tr>		
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" size="50" value="${board.writer}"/></td>
			</tr>		
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="50" value="${board.email}"/></td>
			</tr>		
			<tr>
				<td >내용</td>
				<td><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="button" id="refBtn" value="답글달기"/>
					<input type="button" id="uptBtn"  value="수정"/>
					<input type="button" id="delBtn"  value="삭제"/>		
					<input type="button" id="listBtn"  value="목록"/>		
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>