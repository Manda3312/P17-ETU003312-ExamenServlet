package entitie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.*;


public class Credit {
    int id;
    String Libelle;
    Double montant;
    Double Rest;


    public void setRest(Double rest) {
        Rest = rest;
    }
    public Double getRest() {
        return Rest;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    public int getId() {
        return id;
    }
    public String getLibelle() {
        return Libelle;
    }
    public Double getMontant() {
        return montant;
    }

    
    public Credit() {
    }

    public Credit(int id,String Libelle, Double montant) {
        setId(id);
        setLibelle(Libelle);
        setMontant(montant);
    }
    public Credit(int id,String Libelle, Double montant,Double Rest) {
        setId(id);
        setLibelle(Libelle);
        setMontant(montant);
        setRest(Rest);
    }

    public Credit(String Libelle,Double montant) {
        setLibelle(Libelle);
        setMontant(montant);
    }

    
    public Credit(String Libelle,Double montant,Double Rest) {
        setLibelle(Libelle);
        setMontant(montant);
        setRest(Rest);
    }



    
    public void save() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Credit (Libelle,Montant) VALUES (?,?)";

        try (Connection conn = Util.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.getLibelle());
            stmt.setDouble(2, this.getMontant());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du type de Credit : " + e.getMessage());
            throw e;
        }
    }
    


    //get all
    public static List<Credit> getAll() throws SQLException, ClassNotFoundException {
        List<Credit> list = new ArrayList<>();
        String sql = "SELECT * FROM Credit";

        try (Connection conn = Util.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Credit credit = new Credit(rs.getInt("id"),rs.getString("Libelle"),rs.getDouble("Montant"),rs.getDouble("rest"));
                list.add(credit);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection des types de Departements : " + e.getMessage());
            throw e;
        }

        return list;
    }

    //get by id
    public static Credit getById(int id) throws SQLException, ClassNotFoundException {
        Credit Dpt = null;
        String sql = "SELECT * FROM Credit WHERE id =?";
        try (Connection conn = Util.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); 
                if (rs.next()) {
                    Dpt = new Credit(rs.getInt("id"), rs.getString("Libelle"),rs.getDouble("Montant"),rs.getDouble("rest"));
                }
            else {
                System.out.println("Aucun type de Credit avec l'id : " + id);
            }
            return Dpt;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la selection du type de Credit : " + e.getMessage());
            throw e;
        }
    }

        //get by id
        public static void UpdateRest (Double rest ,int idCredit ) throws SQLException, ClassNotFoundException {
            Credit Dpt = null;
            String sql = "UPDATE Credit set rest=? where id=?";
            try (Connection conn = Util.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, rest );   
                stmt.setInt(2, idCredit );
                stmt.executeQuery(); 
                  
                
            } catch (SQLException e) {
                System.err.println( e.getMessage());
                throw e;
            }
        }

}
