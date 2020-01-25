package sn.sentrans.dao;

import sn.sentrans.entities.Bus;

import java.util.List;

//Interface permet de definir les fonctionalites de l'application
public interface IBus {
    public int add(Bus b);
    public List<Bus> liste();
    public int update(Bus b);
    public int delete(int id);
    public Bus get(String matricule);
}
