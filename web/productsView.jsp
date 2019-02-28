<%@ page import="Models.Inventory" %>
<%@ page import="Models.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
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
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="productsView">Products<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cartView.jsp">Cart</a>
      </li>
    </ul>
  </div>
</nav>

<main role="main" class="container">
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-4">Products</h1>
        <p class="lead">Dirty Dan is offering a wide selection of discount doorknobs</p>
    </div>
    <div class="row">
        
        <%


            ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
//            for (Product p : productList.getProductList()){
//
//                out.println("<div class=\"col-sm-4\">");
//                out.println("<div class=\"card\">");
//                out.println("<div class=\"card-body\">");
//                out.println("<h5 class=\"card-title\">" + p.getName() + "</h5>");
//                out.println("<p class=\"card-text\">" + p.getShortDesc() + "</p>");
//                out.println("<a href=\"detailsView.jsp\" class=\"btn btn-primary\">Details</a></div></div></div>");
//         }

            Iterator it = productList.iterator();
            while (it.hasNext()) {

                Product p = (Product)it.next();
                out.println("<div class=\"col-sm-4\">");
                out.println("<div class=\"card\">");
                out.println("<div class=\"card-body\">");
                out.println("<h5 class=\"card-title\">" + p.getName() + "</h5>");
                out.println("<p class=\"card-text\">" + p.getShortDesc() + "</p>");
                out.println("< href=\"detailsView.jsp\" class=\"btn btn-primary\" >Details</a></div></div></div>");
            }


        %>
      </div>
    </main>
  </body>
</html>
