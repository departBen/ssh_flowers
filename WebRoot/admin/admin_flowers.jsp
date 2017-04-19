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
</head>
<body>
	<jsp:include page="admin_head.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-lg--2">
				<jsp:include page="admin_mean.jsp"></jsp:include>
			</div>
			<div class="col-md-10 col-lg-10">
				<table class="table table-hover">
					<tr class="info">
						<th>花名</th>
						<th>价格</th>
						<th>说明</th>
						<th>图片地址</th>
						<th>操作</th>
					</tr>
					<s:set value="#request.flowers" id="flowers"></s:set>
					<s:iterator value="#flowers" id="flower">
						<tr>
							<td><s:property value="#flower.goodsName" /></td>
							<td><s:property value="#flower.price" /></td>
							<td><s:property value="#flower.description" /></td>
							<td><s:property value="#flower.imgUrl" /></td>
							<td><a href="adminAction!deleteFolwers.action?flower.id=<s:property value='#flower.id'/>"
								class="btn btn-warning">删除</a> <a
								href="adminAction!editFlowerView.action?flower.id=<s:property value='#flower.id'/>&currentPage=<s:property  value='#request.page.currentPage'/>" class="btn btn-primary">修改</a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<div class="row">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="adminAction!browseFlowersBypage.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="adminAction!browseFlowersBypage.action?currentPage=<s:property  value='#pager.currentPage-1'/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="adminAction!browseFlowersBypage.action?currentPage=<s:property  value='#pager.currentPage+1'/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="adminAction!browseFlowersBypage.action?currentPage=<s:property  value='#pager.totalPage'/>">尾页</a>
				</s:if>
				<br> 当前第
				<s:property value="#pager.currentPage" />
				页, 总共
				<s:property value="#pager.totalPage" />
				页
			</div>
			</div>
		</div>
	</div>
</body>
</html>
