<%--
  Created by IntelliJ IDEA.
  User: odthi
  Date: 12/13/2024
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
  <h1 class="text-center">Customer Search</h1>
  <div class="container">
    <form action="/customer/search">
      <div class="row pt-3 justify-content-center">
        <div class="col-6">
          <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="${search}">
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <div class="col-6">
          <button type="submit" class="btn btn-primary"> Search </button>
        </div>
      </div>
    </form>
  </div>
  <c:if test="${search != null}">
    <section>
      <div class="container">
        <h2 class="text-center ">Customers Found (${customers.size()})</h2>
        <table class="table mt-5">
          <tr>
            <td>Contact First Name</td>
            <td>Contact Last Name</td>
            <td>id</td>
            <td>Customer Name</td>
          </tr>
          <c:forEach var="customer" items="${customers}" >
            <tr>
              <td>${customer.contactFirstname}</td>
              <td>${customer.contactLastname}</td>
              <td>${customer.id}</td>
              <td>${customer.customerName}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </section>
  </c:if>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
