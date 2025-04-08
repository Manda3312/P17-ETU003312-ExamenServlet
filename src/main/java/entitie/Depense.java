package entitie;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.*;


public class Depense {
    int id;
    int idCredit;
    Double montant;
    Date date;

    public void setId(int id) {
        this.id = id;
    }
  public void setIdCredit(int idCredit) {
      this.idCredit = idCredit;
  }
  public void setMontant(Double montant) {
      this.montant = montant;
  }
  public void setDate(Date date) {
      this.date = date;
  }
  public int getId() {
      return id;
  }public int getIdCredit() {
      return idCredit;
  }public Double getMontant() {
      return montant;
  }public Date getDate() {
      return date;
  }
    
    public Depense() {
    }

    public Depense(int id,int idCredit, Double montant, Date date) {
        setId(id);
        setIdCredit(idCredit);
        setMontant(montant);
        setDate(date);
        
    }

    public Depense(int idCredit, Double montant, Date date) {
        setIdCredit(idCredit);
        setMontant(montant);
        setDate(date);
    }


    
    public void save() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Depense (idCredit,Montant,Da_te) VALUES (?,?,?)";

        try (Connection conn = Util.getConnection();
        
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                    conn.setAutoCommit(false);

            stmt.setInt(1, this.getIdCredit());
            stmt.setDouble(2, this.getMontant());
            stmt.setDate(3, this.getDate());
            
            Credit credit=new Credit();
           credit= Credit.getById(idCredit);

           if(credit.getRest()>this.getMontant()){
            Credit.UpdateRest(credit.getRest()-this.getMontant(), idCredit);
            stmt.executeUpdate();
            conn.commit();
           }else{
            conn.rollback();
           }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du type de Depense : " + e.getMessage());
            throw e;
        }
    }
    


    //get all
    public static List<Depense> getAll() throws SQLException, ClassNotFoundException {
        List<Depense> list = new ArrayList<>();
        String sql = "SELECT * FROM Depense";

        try (Connection conn = Util.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Depense credit = new Depense(rs.getInt("id"),rs.getInt("idCredit"),rs.getDouble("Montant"),rs.getDate("Da_te"));
                list.add(credit);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection des types de Depense : " + e.getMessage());
            throw e;
        }

        return list;
    }

    //get by id
    public static Depense getById(int id) throws SQLException, ClassNotFoundException {
        Depense Dpt = null;
        String sql = "SELECT * FROM Depense WHERE id =?";
        try (Connection conn = Util.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); 
                if (rs.next()) {
                    Dpt = new Depense(rs.getInt("id"),rs.getInt("idCredit"),rs.getDouble("Montant"),rs.getDate("Da_te"));                }
            else {
                System.out.println("Aucun type de Depense avec l'id : " + id);
            }
            return Dpt;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection du type de Depense : " + e.getMessage());
            throw e;
        }
    }

}
 