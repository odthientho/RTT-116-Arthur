<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>

<h1 class="text-center">Ajax Example</h1>
<div class="container bg-light2">
    <div class="row pt-5 pb-5">
        <div class="col-6">
            <button class="btn btn-primary">Ajax Trigger</button>
        </div>
        <div class="row">
            <div class="col-6">
                <div id="ajaxResult"></div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>
