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
        <div class="col-md-10 col-lg-10">
            <div class="container-fluid">
                <div class="row">
                    <s:iterator value="#request.flowers" id="flower">
                        <div class="col-md-3">
                            <s:form action="shoppingAction!addToCart" method="POST">
                                <div class="thumbnail">
                                    <img src="<%=request.getContextPath()%>/pic/<s:property value='#flower.imgUrl'/>"/>
                                    <div class="caption">
                                        <h5 class="text-center text-info"><s:property value="#flower.goodsName"/><br>
                                            <small><s:property value="#flower.price"/>元</small>
                                        </h5>
                                        <p class="text-center">
                                            数量<s:textfield size="4" name="num" onkeyup="value=value.replace(/\D/g,'')"></s:textfield>
                                            <input type="hidden" name="flower.id" value="<s:property value='#flower.id' />">
                                            <s:submit value="购买"></s:submit>
                                        </p>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </s:iterator>
                </div>
                <div class="row">
                    <s:set name="pager" value="#request.page"/>
                    <s:if test="#pager.hasFirst">
                        <a href="flowerAction!browseFlowerByPage.action?category.id=<s:property value='#request.category.id'/>&currentPage=1">首页</a>
                    </s:if>
                    <s:if test="#pager.hasPrevious">
                        <a href="flowerAction!browseFlowerByPage.action?category.id=<s:property value='#request.category.id'/>&currentPage=<s:property  value='#pager.currentPage-1'/>">上一页</a>
                    </s:if>
                    <s:if test="#pager.hasNext">
                        <a
                                href="flowerAction!browseFlowerByPage.action?category.id=<s:property value='#request.category.id'/>&currentPage=<s:property  value='#pager.currentPage+1'/>">下一页</a>
                    </s:if>
                    <s:if test="#pager.hasLast">
                        <a
                                href="flowerAction!browseFlowerByPage.action?category.id=<s:property value='#request.category.id'/>&currentPage=<s:property  value='#pager.totalPage'/>">尾页</a>
                    </s:if>
                    <br>
                    当前第
                    <s:property value="#pager.currentPage"/>
                    页, 总共
                    <s:property value="#pager.totalPage"/>
                    页
                </div>
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
