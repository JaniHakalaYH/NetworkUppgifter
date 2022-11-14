package uppgift15;

import java.util.LinkedList;
import java.util.List;

public class GenericQueue<T> implements GenericQueueInterface<T>{


    private List<T> innerList = new LinkedList<>();

    public GenericQueue (){}

    @Override
    public void put(T t) {
        innerList.add(t);
    }

    @Override
    public T take() {
        T temp = innerList.get(0);
        innerList.remove(0);
        return temp;
    }

    @Override
    public int size() {
        return innerList.size();
    }
}

