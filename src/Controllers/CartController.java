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

public class CartController extends HttpServlet {


    private String RESULT_PAGE = "cartView.jsp";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Inventory inv = new Inventory();
        Iterator<Product> it = inv.getProductList().iterator();
        Product product = new Product();
        if(req.getParameter("product")!= null) {
            while (it.hasNext()) {
                Product p = it.next();
                if (p.getName().equals(URLDecoder.decode(req.getParameter("product"), "UTF-8"))) {
                    product = p;
                }
            }

            req.setAttribute("product",product);


            HttpSession session = req.getSession();
            if (session.getAttribute("Cart") == null) {
                session.setAttribute("Cart", new Cart());
            }

            Cart cart = (Cart) session.getAttribute("Cart");

            ArrayList<ProductQtyPair> cartList = cart.getProductQtyList();
            Iterator<ProductQtyPair> itr = cartList.iterator();
            boolean productExists = false;
            while (itr.hasNext()) {
                ProductQtyPair pqp = itr.next();
                if (pqp.getProduct().getName().equals(((Product)req.getAttribute("product")).getName())){
                    pqp.setQuantity(pqp.getQuantity() + 1);
                    productExists = true;
                }
            }
            if (!productExists) {
                cart.getProductQtyList().add(new ProductQtyPair(product, 1));
            }
            session.setAttribute("Cart", cart);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);
    }
}
