<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<meta charset=UTF-8">
<title>足し算サイト</title>

<style>
.error {
	background-color: pink;
}
</style>

<ul>
<c:forEach var="e" items="${f:errors()}">
	<li>${f:h(e)}</li>
</c:forEach> 
</ul>
<form action="calc" method="post">
	<p>
		<input class="${f:errorClass('num1', 'error')}" type="text" name="num1" size="4" value="${num1}"> +
		<input class="${f:errorClass('num2', 'error')}" type="text" name="num2" size="4" value="${num2}"> =
	</p>
	<p>
		<input type="submit" value="計算">
	</p>
</form>