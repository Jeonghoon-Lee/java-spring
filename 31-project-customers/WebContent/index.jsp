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
			<a href="${pageContext.request.contextPath}/api/customers">List of Customers in JSON</a>
		</f:view>
	</body>
	
</html>