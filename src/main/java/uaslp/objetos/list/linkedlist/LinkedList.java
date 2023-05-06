package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;


public class LinkedList <T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    public void addAtTail (T data) throws NotNullAllowedException {

        validateNotNullAllowed(data);

        Node<T> node = new Node<>(data);

        node.setPrevious(tail);

        if(head == null){
            head = node;
        } else{
            node.getPrevious().setNext(node);
        }

        tail = node;
        size ++;
    }


    public void addAtFront(T data) throws NotNullAllowedException{

        validateNotNullAllowed(data);

        Node<T> node = new Node<>(data);
        node.next = head;

        if(head == null){
            tail = node;
        } else {
            head.previous = node;
        }
        head = node;
        size++;
    }


    public void remove(int index) throws BadIndexException{

        validateInvalidIndex(index);

        LinkedListIterator<T> iterator =  getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.Next();
            current_index++;
        }

        deleteNode(iterator.getCurrentNode());
        size--;

    }

    public void removeAll() throws BadIndexException {
        LinkedListIterator<T> aux= this.getIterator();
        while(aux.hasNext()){
            aux.Next();
            this.remove(0);
        }
    }

    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException{
        validateInvalidIndex(index);
        validateNotNullAllowed(data);

        Node<T> node = findNodeByIndex(index);
        node.setData(data);
    }

    public T getAt(int index) throws BadIndexException{
        validateInvalidIndex(index);
        Node<T> node = findNodeByIndex(index);
        return node.getData();
    }


    public void removeAllWithValue(T data) {
        LinkedListIterator<T> iterator = getIterator();

        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            if(temp.data.equals(data)){
                deleteNode(temp);
                size--;
            }
            iterator.Next();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public int size(){
        return size;
    }

    public LinkedListIterator<T> getIterator(){
        return new LinkedListIterator<>(head);
    }

    private Node<T> findNodeByIndex(int index) {
        Node<T> iteratorNode = head;
        int indexIteratorNode = 0;

        while (indexIteratorNode < index){
            iteratorNode = iteratorNode.getNext();
            indexIteratorNode++;
        }
        return iteratorNode;
    }


    private void deleteNode(Node<T> node) {

        if(head == node && tail == node){
            head = null;
            tail = null;
            return;
        }


        if(head == node) {
            head = head.next;
            head.previous = null;
            return;
        }


        if(tail == node) {
            tail = tail.previous;
            tail.next = null;
            return;
        }


        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void validateNotNullAllowed( T data) throws  NotNullAllowedException{
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
