package sn.sentrans.dao;

import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;

import java.util.List;

public interface ITypeLocalite {
    public int add(TypeLocalite t);
    public List<TypeLocalite> liste();
    public int update(TypeLocalite t);
    public int delete(int t);
    public TypeLocalite getAll(String nom);
}
