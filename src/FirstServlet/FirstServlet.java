package FirstServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type

        String user = request.getParameter("user");
        if(user == null) user = "";
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("message"));
        for (Product p : Inventory.INVENTORY.getProductList()) {
            writer.append("<li>" + p.getName() + " : " + p.getShortDesc() + "<li>");
        }
    }
}
