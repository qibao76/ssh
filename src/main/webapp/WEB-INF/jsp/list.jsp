<%@ page  
	contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@taglib prefix="c"  
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<c:import url="/WEB-INF/jsp/nav.jsp"/>
	<h2>用户列表</h2>
	<div>
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>薪资</th>
				<th>功能</th>
			</tr>
			<c:forEach items="${users}" 
				var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.salary}</td>
					<td>
						<a href="edit.action?id=${user.id}">编辑</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
</body>
</html>







