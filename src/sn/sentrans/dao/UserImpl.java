package sn.sentrans.dao;

import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;
import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{

    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(User u) {
        String sql = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?)" ;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1,u.getNom());
            db.getPstm().setString(2,u.getPrenom());
            db.getPstm().setString(3,u.getEmail());
            db.getPstm().setString(4,u.getPassword());
            ok=db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> liste() {
        List<User> listuser = new ArrayList<User>();
        String sql= "SELECT * FROM user";
        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            while (rs.next()){
                User u = new User();
                u.setIdu(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                listuser.add(u);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listuser;
    }

    @Override
    public int update(User u) {
        String sql = "UPDATE user nom = ?, prenom = ?, email = ?, password = ? WHERE idu = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setString(1,u.getNom());
            db.getPstm().setString(2,u.getPrenom());
            db.getPstm().setString(3,u.getEmail());
            db.getPstm().setString(4,u.getPassword());
            db.getPstm().setInt(5,u.getIdu());
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int Idu) {
        String sql = "DELETE FROM user WHERE idu = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setInt(1,Idu);
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getAll(String email) {
        String sql= "SELECT * FROM user WHERE email = ?";
        User u = null;
        try {
            db.getPstm().setString(1,email);
            db.initPrepar(sql);
            rs=db.executeSelect();
            if (rs.next()){
                u = new User();
                u.setIdu(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public User getLogin(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1,email);
            db.getPstm().setString(2,password);
            rs = db.executeSelect();
            if (rs.next()){
                user = new User();
                user.setIdu(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
