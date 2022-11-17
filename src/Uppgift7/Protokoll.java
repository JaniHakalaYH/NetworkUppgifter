package Uppgift7;

public class Protokoll {

    final protected int INITIAL = 0;
    final protected int INTHELOOP = 1;

    TelefonbokDatabas d = new TelefonbokDatabas();

    protected int state = INITIAL;

    public String getOutput(String fromClient){

        if (state == INITIAL){
            state = INTHELOOP;
            return "Hej och välkommen! Skriv in ett regnummer.";
        }
        else if (state == INTHELOOP){
            return d.checkKompis(fromClient);
        }
        return "Unexpected state eror";
    }
}
