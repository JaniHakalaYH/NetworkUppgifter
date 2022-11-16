package BilregisterTCP;

import java.util.List;

public class Database {

    Bil b1 = new Bil("aaa111", "Nisse", "Volvo", "röd");
    Bil b2 = new Bil("bbb222", "Astor", "Saab", "blå");
    Bil b3 = new Bil("ccc333", "Bosse", "Fiat", "gul");
    Bil b4 = new Bil("ddd444", "Kalle", "Audi", "orange");
    Bil b5 = new Bil("eee555", "Doris", "Toyota", "svart");

    List<Bil> data = List.of(b1,b2,b3,b4,b5);

    public Database(){}

    public Bil search(String regnr){
        for(Bil b: data){
            if(b.getRegNr().equals(regnr)){
                return b;
            }
        }return null;
    }

    public String allData(Bil b){
        return b.regNr+" "+b.brand+" "+b.owner+" "+b.color;
    }
}
