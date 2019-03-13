<%@ page import="Models.ProductQtyPair" %>
<%@ page import="Models.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Dirty Dan's Discount Doorknobs</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
  <body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="#">DDDD</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ProductsController">Products</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CartController">Cart</a>
        </li>
      </ul>
    </div>
  </nav>

    <main role="main" class="container">
      <h3>My Cart</h3>

      <div class="list-group">
            <%
              Cart cart = (Cart)request.getSession().getAttribute("Cart");
              if (cart != null) {
                for (ProductQtyPair pqp : cart.getProductQtyList()) {
                  if(pqp.getQuantity()!=0) {
                    out.print("<div class=\"list-group-item\">");
                    out.print("<form class=\"form-inline\" action=\"javascript:void(0);\">");
                    out.print("<div class=\" form-group form col-sm-8 h4\">" + pqp.getProduct().getName() + "</div>");
                    out.print("<div class=\"input-group col-sm-4\">");
                    out.print("<label for=\"" + URLEncoder.encode(pqp.getProduct().getName(), "UTF-8") + "Qty\" class=\"mx-sm-1 \">Quantity:</label>");
                    out.print("<input class=\"qtyField form-control mx-sm-1 \" type=\"text\"  id=\"" + URLEncoder.encode(pqp.getProduct().getName(), "UTF-8") + "Qty\" placeholder=\"" + pqp.getQuantity() + "\">");
                    out.print("<a href=\"DeleteController?product=" + URLEncoder.encode(pqp.getProduct().getName(),"UTF-8") + "\"><button type=\"button\" class=\"btn btn-danger mx-sm-1\">Remove</button></a>");
                    out.print("</div>");
                    out.print("<input type=\"submit\" style=\"display:none;\" id=\"btnHidden\">");
                    out.print("</form>");
                    out.print("</div>");

                  }
                }
              }
            %>
      </div>


    </main>
  </body>
</html>
<script>
$(document).ready(function() {
  $(document).on('change','.qtyField',function(){
    var qtyId = $(this).attr('id');
    qtyId = qtyId.replace("Qty", "");
    var qty = $(this).val();
    $.post("QuantityController", {product: qtyId, quantity: qty})
    });

    $("#btnHidden").on('click', function() {
        $('#txtFocus').blur();
    });
});

</script>