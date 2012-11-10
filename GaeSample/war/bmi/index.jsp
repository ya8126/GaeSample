<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<meta charset=UTF-8" />
<title>bmi計算</title>

<form action="calc">
	<p>身長：<input type="text" name="height" size="6">ｃｍ<br>
	体重<input type="text" name="weight" size="6">ｋｇ</p>
	
	<p><input type="submit" value="計算"></p>
</form>