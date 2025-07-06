package com.learning.spring_mongo_db.impl;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class ListInterfaceMockTest {

    @Test
    public void listSizeMethodMocking(){
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(2);

        assertEquals(2, list.size());
    }

    @Test
    public void mockSizeMethodReturnMultipleValues(){
        List<Integer> integerList = Mockito.mock(List.class);
        Mockito.when(integerList.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, integerList.size());
        assertEquals(2, integerList.size());
    }

    @Test
    public void listGetMethodMocking(){
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("learningMockito");

        assertEquals("learningMockit", list.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void letMockList_throwException(){
        List<String> stringList = Mockito.mock(List.class);
        Mockito.when(stringList.get(Mockito.anyInt())).thenThrow(new RuntimeException("something wrong"));

        stringList.get(0);
    }
}
