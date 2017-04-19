<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>鲜花订购网首页</title>
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript">
        function check() {
        	var categoryName = $("#categoryName").val();
            if (categoryName == "") {
                $("#categoryName").focus();
                $("#categoryName").parent().addClass("has-error");
                return false;
            }
        }
        //清楚错误提示
        function clearError(obj) {
            $(obj).parent().removeClass("has-error")
            $("#msg").html("");
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
				<div class="row">
					<div class="col-md-7 col-xm-7 col-md-offset-2 col-xm-offset-2">
						<s:form cssClass="form-horizontal" method="post" action="adminAction!addCategory">
							<div class="form-group">
								<br> <br> <br> <label
									class="col-md-3 col-lg-3 control-label">分类名:</label>
								<div class="col-md-9 col-lg-9 ">
									<s:textfield cssClass="form-control" id="categoryName"
										name="category.categoryName" placeholder="分类名"
										onkeydown="clearError(this)"/>
								</div>
							</div>
							<div class="text-right">
								<s:reset value="取消" cssClass="btn btn-warning" />
								<s:submit value="提交" cssClass="btn btn-primary"  onclick="return check()"/>
							</div>
							<div>
							 	<p class="text-success" id="msg"><s:property value="#request.msg"/></p>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
