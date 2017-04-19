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
						<th>订单编号</th>
						<th>用户编号</th>
						<th>姓名</th>
						<th>商品总数</th>
						<th>商品总价</th>
						<th>用户地址</th>
						<th>下单时间</th>
					</tr>
					<s:set value="#request.orders" id="orders"></s:set>
					<s:iterator value="#orders" id="order">
						<tr>
							<td><s:property value="#order.ordersId" /></td>
							<td><s:property value="#order.users.id" /></td>
							<td><s:property value="#order.users.realName" /></td>
							<td><s:property value="#order.num" /></td>
							<td><s:property value="#order.sum" /></td>
							<td><s:property value="#order.users.address" /></td>
							<td><s:date name="#order.createTime" format="yyyy-MM-dd"/>
							</td>
						</tr>
					</s:iterator>
				</table>
				<div class="row">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="adminAction!ordersPagging.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="adminAction!ordersPagging.action?currentPage=<s:property  value='#pager.currentPage-1'/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="adminAction!ordersPagging.action?currentPage=<s:property  value='#pager.currentPage+1'/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="adminAction!ordersPagging.action?currentPage=<s:property  value='#pager.totalPage'/>">尾页</a>
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
