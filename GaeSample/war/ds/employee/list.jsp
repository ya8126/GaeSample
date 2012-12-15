<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<meta charset="UTF-8" >
<title>employee list</title>
<style>
table {
	border-collapse:  collapse;
}
th, td{
	border: solid 1px #999;
	padding: 4px;
}
</style>

<table>
	<tr>
		<th>ID</th>
		<th>名前</th>
		<th>入社日</th>
		<th>月給</th>
		<th>懲罰回数</th>
		<th></th>
	</tr>
	<c:forEach var="emp" items="${employees}">
		<tr>
			<td>${emp.key.id }</td>
			<td>${f:h(emp.name) }</td>
			<td>${emp.hireDate }</td>
			<td>${emp.salary }円</td>
			<td>${emp.punishmentCount}回</td>
			<td><a href="/ds/punish/new?employeeId=${emp.key.id}">懲罰する</a></td>
		</tr>
	</c:forEach>		
</table>
