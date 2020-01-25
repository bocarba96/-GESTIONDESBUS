package sn.sentrans.dao;

import sn.sentrans.entities.Bus;
import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;
import sn.sentrans.entities.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocaliteImpl implements ILocalite{
    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Localite L) {
        String sql = "INSERT INTO localite VALUES (NULL, ?, ?, ?, ?)" ;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1,L.getNom());
            db.getPstm().setDouble(2,L.getLatitude());
            db.getPstm().setDouble(3,L.getLongitude());
            db.getPstm().setInt(4,L.getTypeLocalite().getIdty());
            db.getPstm().setInt(5,L.getUser().getIdu());
            ok=db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Localite> liste() {
        List<Localite> listloc = new ArrayList<Localite>();
        String sql= "SELECT * FROM localite";
        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            while (rs.next()){
                Localite L = new Localite();
                L.setIdloc(rs.getInt(1));
                L.setNom(rs.getString(2));
                L.setLatitude(rs.getDouble(3));
                L.setLongitude(rs.getDouble(4));
                //gestion des type de localite
                TypeLocalite typeLocalite = new TypeLocalite();
                typeLocalite.setIdty(rs.getInt(5));
                L.setTypeLocalite(typeLocalite);
                //gestion des users
                User user = new User();
                user.setIdu(rs.getInt(6));
                L.setUser(user);
                //Ajout dans la  liste des localite
                listloc.add(L);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listloc;
    }

    @Override
    public int update(Localite L) {
        String sql = "UPDATE localite nom = ?, latitude = ?, longitude = ?, typelocalite = ?, user = ? WHERE idloc = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setString(1,L.getNom());
            db.getPstm().setDouble(2,L.getLatitude());
            db.getPstm().setDouble(3,L.getLongitude());
            db.getPstm().setInt(4,L.getTypeLocalite().getIdty());
            db.getPstm().setInt(5,L.getUser().getIdu());
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int Idloc) {
        String sql = "DELETE FROM localite WHERE idloc = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setInt(1,Idloc);
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Localite getAll(int id) {
        String sql= "SELECT * FROM localite WHERE idloc = ?";
        Localite localite = null;
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1,id);
            rs=db.executeSelect();
            if (rs.next()){
                localite = new Localite();
                localite.setIdloc(rs.getInt(1));
                localite.setNom(rs.getString(2));
                localite.setLatitude(rs.getDouble(3));
                localite.setLongitude(rs.getDouble(4));
                //gestion de type de localite
                TypeLocalite typeLocalite = new TypeLocalite();
                typeLocalite.setIdty(rs.getInt(5));
                localite.setTypeLocalite(typeLocalite);
                User user = new User();
                user.setIdu(rs.getInt(6));
                localite.setUser(user);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return localite;
    }
}