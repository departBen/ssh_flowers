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
		var flowerName = $("#flowerName").val();
		var flowerDesc = $("#flowerDesc").val();
		var price = $("#price").val();
		if (flowerName == "") {
			$("#flowerName").focus();
			$("#flowerName").parent().addClass("has-error");
			return false;
		}
		if (flowerDesc == "") {
			$("#flowerDesc").focus();
			$("#flowerDesc").parent().addClass("has-error");
			return false;
		}
		if (price == "") {
			$("#price").focus();
			$("#price").parent().addClass("has-error");
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
        			<div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
            			<h2 class="text-center" style="color: #5bc0de">增加鲜花</h2><br>
       				 </div>
    			</div>
				<div class="row">
					<!-- 控制只能输入金额 -->
					<script type="text/javascript">
						function clearNoNum(obj) {
							obj.value = obj.value.replace(/[^\d.]/g, "");
							obj.value = obj.value.replace(/\.{2,}/g, ".");
							obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
							obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, "$1$2.$3");
							if (obj.value.indexOf(".") < 0 && obj.value != "") {
								obj.value = parseFloat(obj.value);
							}
						}
						function clearAgio(obj) {
							obj.value = obj.value.replace(/\D/g, "");
						}
					</script>
					<div class="col-md-7 col-xm-7 col-md-offset-2 col-xm-offset-2">
						<s:form cssClass="form-horizontal" method="post" action="adminAction!addOrUpdateFlower" enctype="multipart/form-data">
							<div class="form-group">
								 <label
									class="col-md-3 col-lg-3 control-label">鲜花名称:</label>
								<div class="col-md-9 col-lg-9 ">
									<s:textfield cssClass="form-control" id="flowerName"
										name="flower.goodsName" placeholder="鲜花名"
										onkeydown="clearError(this)" />
								</div>
							</div>
							<div class="form-group">
								 <label
									class="col-md-3 col-lg-3 control-label">商品描述:</label>
								<div class="col-md-9 col-lg-9 ">
									<s:textfield cssClass="form-control" id="flowerDesc"
										name="flower.description" placeholder="商品简介说明"
										onkeydown="clearError(this)" />
								</div>
							</div>
							<div class="form-group">
								 <label
									class="col-md-3 col-lg-3 control-label">鲜花分类:</label>
								<div class="col-md-9 col-lg-9 ">
									<s:set value="#request.categories" var="catelist"></s:set>
									<s:select list="catelist" listKey="id" listValue="categoryName" value="bean.id" name="flower.category.id" cssClass="form-control"></s:select>
								</div>
							</div>
							<div class="form-group">
								 <label
									class="col-md-3 col-lg-3 control-label">鲜花价格:</label>
								<div class="col-md-9 col-lg-9 ">
									<s:textfield cssClass="form-control" id="price"
										name="flower.price" placeholder="价格"
										onkeydown="clearError(this)" onkeyup="clearNoNum(this)" />
								</div>
							</div>
							<div class="form-group">
   								 <label class="col-md-3 col-lg-3 control-label">鲜花图片:</label>
    								<s:file name="upload"></s:file>
    								<p class="help-block">单击这里上传鲜花图片.</p>
  							</div>
  							<input type="hidden" value="<s:property value='#request.flower.imgUrl'/>" name="pictureUrl">
  							<input type="hidden" value="<s:property value='#request.flower.id'/>" name="id">
  							<input type="hidden" value="<s:property value='#request.currentPage'/>" name="currentPage">
							<div class="text-right">
								<s:reset value="取消" cssClass="btn btn-warning" />
								<s:submit value="提交" cssClass="btn btn-primary"
									onclick="return check()" />
							</div>
							<div>
								<p class="text-success" id="msg">
									<s:property value="#request.msg" />
								</p>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
