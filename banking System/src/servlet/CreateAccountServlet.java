package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.BankService;
import model.Account;

public class CreateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        double deposit = Double.parseDouble(req.getParameter("deposit"));
        Account acc = BankService.createAccount(name, deposit);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h3>Account Created Successfully!</h3>");
        out.println("<p>Account Number: " + acc.getAccountNumber() + "</p>");
        out.println("<a href='index.html'>Back to Home</a>");
    }
}
