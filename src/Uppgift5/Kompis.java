package Uppgift5;

public class Kompis {
    private final String name;
    private final String phoneNum;
    private final String date;
    private final String email;

    public Kompis(String name, String phoneNum, String date, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.date = date;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getKompis() {
        return "Name: "+name+ " Phone: "+phoneNum+" Birthdate: "+date+" Email: "+email;
    }
}
