<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 17/10/2022
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-image: url("https://thaitrien.com/wp-content/uploads/2022/06/silk-wallpaper-3840x2160-1-scaled.jpg");
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
<h1 style="text-align: center">SETTING A MAILBOX</h1><br>
<form:form modelAttribute="mailBox" method="post" action="/save">
    <table class="table">
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="languages" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                show <form:select path="pageSize" items="${pageSize}"/> emails per page
            </td>
        </tr>
        <tr>
            <td>Spams Filter</td>
            <td><form:checkbox path="spamsFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>

    </table>
</form:form>
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
