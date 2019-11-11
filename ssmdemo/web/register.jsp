<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/11/6
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/user/register" method="post">
    <p>用户名：<input type="text" name="username"/></p>
    <p>性别：<input type="text" name="sex"/></p>
    <p>地址：<input type="text" name="address"/></p>
    <p><input type="submit" value="提交"></p>
  </form>
<%--<br/>
  <a href="${pageContext.request.contextPath}/user/register?username='张三'&sex='男'&address='深圳'">get方式提交</a>--%>
  </body>
</html>
