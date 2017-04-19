<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>鲜花订购网首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background-color: #eea236">
        <div class="col-md-3 col-lg-3 col-lg-offset-2 col-md-offset-2">
            <h1><span style="color: orangered">鲜</span>花
                <small>订购网</small>
            </h1>
        </div>
        <div class="col-md-2 col-lg-2 col-lg-offset-5 col-md-offset-5">      	
            <s:if test="#session.user !=null">
                <a href="userAction!userLogout.action">注销</a>
                &nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/pages/cart.jsp">购物车</a>
            </s:if>
            <s:else>
                <a href="<%=request.getContextPath()%>/login.jsp">登陆</a>
                <span>/</span>
                <a href="<%=request.getContextPath()%>/register.jsp">注册</a>
                &nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/pages/cart.jsp">购物车</a>
            </s:else>
        </div>
    </div>
</div>

</body>
</html>
