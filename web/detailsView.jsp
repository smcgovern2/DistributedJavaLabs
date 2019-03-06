<%@ page import="Models.Product" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.net.URLEncoder" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Dirty Dan's Discount Doorknobs</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
    <div class="container">

        <h1 class="display-4"><%out.print(((Product) request.getAttribute("product")).getName());%></h1>
        <span style="font-size:30px; padding:75px; background:white; border-style: solid; border-width: 2px; border-color:black; line-height:200px;">Product Image</span>
        <% NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US); %>
        <p class="lead"><%out.print(format.format(((Product) request.getAttribute("product")).getPrice()));%></p>
        <a href="CartController?product=<%out.print(URLEncoder.encode(((Product) request.getAttribute("product")).getName(),"UTF-8"));%>" class="btn btn-primary">Add to Cart</a>
        <br>
        <br>
        <h2>Description</h2>
        <p><% out.print(((Product) request.getAttribute("product")).getLongDesc()); %></p>
    </div>

</main>
</body>
</html>
