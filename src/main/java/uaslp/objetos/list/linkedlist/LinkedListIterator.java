package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator <T> implements Iterator {
    private Node<T> currentnode;

    LinkedListIterator(Node<T> node){
        currentnode = node;
    }


    public boolean hasNext(){
        return currentnode != null;
    }

    public T Next(){
        T data = currentnode.getData();
        currentnode = currentnode.getNext();
        return data;
    }

    public Node<T> getCurrentNode() {
        return currentnode;
    }
}
