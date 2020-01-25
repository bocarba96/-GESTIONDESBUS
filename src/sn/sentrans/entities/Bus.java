package sn.sentrans.entities;

public class Bus {
    private int Idbus;
    private String matricule;
    private int nbplace;
    private Localite localite = new Localite();

    public Bus(){

    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

    //permet de creer des objet
    public Bus(int Idbus,String matricule,int nbplace, Localite localite){
        this.Idbus = Idbus;
        this.matricule = matricule;
        this.nbplace = nbplace;
        this.localite = localite;
    }

    public int getIdbus() {
        return Idbus;
    }

    public void setIdbus(int idbus) {
        Idbus = idbus;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

}
