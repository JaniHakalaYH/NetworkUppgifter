package uppgift15;

import java.util.LinkedList;
import java.util.List;

public class GenericNumberQueue <T extends Number> implements GenericQueueInterface <T>{

    private List<T> innerList = new LinkedList<>();

    public GenericNumberQueue (){}

    @Override
    public void put(T t) {
        innerList.add(t);
    }

    @Override
    public T take() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
    public double getValueLastCastNotWorking(){
        double sum = 0.0;
        //Number sum = 0;

        for (T t : innerList){
            sum += t.doubleValue();
        }
        return sum;
    }

    public T getValue2(){
        try {
            if (innerList.get(0).getClass() == Integer.class) {
                Integer sum = 0;
                for (T t : innerList) {
                    sum += t.intValue();
                }
                return (T) sum;
            }
            if (innerList.get(0).getClass() == Long.class) {
                Long sum = 0L;
                for (T t : innerList) {
                    sum += t.longValue();
                }
                return (T) sum;
            }
            if (innerList.get(0).getClass() == Double.class) {
                Double sum = 0.0;
                for (T t : innerList) {
                    sum += t.doubleValue();
                }
                return (T) sum;
            }
        }
        catch (IndexOutOfBoundsException e){
            //Listan var tom
            Integer ajdå = 0;
            return (T) ajdå;
        }

        //Hit kommer vi om våra tal var av annan typ, t.ex float, BigInteger
        Integer ajdå = 0;
        return (T) ajdå;

    }
}
