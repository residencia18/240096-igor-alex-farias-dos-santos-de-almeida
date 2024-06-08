package com.example.atividades.atividade07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  @DisplayName("Test User name is not null or empty")
  public void testUserNameNotNullOrEmpty() {
    User user = new User("Batman", "batman@example.com");
    assertNotNull(user.getName());
    assertFalse(user.getName().isEmpty());
  }

  @Test
  @DisplayName("Test User constructor and getters with valid data")
  public void testUserConstructorAndGettersWithValidData() {
    User user = new User("Superman", "superman@example.com");
    assertEquals("Superman", user.getName());
    assertEquals("superman@example.com", user.getEmail());
  }

  @Test
  @DisplayName("Test User email is not null or empty")
  public void testUserEmailNotNullOrEmpty() {
    User user = new User("Wonder Woman", "wonderwoman@example.com");
    assertNotNull(user.getEmail());
    assertFalse(user.getEmail().isEmpty());
  }

}
