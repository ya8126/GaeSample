<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta charset=UTF-8" />
<title>bmi計算</title>

<p>${height}cm ${weight}ｋｇのあなたのBMIは、
<fmt:formatNumber value="${bmi}" maxFractionDigits="2" />です。</p>
