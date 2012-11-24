<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<meta charset="UTF-8">
<title>住所録管理</title>

<style>
	form{
		border: solid 1px #999;
		padding: 0 10px;
	}
</style>

<ul>
	<c:forEach var="e" items="${f:errors()}">
		<li>${f:h(e)}</li>
	</c:forEach>
</ul>

<c:if test="${not empty create}">
	<p>${name}さんを登録しました</p>
</c:if>

<form action="create">
	<p>登録する住所を入力してください</p>
	<p>氏名<input type="text" name="name" value="${name}" class="${f:errorClass('name', 'error')}"></p>
	<p>〒<input type="text" name="zip" value="${zip }" class="${f:errorClass('zip', 'error') }"></p>
	<p>住所１<input type="text" name="addr1" value="${addr1 }" class="${f:errorClass('addr1', 'error') }"></p>
	<p>住所2<input type="text" name="addr2" value="${addr2 }" class="${f:errorClass('addr2', 'error') }"></p>
	<p>電話番号<input type="tel" name="tel" value="${tel }" class="${f:errorClass('tel', 'error') }"></p>
	<p>メール<input type="email" name="email" value="${email }" class="${f:errorClass('email', 'error') }"></p>
	<p><input type="submit" value="登録"></p>
</form>

<p><a href="list">一覧表</a></p>