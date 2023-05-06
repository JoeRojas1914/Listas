package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedListTest {
    @Test
    public  void whenListIsCreated_thenItIsEmpty(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtTail("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenANonEmptyList_whenAddAtTail_thenElementIsInserted(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");

        //Ejecucion
        list.addAtTail("2");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertEquals("2", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtFront("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenANonEmptyList_whenAddAtFront_thenElementIsInserted(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");

        //Ejecucion
        list.addAtFront("2");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("2", list.getAt(0));
        Assertions.assertEquals("1", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenANonEmptyList_whenAddAtFrontValueNull_thenException_is_thrown(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();


        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAList_WhenRemoveaAWrongIndex_thenExceptionisthrown(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();


        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAListWithData_RemoveAWrongIndex_thenException_is_thrown(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("10");
        list.addAtFront("5");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith1Element_whenRemove_thenElementIsRemoved(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");


        //Ejecucion
        list.remove(0);


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenRemoveAtHead_thenElementIsRemoved(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.remove(0);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenRemoveAtMiddle_thenElementIsRemoved(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.remove(1);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenRemoveAtTail_thenElementIsRemoved(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.remove(2);


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenRemoveAll_thenListIsEmpty(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.removeAll();

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenSetAtHead_thenNewHeadValue(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.setAt(0, "13");


        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("13", list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }



    @Test
    public void givenAListWith3Element_whenSetAtMiddle_thenNewMiddleValue(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.setAt(1, "13");


        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("13", list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenSetAtTail_thenNewTailValue(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");


        //Ejecucion
        list.setAt(2, "13");


        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("13", list.getAt(2));
        Assertions.assertFalse(list.isEmpty());
    }


    @Test
    public void whenRemoveAllWithValueX_allElementsXAreRemoved(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("10");
        list.addAtTail("12");


        //Ejecucion
        list.removeAllWithValue("10");


        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

}



