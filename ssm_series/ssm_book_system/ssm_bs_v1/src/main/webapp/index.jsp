<%@ page contentType="text/html;charset=UTF-8"%>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>PRIMARY BookSystem <a style="color:lawngreen">V1</a></h2>
目前包含: <br />
简单的查询、分页、redis缓存. <span style="color:red" > [new] </span> <br />
<br /><br />
图书系统：<a href="<%=appPath%>/book/list">GOTO</a>
</body>
</html>
