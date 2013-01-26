<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!DOCTYPE html>
<meta charset="UTF-8">
<title>お店一覧</title>

<style>
table{
	border-collapse: collapse;
}
th, td{
	border: solid 1px #999;
	padding: ４px;
}
</style>

<table>
	<tr>
		<th>ID</th>
		<th>店名</th>
		<th></th>
	</tr>
	<c:forEach var="shop" items="${shops }">
		<tr>
			<td>${shop.key.id }</td>
			<td>${shop.name }</td>
			<td><a href="../saleItem/list?shopId=${shop.key.id }">店舗へ</a></td>
		</tr>
	</c:forEach>
</table>