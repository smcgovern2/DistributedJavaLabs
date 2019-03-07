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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class CartController extends HttpServlet {


    private String RESULT_PAGE = "cartView.jsp";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        if (session.getAttribute("Cart") == null) {
            session.setAttribute("Cart", new Cart());
        }

        if(req.getParameter("product")!= null) {
           String productName = req.getParameter("product");

            Cart cart = (Cart) session.getAttribute("Cart");

            ArrayList<ProductQtyPair> cartList = cart.getProductQtyList();
            boolean productExists = false;


            for(int i = 0; i<cartList.size(); i++){
                if(cartList.get(i).getProduct().getName().equals(productName)) {
                    Integer oldQty = cartList.get(i).getQuantity();
                    cartList.get(i).setQuantity(oldQty+1);
                    productExists = true;
                }
            }
            if (!productExists) {
                Inventory inv = new Inventory();
                for(int i = 0; i<inv.getProductList().size(); i++){
                    if(inv.getProductList().get(i).getName().equals(productName)) {
                        cartList.add(new ProductQtyPair(inv.getProductList().get(i), 1));
                    }
                }
            }
            session.setAttribute("Cart", cart);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);
    }

    static Product getProduct(HttpServletRequest req, Iterator<Product> it, Product product) throws UnsupportedEncodingException {
        while (it.hasNext()) {
            Product p = it.next();
            if (p.getName().equals(URLDecoder.decode(req.getParameter("product"), "UTF-8"))) {
                product = p;
            }
        }

        req.setAttribute("product",product);
        return product;
    }
}
