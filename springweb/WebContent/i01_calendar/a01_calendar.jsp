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
<link href='${path }/i00_calendar_ui/fullcalendar.min.css' rel='stylesheet' />
<link href='${path }/i00_calendar_ui/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='${path }/i00_calendar_ui/lib/moment.min.js'></script>
<script src='${path}/i00_calendar_ui/lib/jquery.min.js'></script>
<script src='${path }/i00_calendar_ui/fullcalendar.min.js'></script>
<script type="text/javascript">
	var dteinfo;

	$(document).ready(function() {
		$.ajax({
			type : "post",
			url : "calendar.do?method=list",
			dataType : "json",
			success : function(data) {
				dteinfo=data.calendarList;
				loadView();
			}
		});
	});
	function loadView() {
		$('#calendar').fullCalendar(
				{
					header : {
						left : 'prev,next today',
						center : 'title',
						right : 'month,agendaWeek,agendaDay'
					},
					defaultDate : '2017-06-29',
					navLinks : true, // can click day/week names to navigate views
					selectable : true,
					selectHelper : true,
					select : function(start, end) {
						var title = prompt('Event Title:');
						var eventData;
						if (title) {
							eventData = {
								title : title,
								start : start,
								end : end
							};
							$('#calendar').fullCalendar('renderEvent',
									eventData, true); // stick? = true
						}
						$('#calendar').fullCalendar('unselect');
					},
					editable : true,
					eventLimit : true, // allow "more" link when too many events
					events : dteinfo
				});
	}
</script>
<style type="text/css">
body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>