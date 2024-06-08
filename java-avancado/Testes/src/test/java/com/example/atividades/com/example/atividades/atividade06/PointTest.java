package com.example.atividades.atividade06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  @DisplayName("Test the distance between two points: testDistanceTo")
  public void testDistanceTo() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);

    assertEquals(5.0, p1.distanceTo(p2), 0.0001);
  }


  @Test
  @DisplayName("Test the distance between points with negative coordinates: testDistanceToNegativeCoordinates")
  public void testDistanceToNegativeCoordinates() {
    Point p1 = new Point(-1, -1);
    Point p2 = new Point(-4, -5);

    assertEquals(5.0, p1.distanceTo(p2), 0.0001);
  }

  @Test
  @DisplayName("Test the distance to the same point: testDistanceToSamePoint")
  public void testDistanceToSamePoint() {
    Point p1 = new Point(1, 1);

    assertEquals(0.0, p1.distanceTo(p1), 0.0001);
  }

  @Test
  @DisplayName("Test the distance to a null point: testDistanceToNull")
  public void testDistanceToNull() {
    Point p1 = new Point(0, 0);

    assertThrows(IllegalArgumentException.class, () -> {
      p1.distanceTo(null);
    });
  }
}
