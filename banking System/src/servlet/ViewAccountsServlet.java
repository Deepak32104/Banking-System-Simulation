package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.BankService;
import model.Account;

public class ViewAccountsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Account List</h2>");
        for (Account acc : BankService.getAllAccounts()) {
            out.println("<p>Account No: " + acc.getAccountNumber() + 
                        " | Name: " + acc.getName() +
                        " | Balance: " + acc.getBalance() + "</p>");
        }
        out.println("<a href='index.html'>Back</a>");
    }
}
