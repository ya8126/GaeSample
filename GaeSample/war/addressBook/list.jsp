<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<meta charset="UTF-8">
<title>住所録管理</title>

<style>
	#addressBook{
		border-collapse: collapse;
	}
	th, td{
		padding: 5px;
		border: solid 1px #999;
	}
	.number{
		text-align: right;
	}
</style>

<c:if test="${empty addressBook}">
	<p>住所が1つも登録されていません</p>
</c:if>

<c:if test="${not empty addressBook}">
	<table id="addressBook">
		<tr>
			<th>氏名</th><th>〒</th><th>住所</th><th>TEL</th><th>メール</th>
		</tr>
		<c:forEach var="address" items="${addressBook}">
			<tr>
				<td>${f:h(address.name)}</td>
				<td>${f:h(address.zip)}</td>
				<td>${f:h(address.addr1)}<br />${f:h(address.addr2)}</td>
				<td>${f:h(address.tel)}</td>
				<td>${f:h(address.email)}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<p><a href="index">登録に戻る</a><p>