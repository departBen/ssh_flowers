<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>鲜花订购网首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../modular/head.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 col-lg--2">
            <s:action name="flowerAction!browseCategory" executeResult="true"></s:action>
        </div>
        <div class="col-md-10 col-lg-10 text-center">
            <div class="jumbotron">
                <div class="container">
                    <h1 class="text-center text-success">添加成功</h1>
                    <p><a class="btn btn-warning btn-lg" href="<%=request.getContextPath()%>/pages/cart.jsp" role="button">进入购物车</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <jsp:include page="../modular/foot.jsp"></jsp:include>
</div>

</body>
</html>
