<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>广告后台管理系统</title>
<script type="text/javascript" src="/Advertisement_Service/JS/common/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
$(function(){alert()});
</script>
</head>
<body>
	<form action="/Advertisement_Service/service/manager.action"
		method="post">
		<table align="center" style="text-align: center;">
			<tr>
				<td colspan="2" style="padding-top: 100px; padding-bottom: 50px"><h1>管理员登录</h1></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" style="width: 100%"
					value="admin" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password" style="width: 100%"
					value="admin" /></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-top: 50px; text-align: center;"><input
					type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="关闭" onclick="window.close()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>