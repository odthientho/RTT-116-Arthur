<%--
  Created by IntelliJ IDEA.
  User: odthi
  Date: 12/10/2024
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  </head>
  <body>
    <h1>First Page</h1>
      <table border="1">
          <tr>
              <td>Contact First Name</td>
              <td>Contact Last Name</td>
              <td>id</td>
              <td>Customer Name</td>
          </tr>
          <c:forEach var="name" items="${names}" >
              <tr>
                  <td>${name.contactFirstname}</td>
                  <td>${name.contactLastname}</td>
                  <td>${name.id}</td>
                  <td>${name.customerName}</td>
              </tr>
            </c:forEach>
      </table>
  </body>
</html>
