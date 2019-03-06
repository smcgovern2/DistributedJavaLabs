package Controllers;

import Models.Cart;
import Models.Inventory;
import Models.Product;
import Models.ProductQtyPair;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class QuantityController extends HttpServlet {
    private String RESULT_PAGE = "CartController";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Inventory inv = new Inventory();
        String productName = URLDecoder.decode(req.getParameter("product"),"UTF-8");
        int newQuantity = Integer.parseInt(req.getParameter("quantity"));
        HttpSession session = req.getSession();


        Iterator<Product> it = inv.getProductList().iterator();
        Product product = new Product();
        while (it.hasNext()){
            Product p = it.next();
            if(p.getName().equals(productName)){
                product = p;
            }
        }
        ProductQtyPair newPair = new ProductQtyPair(product,newQuantity);
        Cart cart = (Cart)session.getAttribute("Cart");
        ArrayList<ProductQtyPair> cartList = cart.getProductQtyList();
        Iterator<ProductQtyPair> itr = cartList.iterator();
        while (itr.hasNext()){
            ProductQtyPair pqp = itr.next();
            if(pqp.getProduct().getName().equals(productName)) {
                cartList.remove(pqp);
            }
        }
        cartList.add(newPair);
        cart.setProductQtyList(cartList);
        session.setAttribute("Cart", cart );
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
