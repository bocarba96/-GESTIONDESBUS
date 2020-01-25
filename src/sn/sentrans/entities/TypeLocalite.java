package sn.sentrans.entities;

public class TypeLocalite {
    private int Idty;
    private String nom;

    public TypeLocalite() {
    }

    public TypeLocalite(int idty, String nom) {
        Idty = idty;
        this.nom = nom;
    }

    public int getIdty() {
        return Idty;
    }

    public void setIdty(int idty) {
        Idty = idty;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
