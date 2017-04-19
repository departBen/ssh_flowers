<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/7
  Time: 下午3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>鲜花订购系统-用户登陆</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        function check() {
            var username = $("#username").val();
            var password = $("#password").val();
            if (username == "") {
                $("#username").focus();
                $("#username").parent().addClass("has-error");
                return false;
            }
            if (password == "") {
                $("#password").focus();
                $("#password").parent().addClass("has-error");
                return false;
            }
        }
        //清楚错误提示
        function clearError(obj) {
            $(obj).parent().removeClass("has-error")
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row" style="height: 60px">
    </div>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
            <h2 class="text-center" style="color: #5bc0de">用户登陆</h2><br>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
            <s:form action="userAction!userLogin"  method="post">
                <div class="form-group">
                    <s:textfield cssClass="form-control" id="username" name="users.userName" placeholder="请输入用户名" onkeydown="clearError(this)"/>
                </div>
                <div class="form-group">
                    <s:password cssClass="form-control" id="password" name="users.password" placeholder="请输入密码" onkeydown="clearError(this)"/>
                </div>
                <div class="text-left form-group">
                    <a href="<%=request.getContextPath()%>/register.jsp">用户注册</a>
                    <span style="color: red"><s:property value="#request.err"/> </span>
                </div>
                <s:submit value="登陆" cssClass="btn btn-primary form-control" onclick="return check()"/>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>
