<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_head.jsp' starting page</title>
    
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
    <div class="container-fluid">
		<div class="row" style="background-color: #eea236">
			<div class="col-md-3 col-lg-3 col-lg-offset-2 col-md-offset-2">
				<h1>
					<span style="color: orangered">鲜</span>花 <small>订购网</small>
				</h1>
			</div>
			<div class="col-md-2 col-lg-2 col-lg-offset-5 col-md-offset-5">
				<s:if test="#session.admin !=null">
					<a href="adminAction!adminLogout.action">管理员退出</a>
				</s:if>
			</div>
		</div>
	</div>
  </body>
</html>
