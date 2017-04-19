<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/7
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>鲜花订购系统-用户注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-md-offset-4">
            <h2 class="text-center" style="color: #5bc0de">鲜花礼品网-用户注册</h2><br>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-lg-4 col-md-offset-4 col-md-offset-4">
            <s:form cssClass="form-horizontal" action="userAction!userRegister" method="POST">
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">用户名:</label>
                    <div class="col-md-9 col-lg-9 ">
                        <s:textfield cssClass="form-control" id="username" name="users.userName" placeholder="请输入用户名" onkeydown="clearError(this)" onblur="checkUserName()"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">密码:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:password cssClass="form-control" id="password" name="users.password" placeholder="请输入密码" onkeydown="clearError(this)"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">确认密码:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:password cssClass="form-control" id="eqPassword" placeholder="请再次输入密码" onkeydown="clearError(this)" onkeyup="checkPassword()"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">真实姓名:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:textfield cssClass="form-control" id="realname" name="users.realName" placeholder="请输入姓名" onkeydown="clearError(this)"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">电话号码:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:textfield cssClass="form-control" id="phoneNO" name="users.phoneNo" placeholder="请输入电话号码" onkeydown="clearError(this)" onkeyup="value=value.replace(/\D/g,'')"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">Email:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:textfield cssClass="form-control" id="email" name="users.email" placeholder="xxx@xxx.com" onkeydown="clearError(this)" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">密保问题:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:select list="{'你的第一辆车是什么品牌','你的宠物叫什么名字','你第一台笔记本是什么牌子的'}" cssClass="form-control"
                            name="users.pwdQuestion"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">答案:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:textfield cssClass="form-control" id="answer" name="users.pwdQuestionAnswer" onkeydown="clearError(this)"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 col-lg-3 control-label">地址:</label>
                    <div class="col-md-9 col-lg-9">
                        <s:textfield cssClass="form-control" id="address" name="users.address" onkeydown="clearError(this)"/>
                    </div>
                </div>
                <div class="text-right">
                    <s:reset value="重置" cssClass="btn btn-warning"/>
                    <s:submit value="提交" cssClass="btn btn-primary" onclick="return check()"/>
                </div>
            </s:form>
        </div>
        <%--显示用户名是否可以用--%>
        <div class="col-md-2 col-lg-2">
            <div class="form-group">
                <span class="col-md-12 col-lg-12 form-control-static" id="msg"></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
