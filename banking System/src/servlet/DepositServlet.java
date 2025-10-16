package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.BankService;

public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int acc = Integer.parseInt(req.getParameter("acc"));
        double amt = Double.parseDouble(req.getParameter("amt"));
        boolean ok = BankService.deposit(acc, amt);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(ok ? "<h3>Deposit Successful!</h3>" : "<h3>Account Not Found!</h3>");
        out.println("<a href='index.html'>Back</a>");
    }
}
