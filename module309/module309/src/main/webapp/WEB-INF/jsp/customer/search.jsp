<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>

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
  <c:if test="${not empty search}">
    <section>
      <div class="container">
        <h2 class="text-center ">Customers Found (${customers.size()})</h2>
        <table class="table mt-5">
          <tr>
            <th>Contact First Name</th>
            <th>Contact Last Name</th>
            <th>id</th>
            <th>Customer Name</th>
            <th>Edit</th>
          </tr>
          <c:forEach var="customer" items="${customers}" >
            <tr>
              <td>${customer.contactFirstname}</td>
              <td>${customer.contactLastname}</td>
              <td>${customer.id}</td>
              <td>${customer.customerName}</td>
              <td><a href="/customer/edit/${customer.id}">Edit</a></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </section>
  </c:if>

<jsp:include page="../include/footer.jsp"/>