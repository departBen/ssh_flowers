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
						<th>用户编号</th>
						<th>用户名</th>
						<th>姓名</th>
						<th>密保问题</th>
						<th>密保答案</th>
						<th>修改</th>
					</tr>
					<s:set value="#request.users" id="users"></s:set>
					<s:iterator value="#users" id="user">
						<tr>
							<td><s:property value="#user.id" /></td>
							<td><s:property value="#user.userName" /></td>
							<td><s:property value="#user.realName" /></td>
							<td><s:property value="#user.pwdQuestion" /></td>
							<td><s:property value="#user.pwdQuestionAnswer" /></td>
							<td><a href="adminAction!userEditView.action?user.id=<s:property value='#user.id'/>&currentPage=<s:property  value='#request.page.currentPage'/>" class="btn btn-warning">修改</a></td>
						</tr>
					</s:iterator>
				</table>
				<div class="row">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="adminAction!userManagerPagging.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="adminAction!userManagerPagging.action?currentPage=<s:property  value='#pager.currentPage-1'/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="adminAction!userManagerPagging.action?currentPage=<s:property  value='#pager.currentPage+1'/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="adminAction!userManagerPagging.action?currentPage=<s:property  value='#pager.totalPage'/>">尾页</a>
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
