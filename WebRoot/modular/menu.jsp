<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/8
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
</head>
<body>
<h4 class="text-center bg-info text-primary"><a href="<%=request.getContextPath()%>/index.jsp">首页</a></h4>
<h4 class="text-center bg-info text-warning">鲜花分类</h4>
<s:iterator value="#request.categories" id="catalog">
    <a class="btn btn-default btn-lg btn-block" href="flowerAction!browseFlowerByPage.action?category.id=<s:property value=
		    "#catalog.id"/>&currentPage=1"><s:property value="#catalog.categoryName"/></a>
</s:iterator>

</body>
</html>
