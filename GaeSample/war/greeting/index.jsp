<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<meta charset=UTF-8">
<title>あいさつサイト</title>

<form action="reply">
	<p>名前：<input type="text" name="name" size~"20"></p>
	<p><input type="submit" value="あいさつする"></p>
</form>