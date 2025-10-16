package servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import service.BankService;

public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int from = Integer.parseInt(req.getParameter("from"));
        int to = Integer.parseInt(req.getParameter("to"));
        double amt = Double.parseDouble(req.getParameter("amt"));

        boolean ok = BankService.transfer(from, to, amt);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(ok ? "<h3>Transfer Successful!</h3>" : "<h3>Transfer Failed!</h3>");
        out.println("<a href='index.html'>Back</a>");
    }
}
