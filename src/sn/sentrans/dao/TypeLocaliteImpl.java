package sn.sentrans.dao;

import sn.sentrans.entities.TypeLocalite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeLocaliteImpl implements ITypeLocalite {
    private DB db = new DB();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(TypeLocalite t) {
        String sql = "INSERT INTO typelocalite VALUES (NULL, ?)" ;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1,t.getNom());
            ok=db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<TypeLocalite> liste() {
        List<TypeLocalite> typeLocalites = new ArrayList<TypeLocalite>();
        String sql= "SELECT * FROM typelocalite";
        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            while (rs.next()){
                TypeLocalite t = new TypeLocalite();
                t.setIdty(rs.getInt(1));
                t.setNom(rs.getString(2));
                typeLocalites.add(t);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return typeLocalites;
    }

    @Override
    public int update(TypeLocalite t) {
        String sql = "UPDATE typelocalite nom = ? WHERE idty = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setString(1,t.getNom());
            db.getPstm().setInt(2,t.getIdty());
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int t) {
        String sql = "DELETE FROM typelocalite WHERE idty = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setInt(1,t);
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public TypeLocalite getAll(String nom) {
        String sql= "SELECT * FROM typelocalite WHERE nom = ?";
        TypeLocalite typeLocalite = null;
        try {
            db.getPstm().setString(1,nom);
            db.initPrepar(sql);
            rs=db.executeSelect();
            if (rs.next()){
                typeLocalite  = new TypeLocalite();
                typeLocalite.setIdty(rs.getInt(1));
                typeLocalite.setNom(rs.getString(2));
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return typeLocalite;
    }
}

