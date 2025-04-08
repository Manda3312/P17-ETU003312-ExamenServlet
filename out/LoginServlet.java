
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("Manda"== username && "1234"==password) {
            res.sendRedirect("creditFormServlet");
        } else {
            res.sendRedirect("login.jsp");
        
        }
    }

}
