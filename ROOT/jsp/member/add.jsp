<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/jsp/path.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/member/add.js"></script>
<title>新增家庭成员</title>
</head>
<body>
	<form id="addForm">
		<span>姓名：<input id="name" name="name" /></span> <span>登陆名：<input
			id="loginName" name="loginName" /></span> <span>性别：<select
			class="gender" id="gender" name="gender">
				<option value="1">男</option>
				<option value="0">女</option>
		</select></span><br />
		<br /> <span><input type="button" class="save" value="提交"></span>
	</form>
</body>
</html>