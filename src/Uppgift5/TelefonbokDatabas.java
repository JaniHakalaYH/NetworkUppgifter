package Uppgift5;

import java.util.ArrayList;
import java.util.List;

public class TelefonbokDatabas {

    Kompis k1 = new Kompis("Emil","070-111 11 11", "1986-09-23", "test@test.se");
    Kompis k2 = new Kompis("Nisse","070-111 11 12", "1986-09-24", "test@test.com");
    Kompis k3 = new Kompis("Kalle","070-111 11 13", "1986-09-25", "test@test.org");
    Kompis k4 = new Kompis("Fifan","070-111 11 14", "1986-09-26", "test@test.dk");
    Kompis k5 = new Kompis("Dumbledore","070-111 11 15", "1986-09-27", "test@test.uk");

    private final List<Kompis> kompisar = new ArrayList<>();

    public TelefonbokDatabas(){
        kompisar.add(k1);
        kompisar.add(k2);
        kompisar.add(k3);
        kompisar.add(k4);
        kompisar.add(k5);
    }

    public String checkKompis(String s) {
        for(Kompis k: kompisar){
           if(k.getName().equalsIgnoreCase(s)){
               return k.getKompis();
           }
        }return null;
    }
}
