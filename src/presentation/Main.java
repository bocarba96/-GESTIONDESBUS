package presentation;

import sn.sentrans.dao.*;
import sn.sentrans.entities.Bus;
import sn.sentrans.entities.Localite;
import sn.sentrans.entities.TypeLocalite;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        Scanner saisie= new Scanner(System.in);
        //SAISIE LOCALITE
        System.out.println("Veuillez saisir le nom de la localite");
        String noml=saisie.nextLine();
        System.out.println("Veuillez saisir la latitude");
        int lat=saisie.nextInt();
        System.out.println("Veuillez saisir la longitude");
        int lon=saisie.nextInt();
        System.out.println("Veuillez saisir l'id typelocalite");
        int idty=saisie.nextInt();
        saisie.nextLine();
        Localite l = new Localite();
        l.setNom(noml);
        l.setLatitude(lat);
        l.setLongitude(lon);
       // l.setIdty(idty);
        ILocalite iLocalite = new LocaliteImpl();
        iLocalite.add(l);
    //SAISIE BUS
        System.out.println("Veuillez saisir le matricule");
        String mat=saisie.nextLine();
        System.out.println("Veuillez saisir le nombre de place");
        int nbplace=saisie.nextInt();
        saisie.nextLine();
        System.out.println("Veuillez saisir l'id de localite");
        int Idloc= saisie.nextInt();
        saisie.nextLine();
        Bus b = new Bus();
        b.setMatricule(mat);
        b.setNbplace(nbplace);
       // b.setIdloc(Idloc);
        IBus iBus = new BusImpl();
        iBus.add(b);

        //SAISIE TYPE_LOCALITE

        System.out.println("Veuillez saisir le nom du type de localite");
        String nomt=saisie.nextLine();
        TypeLocalite t = new TypeLocalite();
        t.setNom(nomt);
        ITypeLocalite iTypeLocalite = new TypeLocaliteImpl();
        iTypeLocalite.add(t);


    }
}
