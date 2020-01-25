package sn.sentrans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    //pour la connexcion
    private Connection cnx;
    //pour les resultats des requetes de types SELECT
    private ResultSet rs;
    // pour les requetes preparees
    private PreparedStatement pstm;
    //pour les resultats des requetes de types mise a jour(INSERT,UPDATE,DELETE)
    private int ok;
    private void getConnection(){
        String mysqlurl= "jdbc:mysql://localhost:3306/sentrans";
        String mysqluser = "root";
        String mysqlpassword = "";
        try {
            //charger le pilote
            Class.forName("com.mysql.jdbc.Driver");
            //DriverMenager est le gestionnaire de pilote
            cnx = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    // permet d'initialier les requetes SQL
    public void initPrepar(String sql){
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public  ResultSet executeSelect(){
        try {
            rs = pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
       return ok;
    }
    public PreparedStatement getPstm() {
        return pstm;
    }
    //permet de fermer la connection a la BASE DE DONNEE
    public void closeConnection(){
        try {
            if (cnx !=null)
                cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
