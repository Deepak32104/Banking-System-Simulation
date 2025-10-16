package servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.BankService;

public class WithdrawServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int acc = Integer.parseInt(req.getParameter("acc"));
        double amt = Double.parseDouble(req.getParameter("amt"));
        boolean ok = BankService.withdraw(acc, amt);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(ok ? "<h3>Withdrawal Successful!</h3>" : "<h3>Insufficient Balance or Invalid Account!</h3>");
        out.println("<a href='index.html'>Back</a>");
    }
}
