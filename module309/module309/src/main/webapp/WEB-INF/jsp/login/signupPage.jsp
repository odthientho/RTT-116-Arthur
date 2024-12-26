<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
  <div class="container">
    <div class="row">
      <h1 class="m-0 text-center">Sign Up</h1>
    </div>
  </div>
</section>

<section class="bg-light2 pt-5 pb-5">
  <div class="container">
    <c:if test="${not empty errors}">
    <div class="mt-3 row justify-content-center">
      <div class="col-6 alert alert-danger" role="alert">
          <div style="color: red;">
             ${errors}
          </div>
      </div>
    </div>
    </c:if>
    <form action="/login/signup" method="post">
      <div class="mt-3 row justify-content-center">
        <label for="email" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10 col-lg-6">
          <input type="text" class="form-control" id="email" name="email" value="${user.email}">
        </div>
      </div>

      <div class="mt-3 row justify-content-center">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10 col-lg-6">
          <input type="password" class="form-control" id="password" name="password" value="${user.password}">
        </div>
      </div>

      <div class="mt-3 row justify-content-center">
        <label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
        <div class="col-sm-10 col-lg-6">
          <input type="text" class="form-control" id="fullName" name="fullName" value="${user.fullName}">
        </div>
      </div>

      <div class="mt-3 row justify-content-center">
        <div class="col-sm-12 col-lg-8">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </div>
    </form>
  </div>
</section>


<jsp:include page="../include/footer.jsp"/>