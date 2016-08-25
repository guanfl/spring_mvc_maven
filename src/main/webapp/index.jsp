<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SpringMVC的示例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="user.htm?method=list">查看用户列表</a><br/><br/>
    <a href="user.htm?method=add">新增用户</a><br/><br/>
    <a href="user.htm?method=delete&id=123">删除用户</a><br/><br/>
    <a href="user.htm?method=edit&id=123">编辑用户</a><br/><br/>
    
    <hr/>
    <a href="acc/list.htm">查看用户列表</a><br/><br/>
    <a href="acc/add.htm">新增用户</a><br/><br/>
    <a href="acc/delete.htm?id=123">删除用户</a><br/><br/>
    <a href="acc/edit.htm&id=123">编辑用户</a><br/><br/>
    
    <a href="xlsview/user_export">UserExcelExport</a><br/><br/>
  </body>
</html>
