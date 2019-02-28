package Controllers;

import Models.Inventory;
import Models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DetailController {
    private String RESULT_PAGE = "productsView.jsp";



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Inventory inv = new Inventory();
        Product product = Inventory

        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher(RESULT_PAGE);
        dispatcher.forward(req,resp);
    }
}
