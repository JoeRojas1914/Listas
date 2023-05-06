package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList <T> implements List<T>{
    private T []array;
    private int size;

    public ArrayList(){
        array = (T[])(new Object[2]);
    }


    public void addAtTail(T data) throws NotNullAllowedException {

        validateNotNullAllowed(data);

        if(size == array.length){
            increaseArraySize();
        }
        array[size] = data;
        size++;

    }

    public void addAtFront(T data) throws NotNullAllowedException{

        validateNotNullAllowed(data);

        if(size == array.length){
            increaseArraySize();
        }
        for(int i= size; i>0;i-- ){
            array[i] = array[i-1];
        }

        array[0]=data;
        size++;
    }


    public void increaseArraySize(){
        T[] newArray = (T[])new Object[array.length *2];

        for(int i=0; i<array.length;i++){
            newArray[i] = array[i];
        }

        array=newArray;
    }

    public void remove(int index) throws BadIndexException {

        validateInvalidIndex(index);

        for(int i= index; i<size-1 ; i++){
            array[i]=array[i+1];
        }

        size--;

        if(shouldDecrease()){
            decreaseSize();
        }

    }

    public void removeAll(){
        array = (T[])(new Object[2]);
        size = 0;
    }

    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException{
        validateInvalidIndex(index);

        validateNotNullAllowed(data);

        array[index]=data;
    }

    public T getAt(int index) throws BadIndexException{
        validateInvalidIndex(index);

        return array[index];
    }


    public void removeAllWithValue(T data) throws BadIndexException {
        for(int currentIndex = size-1; currentIndex >= 0; currentIndex--){
            if(array[currentIndex].equals(data)){
                remove(currentIndex);
            }
        }
    }

    public int getSize(){
        return size;
    }


    public Iterator getIterator() {
        return new ArrayListIterator<>(this);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean shouldDecrease() {
        return size < array.length / 4; //better amortized complexity for (hypothetical) pop/push use cases.
    }

    private void decreaseSize() {
        T []newArray = (T[])(new Object[array.length / 2]);

        //System.arraycopy(array, 0, newArray, 0, size);
        Iterator<T> iterator = getIterator();
        int newIndex = 0;

        while(iterator.hasNext()){
            newArray[newIndex] = iterator.Next();
            newIndex++;
        }

        array = newArray;
    }


    private void validateNotNullAllowed(T data) throws  NotNullAllowedException{
        if(data == null){
            throw new NotNullAllowedException();
        }
    }


    private void validateInvalidIndex(int index) throws  BadIndexException{
        if(index < 0 || index >= size) {
            throw new BadIndexException();
        }
    }
}
