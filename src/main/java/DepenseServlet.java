
import entitie.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DepenseServlet  extends HttpServlet{




public class CreditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            int idCredit= Integer.parseInt(request.getParameter("Credit"));
            Double montant=Double.parseDouble(request.getParameter("montant"));
            String dateString=request.getParameter("date");
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                java.util.Date date = sdf.parse(dateString);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            Depense depense = new Depense(idCredit,montant,sqlDate);
            depense.save();
            response.sendRedirect("depenseFormServlet");

        } catch (Exception e) {
            throw new ServletException("Cannot obtain Credit from DB", e);
        }
    }
} 
    
}
