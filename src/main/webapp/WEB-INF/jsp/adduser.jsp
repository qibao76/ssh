<%@ page 
	contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<c:import url="/WEB-INF/jsp/nav.jsp"/>
	<h2>添加用户</h2>
	<form action="save.action" method="post">
		<div>
			<label>用户名</label>
			<input type="text" name="user.name"
				value="${user.name}">
			<c:if test="${type==1}">
				<span>${message}</span>
			</c:if>
		</div>
		<div>
			<label>年龄</label>
			<input type="text" name="user.age"
				value="${user.age}">
			<c:if test="${type==2}">
				<span>${message}</span>
			</c:if>
		</div>
		<div>
			<label>薪水</label>
			<input type="text" name="user.salary"
				value="${user.salary}"> 
		</div>
		<div>
			<label>入职日期</label>
			<input type="text" name="user.hiredate"
				value="${user.hiredate}"> 
			<c:if test="${type==4}">
				<span>${message}</span>
			</c:if>
		</div>
		<div>
			<input type="submit"> 
		</div>
	</form>
</body>
</html>



