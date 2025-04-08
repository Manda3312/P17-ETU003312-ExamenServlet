

import entitie.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class CreditFormServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Credit> Credits= Credit.getAll();
            request.setAttribute("Credits", Credits);
            request.getRequestDispatcher("FormCredit.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException( e);
        }
    }

    
}
