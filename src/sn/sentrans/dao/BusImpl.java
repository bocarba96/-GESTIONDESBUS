package sn.sentrans.dao;

import sn.sentrans.entities.Bus;
import sn.sentrans.entities.Localite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusImpl implements IBus {
    private DB db = new DB();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Bus b) {
        String sql = "INSERT INTO bus VALUES (NULL, ?, ?, ?)" ;
        try{
            db.initPrepar(sql);
            db.getPstm().setString(1,b.getMatricule());
            db.getPstm().setInt(2,b.getNbplace());
            db.getPstm().setInt(3,b.getLocalite().getIdloc());
            ok=db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Bus> liste() {
        List<Bus> listbus = new ArrayList<Bus>();
        String sql= "SELECT * FROM bus";
        try {
            db.initPrepar(sql);
            rs=db.executeSelect();
            while (rs.next()){
                Bus b = new Bus();
                b.setIdbus(rs.getInt(1));
                b.setMatricule(rs.getString(2));
                b.setNbplace(rs.getInt(3));
                //gestion de la localite
                Localite localite = new Localite();
                localite.setIdloc(rs.getInt(4));
                b.setLocalite(localite);
               //b.setLocalite(new LocaliteImpl().get(rs.getInt(1)));
               //Ajout dans la  liste des bus
                listbus.add(b);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listbus;
    }

    @Override
    public int update(Bus b) {
        String sql = "UPDATE bus matricule = ?, nbplace = ?, localite = ? WHERE idbus = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setString(1,b.getMatricule());
            db.getPstm().setInt(2,b.getNbplace());
            db.getPstm().setInt(3,b.getLocalite().getIdloc());
            db.getPstm().setInt(4,b.getIdbus());
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int idbus) {
        String sql = "DELETE FROM bus WHERE idbus = ?";
        ok = 0;
        try
        {
            db.initPrepar(sql);
            db.getPstm().setInt(1,idbus);
            ok = db.executeMaj();
            db.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Bus get(String matricule) {
        String sql= "SELECT * FROM bus WHERE matricule = ?";
        Bus bus = null;
        try {
            db.getPstm().setString(1,matricule);
            db.initPrepar(sql);
            rs=db.executeSelect();
            if (rs.next()){
                bus  = new Bus();
                bus.setIdbus(rs.getInt(1));
                bus.setMatricule(rs.getString(2));
                bus.setNbplace(rs.getInt(3));
                //gestion de la localite
                Localite localite = new Localite();
                localite.setIdloc(rs.getInt(4));
                bus.setLocalite(localite);
            }
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return bus;
    }
}
