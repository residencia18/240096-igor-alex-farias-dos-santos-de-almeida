package com.example.atividades.atividade08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

  private Statistics statistics;

  @BeforeEach
  public void setUp() {
    statistics = new Statistics();
  }

  @Test
  @DisplayName("Test calculateAverage with empty list")
  public void testCalculateAverageEmptyList() {
    List<Integer> numbers = Collections.emptyList();
    assertThrows(IllegalArgumentException.class, () -> statistics.calculateAverage(numbers));
  }

  @Test
  @DisplayName("Test calculateAverage with non-empty list")
  public void testCalculateAverageNonEmptyList() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    double expectedAverage = 3.0;
    double actualAverage = statistics.calculateAverage(numbers);
    assertEquals(expectedAverage, actualAverage);
  }

  @Test
  @DisplayName("Test calculateAverage with null list")
  public void testCalculateAverageNullList() {
    List<Integer> numbers = null;
    assertThrows(IllegalArgumentException.class, () -> statistics.calculateAverage(numbers));
  }
}
