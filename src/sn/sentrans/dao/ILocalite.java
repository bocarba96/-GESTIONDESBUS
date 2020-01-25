package sn.sentrans.dao;

import sn.sentrans.entities.Bus;
import sn.sentrans.entities.Localite;

import java.util.List;

public interface ILocalite {
     public int add(Localite L);
     public List<Localite> liste();
     public int update(Localite L);
     public int delete(int idloc);
     public Localite getAll(int id);
}
