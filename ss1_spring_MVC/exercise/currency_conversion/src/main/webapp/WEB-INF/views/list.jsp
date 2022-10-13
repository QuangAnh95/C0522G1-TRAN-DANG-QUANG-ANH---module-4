<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 13/10/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculate</title>
  </head>
  <body>
  <h1>CHUYỂN ĐỔI TIỀN TỆ</h1>
  <form action="/resutl" method="post">
    <label>Nhập số tiền quy đổi</label><br>
    <input type="number" name= "USA" value="USA" placeholder="USA"><br>
    <input type="submit" value="Check">
    <h2> ${USA}   USA = ${VND}    VND</h2>

  </form>
  </body>
</html>
