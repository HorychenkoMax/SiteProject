<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/header.jsp"%>


<br>	
	<form action='./login' method='post' >
	<input type='text' name='login' placeholder='login@login.com'/>
	<input type='password' name='password' placeholder='password'/>
	<input type='submit' value='SEND' />
	</form>
	
					

<%@include file="include/footer.jsp"%>