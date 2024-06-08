package com.example.atividades.atividade11;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CustomSortTest {

  @Test
  void testCustomSort() {
    
    List<Integer> unsorted = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);

    CustomSort customSort = new CustomSort();

    List<Integer> sorted = customSort.customSort(unsorted);

    List<Integer> expected = Arrays.asList(9, 6, 5, 5, 4, 3, 2, 1, 1);
    assertEquals(expected, sorted);
  }

  @Test
  void testCustomSort_EmptyList() {
    
    List<Integer> emptyList = Arrays.asList();

    CustomSort customSort = new CustomSort();

    
    List<Integer> sorted = customSort.customSort(emptyList);

    
    assertTrue(sorted.isEmpty());
  }

  @Test
  void testCustomSort_SingleElementList() {
    
    List<Integer> singleElementList = Arrays.asList(42);

    CustomSort customSort = new CustomSort();

    List<Integer> sorted = customSort.customSort(singleElementList);
    
    List<Integer> expected = Arrays.asList(42);
    assertEquals(expected, sorted);
  }
}
