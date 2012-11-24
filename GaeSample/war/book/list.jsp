<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<meta charset="UTF-8">
<title>書籍管理</title>

<style>
	#book{
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

<c:if test="${empty books}">
	<p>書籍が登録されていません</p>
</c:if>

<c:if test="${not empty books}">
	<table id="book">
		<tr>
			<th>タイトル</th><th>著者名</th><th>価格</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${f:h(book.title)}</td>
				<td>${f:h(book.name)}</td>
				<td class="number">${f:h(book.price)}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<p><a href="index">登録に戻る</a><p>