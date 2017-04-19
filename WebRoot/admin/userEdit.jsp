<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>鲜花订购网首页</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript">
	function check() {
		var password1 = $("#password").val();
		var phoneNO = $("#phoneNO").val();
		var email = $("#email").val();
		var answer = $("#answer").val();
		var address = $("#address").val();
		if (password1 == "") {
			$("#password").focus();
			$("#password").parent().addClass("has-error");
			return false;
		}
		if (phoneNO == "") {
			$("#phoneNO").focus();
			$("#phoneNO").parent().addClass("has-error");
			return false;
		}
		if (email == "") {
			$("#email").focus();
			$("#email").parent().addClass("has-error");
			return false;
		}
		if (answer == "") {
			$("#answer").focus();
			$("#answer").parent().addClass("has-error");
			return false;
		}
		if (address == "") {
			$("#address").focus();
			$("#address").parent().addClass("has-error");
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
	<jsp:include page="admin_head.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-lg--2">
				<jsp:include page="admin_mean.jsp"></jsp:include>
			</div>
			<div class="col-md-10 col-lg-10">
				<br> <br>
				<div class="col-md-6 col-lg-6 col-md-offset-2 col-lg-offset-2">
					<s:form cssClass="form-horizontal" action="adminAction!userEdit"
						method="POST">
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">用户名:</label>
							<div class="col-md-9 col-lg-9 ">
								<p class="form-control-static">
									<s:property value="user.userName" />
								</p>
								<input type="hidden"
									value='<s:property value="user.userName" />' name="userName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">真实姓名:</label>
							<div class="col-md-9 col-lg-9">
								<p class="form-control-static">
									<s:property value="user.realName" />
								</p>
								<input type="hidden"
									value='<s:property value="user.realName" />' name="realName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">密码:</label>
							<div class="col-md-9 col-lg-9">
								<s:password cssClass="form-control" id="password"
									name="user.password" onkeydown="clearError(this)" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">电话号码:</label>
							<div class="col-md-9 col-lg-9">
								<s:textfield cssClass="form-control" id="phoneNO"
									name="user.phoneNo" onkeydown="clearError(this)"
									onkeyup="value=value.replace(/\D/g,'')" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">Email:</label>
							<div class="col-md-9 col-lg-9">
								<s:textfield cssClass="form-control" id="email"
									name="user.email" onkeydown="clearError(this)" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">密保问题:</label>
							<div class="col-md-9 col-lg-9">
								<s:select list="{'你的第一辆车是什么品牌','你的宠物叫什么名字','你第一台笔记本是什么牌子的'}"
									cssClass="form-control" name="user.pwdQuestion" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">答案:</label>
							<div class="col-md-9 col-lg-9">
								<s:textfield cssClass="form-control" id="answer"
									name="user.pwdQuestionAnswer" onkeydown="clearError(this)" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 col-lg-3 control-label">地址:</label>
							<div class="col-md-9 col-lg-9">
								<s:textfield cssClass="form-control" id="address"
									name="user.address" onkeydown="clearError(this)" />
							</div>
						</div>
						<input type="hidden"
							value="<s:property value='#request.user.id'/>" name="id">
						<input type="hidden"
							value="<s:property value='#request.currentPage'/>"
							name="currentPage">
						<div class="text-right">
							<s:reset value="重置" cssClass="btn btn-warning" />
							<s:submit value="提交" cssClass="btn btn-primary"
								onclick="return check()" />
						</div>
					</s:form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
