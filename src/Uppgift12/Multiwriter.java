package Uppgift12;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Multiwriter {

    private static List<PrintWriter> writers = new ArrayList<PrintWriter>();

    public void addWriter(PrintWriter p) {
        writers.add(p);
    }

    public List<PrintWriter> getWriters() {
        return writers;
    }

    public void removeWriter(PrintWriter p) {
        writers.remove(p);
    }
}
