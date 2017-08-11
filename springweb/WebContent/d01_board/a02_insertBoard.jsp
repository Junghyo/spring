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
		$("#listBtn").click(function(){
			$(location).attr("href","${path}/boardex.do?method=list");
		});
	});
</script>
<style type="text/css">
	h3{text-align: center;}
</style>
</head>
<body>
	<h3>게시판 등록</h3>
	<form method="post" action="${path}/boardex.do?method=insProc">
		<input type="hidden" name="refno" value="${board.refno }"/>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${board.subject }" size="50"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${board.writer }" size="50"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pwd" value="${board.pwd }" size="50"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${board.email }" size="50"/></td>
			</tr>
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" cols="100" rows="50">${board.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"/>
					<input type="button" id="listBtn" value="취소"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>