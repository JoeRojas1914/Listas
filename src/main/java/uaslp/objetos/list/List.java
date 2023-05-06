package uaslp.objetos.list;

import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public interface List <T> {

    void addAtTail(T data) throws NotNullAllowedException;
    void addAtFront(T data) throws NotNullAllowedException;
    void remove(int index) throws BadIndexException;
    void removeAll() throws BadIndexException;
    void setAt(int index, T data) throws BadIndexException, NotNullAllowedException;
    T getAt(int index) throws BadIndexException;
    void removeAllWithValue(T data) throws BadIndexException;
    int getSize();
    boolean isEmpty();
    Iterator<T> getIterator();

}
