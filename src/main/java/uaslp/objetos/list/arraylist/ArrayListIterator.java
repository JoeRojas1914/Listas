package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;


public class ArrayListIterator <T> implements Iterator {
    private final ArrayList<T> arrayList;
    private int currentIndex;

    ArrayListIterator(ArrayList<T> arrayList) {

        this.arrayList = arrayList;
        currentIndex = 0;
    }

    public boolean hasNext(){
        return currentIndex < arrayList.getSize();
    }

    public T Next() {
        T data = null;
        try {
            data = arrayList.getAt(currentIndex);
        } catch (BadIndexException e) {
            throw new RuntimeException(e);
        }
        currentIndex++;
        return data;
    }
}
