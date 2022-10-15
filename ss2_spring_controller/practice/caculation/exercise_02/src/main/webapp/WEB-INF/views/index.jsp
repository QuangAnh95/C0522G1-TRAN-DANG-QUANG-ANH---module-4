<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 9/30/2022
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>

  <form action="/convert" method="get">
<%--     Khi khai báo number thì không cần bắt lỗi nhập chữ--%>
    <input type="number" name="num1">
    <input type="number" name="num2">

    <br>
    <br>

    <input type="submit" name="choose" value="+">
    <input type="submit" name="choose" value="-">
    <input type="submit" name="choose" value="*">
    <input type="submit" name="choose" value="/">

  </form>

  <h6>${result}</h6>
  </body>
</html>
