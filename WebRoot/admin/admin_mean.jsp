<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'admin_mean.jsp' starting page</title>

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
	<a class="btn btn-default btn-lg btn-block"
		href="<%=request.getContextPath()%>/admin/admin_index.jsp">添加新分类</a>
	<a class="btn btn-default btn-lg btn-block" href="adminAction!addFlowersView.action">添加新花品</a>
	<a class="btn btn-default btn-lg btn-block" href="adminAction!browseFlowersBypage.action">管理花品</a>
	<a class="btn btn-default btn-lg btn-block" href="adminAction!ordersPagging.action">订单查询</a>
	<a class="btn btn-default btn-lg btn-block" href="adminAction!userManagerPagging.action">顾客账号管理</a>
</body>
</html>
