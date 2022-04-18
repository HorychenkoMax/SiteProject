<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/header.jsp"%>
<script src='./static/scripts/jquery-3.6.0.js'></script>


<c:forEach items="${productList}" var="element">
	<table>
		<tr>
			<td></td>
			<td>${element.name}</td>
		</tr>
		<tr>
			<td><img src="./static/images/products/${element.id}.jpg" width='100px' height="100%" /></td>
			<td>${element.description}</td>
		</tr>
		<tr>
			<td>${element.price}</td>
			<td>
				<img src='./static/images/minus.jpg' width='15' height='15' onclick="minus(${element.id})" /> 
				<input type='text' id='${element.id}' size='2' value='1' /> 
				<img src='./static/images/plus.png' width='15' height='15' onclick="plus(${element.id})" /> 
				<input type='button' value='buy' onclick="buy(${element.id})" />
			</td>
		</tr>
	</table>
	<br>
</c:forEach>

<script>
	function minus(id) {
		document.getElementById(id).value = document.getElementById(id).value - 1;
	}

	function plus(id) {
		document.getElementById(id).value = +document.getElementById(id).value
				+ +1;
	}

	function buy(id) {
		$.ajax({
			url: './cart',
			method: 'post',
			data: {'id': id, 'numberOfProduct': document.getElementById(id).value},
			success: function(data){
				document.getElementById('span').innerHTML = data;
			}
		});
		//alert(id + " : " + document.getElementById(id).value);
	}
</script>

<%@include file="include/footer.jsp"%>