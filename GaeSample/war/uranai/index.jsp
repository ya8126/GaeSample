<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<meta charset=UTF-8">
<title>うらないサイト</title>

<form action="result">
	<div><select name="bloodType">
		<option value="1">A型</option>
		<option value="2">B型</option>
		<option value="3">O型</option>
		<option value="4">AB型</option>
	</select></div>
	<p><input type="submit" value="占ってみる"></p>
</form>