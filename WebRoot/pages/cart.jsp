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
            <s:set value="#session.cart.detailsMap" id="items"></s:set>

            <s:if test="#items.size!=0">
                <table class="table table-hover">
                    <tr class="info">
                        <th>花名</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>更新</th>
                    </tr>
                    <s:iterator value="#items" id="item">
                        <tr>
                            <s:form action="shoppingAction!updateCart" method="post">
                                <td><s:property value="value.goodsName"/></td>
                                <td><s:property value="value.price"/>元</td>
                                <td><s:textfield name="num" size="4" value="%{value.num}"/></td>
                                <input type="hidden" name="id" value="<s:property value="key"/>">
                                <td><s:submit value="更新" cssClass="btn btn-info"/></td>
                            </s:form>
                        </tr>
                    </s:iterator>
                </table>

                <div class="row">
                    <div class="col-sm-4 col-sm-offset-8 col-md-4 col-md-offset-8">
                        <s:form method="post" action="orderAction">
                            <s:submit value="提交订单" cssClass="btn btn-primary"></s:submit>
                        </s:form>
                    </div>
                </div>
            </s:if>
            <s:else>
                您还没有购买鲜花！
            </s:else>
        </div>
    </div>
</div>
<div class="text-center">
    <jsp:include page="../modular/foot.jsp"></jsp:include>
</div>

</body>
</html>
