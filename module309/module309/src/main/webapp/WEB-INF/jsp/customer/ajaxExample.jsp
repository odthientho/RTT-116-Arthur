<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../include/header.jsp"/>

<h1 class="text-center">Ajax Example</h1>
<div class="container bg-light2">
    <div class="row pt-5 pb-5">
        <div class="col-6">
            <input id="cid"/>
            <button id="ajaxBtn" class="btn btn-primary">Ajax Trigger</button>
        </div>
        <div class="row">
            <div class="col-6">
                <div id="ajaxResult"></div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(() => {
        $('#ajaxBtn').on('click', () => {
           console.log("btn clicked");

           let cid = $('#cid').val();

           $.ajax({
               method: "GET",
               url: "/customer/ajaxCall",
               data: { customerId: cid}
               }).done(function (msg) {
                    let customer = JSON.parse(msg);
                   console.log(customer);
                   if (!customer) $('#ajaxResult').text('Not Found');
                   else {
                       let customer = JSON.parse(msg);
                       $('#ajaxResult').text(customer.customerName);
                   }
           });

           console.log("after json call but before done");
        });
    });
</script>

<jsp:include page="../include/footer.jsp"/>
