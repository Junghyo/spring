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
<link rel="stylesheet" href="${path}/a00_com/a00_com.css" >	
<script src="${path}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
//		검색버튼 클릭시		
		$("#schBtn").click(function(){
			$("form").submit();
		});
//		등록버튼 클릭시 등록화면으로 이동		
		$("#regBtn").click(function(){
			$(location).attr("href","${path}/boardex.do?method=insert");
		});
		$(".data").dblclick(function(){
			var no = $(this).attr("id");
			$(location).attr("href","${path}/boardex.do?method=detail&no="+no);
		});
		$("#initBtn").click(function(){
			$(".option").val("");
		});
		$("select[name=pageSize]").val("${boardSch.pageSize}");
		$("select[name=pageSize]").change(function(){
			$("form").attr("action", "${path}/boardex.do?method=list");
			$("form").submit();
		});
	});
	function go(curPage){
		$("#curPage").val(curPage);
		$("form").attr("action", "${path}/boardex.do?method=list");
		$("form").submit();
	}
</script>
<style type="text/css">
	h3{text-align:center;}
	table{margin:auto;}
</style>
</head>
<body>
	<h3>게시판</h3>
	<!-- 조회 항목 -->
	<form method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" class="option" name="subject" value="${boardSch.subject }" /></td>
				<td>작성자</td>
				<td><input type="text" class="option" name="writer" value="${boardSch.writer }" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" class="option" name="content" value="${boardSch.content }" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: right;">
					<input type="button" id="regBtn" value="등록" />
					<input type="button" id="initBtn" value="초기화" />
					<input type="button" id="schBtn" value="검색" />
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td> 총: ${boardList.size() }건</td>
			</tr>
			<tr>
				<td style="text-align:right;">
					페이지 크기
					<select name="pageSize" id="pageSize">
						<option>3</option>
						<option>5</option>
						<option>10</option>
						<option>20</option>
					</select>
					<input type="hidden" name="curPage" value="1" id="curPage"/>
				</td>
			</tr>	
		</table>
		<table>
			<tr>
				<th width="5%">번호</th>
				<th width="50%">제목</th>
				<th width="15%">작성자</th>
				<th width="15%">작성일</th>
				<th width="15%">조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
				<tr class="data" id="${board.no }">
					<td>${board.rowcnt }</td>
					<!-- 답글의 level만큼 공백과 답글이라는 이미지 표시 -->
					<td style="text-align: left;"><c:forEach varStatus="sts"
							begin="1" end="${board.lv }">
							&nbsp;&nbsp;
							<c:if test="${board.lv>1 and sts.last }">
								▶
							</c:if>
						</c:forEach> ${board.subject }</td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate }"
							pattern="yyyy/MM/dd" /></td>
					<td>${board.readcount }</td>
				</tr>
			</c:forEach>
			<c:if test="${boardList.size()==0 }">
				<tr>
					<td colspan="5">작성된 글이 없습니다!!</td>
				</tr>
			</c:if>
		</table>
		<!-- 하단 page block [1][2][3]...-->
		<c:forEach var="cnt" begin="1" end="${boardSch.pageCount }">
			<a href="javascript:go(${cnt })">[${cnt }]</a>
		</c:forEach>
	</form>
</body>
</html>