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
      <form>

            <%
              Cart cart = (Cart)request.getSession().getAttribute("Cart");
              if (cart != null) {
                for (ProductQtyPair pqp : cart.getProductQtyList()) {
                  out.print("<div class=\"list-group-item form-inline col-md-12\">" + pqp.getProduct().getName());
                  out.print("<button type=\"button\" class=\"btn btn-danger col-md-1 float-right\">Remove</button>");
                  out.print("<input class=\"qtyField form-control col-md-1 float-right\" type=\"text\"  id=\"" + URLEncoder.encode(pqp.getProduct().getName(),"UTF-8") + "Qty\" placeholder=\"" + pqp.getQuantity() + "\">");
                  out.print("<label for=\"" + URLEncoder.encode(pqp.getProduct().getName(),"UTF-8") + "Qty\" class=\"col-md-1 float-right\">Quantity:</label></div>");
                }
              }
            %>

      </form>
    </main>
  </body>
</html>
<script>
$(document).ready(function() {
  alert("reloaded")
  $(".qtyField").change(function(){
    var qtyId = this.id;
    qtyId = qtyId.replace("Qty", "")
    var qty = this.value
    alert("here")
    var xhttp = new XMLHttpRequest();
    $.post("QuantityController", {product: qtyId, quantity: qty})
    });
});

</script>