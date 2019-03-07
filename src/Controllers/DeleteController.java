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

public class DeleteController extends HttpServlet {


    private String RESULT_PAGE = "/CartController";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String productName = URLDecoder.decode(req.getParameter("product"),"UTF-8");
        HttpSession session = req.getSession();



        Cart cart = (Cart)session.getAttribute("Cart");
        ArrayList<ProductQtyPair> cartList = cart.getProductQtyList();
        for(int i = 0; i<cartList.size(); i++){
            if(cartList.get(i).getProduct().getName().equals(productName)) {
                cartList.get(i).setQuantity(0);
            }
        }
        cart.setProductQtyList(cartList);
        session.setAttribute("Cart", cart );
        req.setAttribute("product", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
