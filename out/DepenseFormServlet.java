

import entitie.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class DepenseFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            List<Credit> Credits= Credit.getAll();
            List<Depense> Depenses= Depense.getAll();
            request.setAttribute("Credits", Credits);
            request.getRequestDispatcher("FormDepense.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Cannot obtain Credit from DB", e);
        }
    }
    
}
