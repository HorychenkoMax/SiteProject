<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/header.jsp"%>



<table><tr><td>
<form action='./registration' method='post'>
<table>
<tr><td>login</td><td><input type='text' name='login' value='${login}' /></td></tr>
<tr><td>password</td><td><input type='password' name='password' value='${password}'/></td></tr>
<tr><td>re-password</td><td><input type='password' name='re-password' value='${repassword}'/></td></tr>
<tr><td>name</td><td><input type='text' name='name' value='${name}'/></td></tr>
<tr><td>gender</td><td>M<input type='radio' name='gender' value='male' />F<input type='radio' name='gender' value='female'   /></td></tr>
<tr><td>address</td><td><select  name='address' > 
<option value='Kyiv' >Kyiv</option>
<option value='Kharkiv' >Kharkiv</option>
<option value='Lviv' >Lviv</option>
<option value='Dnipropetrovsk' >Dnipropetrovsk</option>
<option value='Zaporizhzhya' >Zaporizhzhya</option>
<option value='Donetsk' >Donetsk</option>
<option value='Odessa' >Odessa</option>
<option value='Mykolaiv' >Mykolaiv</option>
</select>
</td></tr>
<tr><td>comment</td><td><textarea rows='10' cols='25' name='comment' ></textarea></td></tr>
<tr><td></td><td><input type='submit' value='SEND' /></td></tr>
</table>

</form>
</td><td>${errorText}</td>
</tr></table>


	
					

<%@include file="include/footer.jsp"%>