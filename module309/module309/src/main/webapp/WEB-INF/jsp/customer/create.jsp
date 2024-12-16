<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>

  <h1 class="text-center">New Customer</h1>
  <div class="container">
    <form action="/customer/create" method="post">
      <div class="row pt-3 justify-content-center">
        <div class="col-6">
          <div class="mb-3">
            <label for="customerName" class="form-label">Customer Name</label>
            <input type="text" class="form-control" id="customerName" name="customerName">
          </div>
          <div class="mb-3">
            <label for="contactFirstname" class="form-label">Contact First Name</label>
            <input type="text" class="form-control" id="contactFirstname" name="contactFirstname">
          </div>
          <div class="mb-3">
            <label for="contactLastname" class="form-label">Contact Last Name</label>
            <input type="text" class="form-control" id="contactLastname" name="contactLastname">
          </div>
          <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone">
          </div>
          <div class="mb-3">
            <label for="addressLine1" class="form-label">Address Line 1</label>
            <input type="text" class="form-control" id="addressLine1" name="addressLine1">
          </div>
          <div class="mb-3">
            <label for="addressLine2" class="form-label">Address Line 2</label>
            <input type="text" class="form-control" id="addressLine2" name="addressLine2">
          </div>
          <div class="mb-3">
            <label for="city" class="form-label">City</label>
            <input type="text" class="form-control" id="city" name="city">
          </div>
          <div class="mb-3">
            <label for="state" class="form-label">State</label>
            <input type="text" class="form-control" id="state" name="state">
          </div>
          <div class="mb-3">
            <label for="postalCode" class="form-label">Postal Code</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode">
          </div>
          <div class="mb-3">
            <label for="country" class="form-label">Country</label>
            <input type="text" class="form-control" id="country" name="country">
          </div>
          <div class="mb-3">
            <label for="creditLimit" class="form-label">Credit Limit</label>
            <input type="text" class="form-control" id="creditLimit" name="creditLimit">
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <div class="col-6">
          <button type="submit" class="btn btn-primary"> Submit </button>
        </div>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<jsp:include page="../include/footer.jsp"/>
