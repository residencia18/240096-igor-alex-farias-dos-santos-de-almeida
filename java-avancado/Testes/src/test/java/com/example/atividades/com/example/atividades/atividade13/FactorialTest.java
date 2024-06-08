package com.example.atividades.atividade13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

  @Test
  void testCalculate_PositiveNumber() {
    // Arrange
    Factorial factorial = new Factorial();

    // Act
    int result = factorial.calculate(5);

    // Assert
    assertEquals(120, result);
  }

  @Test
  void testCalculate_NegativeNumber() {
    // Arrange
    Factorial factorial = new Factorial();

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      factorial.calculate(-5);
    });
  }

  @Test
  void testCalculate_Zero() {
    // Arrange
    Factorial factorial = new Factorial();

    // Act
    int result = factorial.calculate(0);

    // Assert
    assertEquals(1, result);
  }

  

  @Test
  void testCalculate_LargeNumber() {
    // Arrange
    Factorial factorial = new Factorial();

    // Act
    int result = factorial.calculate(10);

    // Assert
    assertEquals(3628800, result);
  }
}
