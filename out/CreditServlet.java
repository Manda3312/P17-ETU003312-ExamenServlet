

import entitie.Credit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CreditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
        String Libelle= request.getParameter("Libelle");
        Double montant=Double.parseDouble(request.getParameter("montant"));
            Credit credit = new Credit(Libelle,montant);
            credit.save();
            response.sendRedirect("FormCredit.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Cannot obtain Credit from DB", e);
        }
    }
} 