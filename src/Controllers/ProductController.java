package Controllers;

import Models.DBInventory;
import Models.Inventory;
import Models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductController extends HttpServlet {
    private String RESULT_PAGE = "productsView.jsp";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Inventory inv = DBInventory.getInstance();
        ArrayList<Product> productList = inv.getProductList();
        if(req.getAttribute("search")!=null){
            ArrayList<Product> filteredList = new ArrayList<>();
            for (Product p : productList) {
                if(p.getName().toLowerCase().contains(((String)req.getAttribute("search")).toLowerCase())){
                    filteredList.add(p);
                }
            }
            productList = filteredList;
        }


        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);
        }
}
