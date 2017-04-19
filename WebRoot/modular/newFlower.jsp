<%--
  Created by IntelliJ IDEA.
  User: ben
  Date: 2017/4/8
  Time: 下午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
</head>
<body>
<div>

    <div>新品展示</div>
    <br>
    <s:set value="#request.newFlowers" id="newflower"></s:set>
    <s:iterator value="#newflower" id="flower">
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

</body>
</html>
