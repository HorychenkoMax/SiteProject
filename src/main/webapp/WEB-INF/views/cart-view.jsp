<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/header.jsp"%>


<h2>Вы выбрали следующие товары:</h2>
<c:forEach items="${cart}" var="element">
	<table>
		<tr>
			<td></td>
			<td>${element.key.name}</td>
		</tr>
		<tr>
			<td><img src="./static/images/products/${element.key.id}.jpg" width='100px' height="100%" /></td>
			<td>${element.key.description}</td>
		</tr>
		<tr>
			<td>${element.key.price}</td>
			<td>количество товара: ${element.value}
			</td>
		</tr>
	</table>
	<br>
</c:forEach>

<%@include file="include/footer.jsp"%>