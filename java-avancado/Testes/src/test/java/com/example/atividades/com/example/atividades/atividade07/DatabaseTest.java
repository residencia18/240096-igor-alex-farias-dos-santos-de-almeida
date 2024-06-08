package com.example.atividades.atividade07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DatabaseTest {

  private Database database;
  private User user;

  @BeforeEach
  public void setUp() {
    database = Mockito.mock(Database.class);
    user = new User("Superman", "superman@example.com");
  }


  @Test
  @DisplayName("Test saveUser with null user")
  public void testSaveUserWithNullUser() {
    doThrow(new IllegalArgumentException("User cannot be null")).when(database).saveUser(null);

    assertThrows(IllegalArgumentException.class, () -> {
      database.saveUser(null);
    });
  }

  @Test
  @DisplayName("Test saveUser method is called")
  public void testSaveUserCalled() {
    database.saveUser(user);
    verify(database, times(1)).saveUser(user);
  }

}
