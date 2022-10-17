<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 17/10/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ShowList</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
      body {
        background-image: url("https://thaitrien.com/wp-content/uploads/2022/06/silk-wallpaper-3840x2160-1-scaled.jpg");
        font-weight: bolder;
        font-size: medium;
      }

      table {
        border: solid 7px;
      }

      a {
        text-decoration: none;
      }

      a:hover {
        text-decoration: 3px;
      }
    </style>
  </head>
  <body>
  <h1 class="text-center">MAILBOX LIST</h1>
  <h3 class="text-center" style="color: darkred">${mess}</h3>
<table class="table">
  <thead>
  <tr>
    <th>STT</th>
    <th>Languages</th>
    <th>Page Size</th>
    <th>Spams Filter</th>
    <th>Signature</th>
    <th>Edit</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${mailBoxList}" var="mail" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${mail.languages}</td>
        <td>${mail.pageSize}</td>
        <td>${mail.spamsFilter}</td>
        <td>${mail.signature}</td>
        <td><a href="/update?id=${mail.id}">UpDate</a></td>
      </tr>
  </c:forEach>
  </tbody>

</table>


  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  </body>
</html>
