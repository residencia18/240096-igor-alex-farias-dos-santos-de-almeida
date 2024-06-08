package com.example.atividades.atividade10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

  @Test
  void testGetEmail() {
    // Arrange
    String name = "Homem de Ferro";
    String email = "homem.ferro@example.com";
    User user = new User(name, email);

    // Act
    String userEmail = user.getEmail();

    // Assert
    assertEquals(email, userEmail);
  }

  @Test
  void testGetName() {
    // Arrange
    String name = "Homem de Ferro";
    String email = "homem.ferro@example.com";
    User user = new User(name, email);

    // Act
    String userName = user.getName();

    // Assert
    assertEquals(name, userName);
  }

  @Test
  void testConstructor() {
    // Arrange
    String name = "Homem de Ferro";
    String email = "homem.ferro@example.com";

    // Act
    User user = new User(name, email);

    // Assert
    assertNotNull(user);
    assertEquals(name, user.getName());
    assertEquals(email, user.getEmail());
  }
}
