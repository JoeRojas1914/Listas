package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;
import uaslp.objetos.list.linkedlist.LinkedList;

public class ArrayListTest {

    @Test
    public void whenListIsCreated_thenItIsEmpty(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,size);
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenFirstElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtTail("A");

        //Validacion
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("A",list.getAt(0));
    }

    @Test
    public void givenAFullList_whenAddAtTail_thenArraySizeIsIncreased(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtTail("A");
        list.addAtTail("B");

        //Validacion
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("B",list.getAt(1));
    }


    @Test
    public void givenA1ElementList_whenElementIsRemoved_thenArraySizeIsCero(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("A");

        //Ejecucion
        list.remove(0);


        //Validacion
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0,list.getSize());
    }

    @Test
    public void whenRemoveAllWithValueX_allElementsXAreRemoved(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("10");
        list.addAtTail("12");


        //Ejecucion
        list.removeAllWithValue("10");


        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWith3Element_whenRemoveAll_thenListIsEmpty(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
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
    public void givenBigEnoughList_whenElementsAreRemoved_thenSizeDecreases() {
        //given
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < 12; i++) {
            list.addAtTail(Integer.toString(i));
        }

        //when
        for(int i = 0; i < 12; i++) {
            list.remove(0);
        }

        //then
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAList_WhenRemoveaAWrongIndex_thenExceptionisthrown(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();


        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAListWithData_RemoveAWrongIndex_thenException_is_thrown(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        list.addAtTail("10");
        list.addAtFront("5");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(3));


        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenANonEmptyList_whenAddAtFrontValueNull_thenException_is_thrown(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();


        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));


        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }


    @Test
    public void givenAListWith3Element_whenSetAtHead_thenNewHeadValue(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();
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
}
