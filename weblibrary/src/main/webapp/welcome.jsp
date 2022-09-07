<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./resource/css/bootstrap.min.css" />
<meta name="viewport" content="width-device-width">
<meta charset="UTF-8">
<title>Welcome!</title>
</head>
<body>
	<%@ include file = "menu.jsp" %>
	<%!String greeting = "Welcome";%>
	<div class="jumbotron">
		<div class="container">
			<h4 class="display-1"> 
			<a img background: url("/upload/library.jpg") center no-repeat;>
				<%=greeting%>
			</a></h4>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<%
				response.setIntHeader("Refresh", 3);
				Date day = new java.util.Date();
				String am_pm;
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				if (hour / 12 == 0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
					hour = hour - 12;
				}
				String CT = hour + ":" + minute + ":" + second + " " + am_pm;
				out.println("현재 접속  시각: " + CT + "\n");
			%>
		</div>
		<hr>
	</div>	
</body>
</html>