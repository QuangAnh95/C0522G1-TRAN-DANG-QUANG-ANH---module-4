<%--
  Created by IntelliJ IDEA.
  User: cungl
  Date: 9/30/2022
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments </h1>
  <form method="get" action="/sandwich/save">
    <input type="checkbox" name="choose" value="Lettuce">Lettuce
    <input type="checkbox" name="choose" value="Tomato">Tomato
    <input type="checkbox" name="choose" value="Mustard">Mustard
    <input type="checkbox" name="choose" value="Sprouts">Sprouts
    <input type="submit" value="Save">
  </form>
   <c:forEach var="r" items="${result}">
     <span>${r},</span>
   </c:forEach>
  </body>
</html>
