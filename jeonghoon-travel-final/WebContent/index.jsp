<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" 
	  xmlns:f="http://java.sun.com/jsf/core">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	
	<body>
		<f:view>
			<h1>Web Service Spring REST Project</h1>
			<hr>
			
			<a href="${pageContext.request.contextPath}/test/welcome">Test page</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers">1. List of Passengers in JSON</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/1">2. Get a passenger id 1</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/find/Smith">3. find passengers whose family name is Smith</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/city/Toronto">4. Show list of passengers (destination city == Toronto)</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/sorted/family">5. Show list of passengers ordered by family</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/find/date/2019-05-11">6. Show list of all passengers by departure date (2019-05-11)</a>
			<br></br>
			<a href="${pageContext.request.contextPath}/api/passengers/find/date/2019-05-11/city/Toronto">7. Show list of all passengers by departure date (2019-05-11) and destination city (Toronto)</a>
		</f:view>
	</body>
	
</html>