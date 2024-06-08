package com.example.atividades.atividade07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

  private UserService userService;
  private Database mockDatabase;
  private User validUser;

  @BeforeEach
  public void setUp() {
    mockDatabase = Mockito.mock(Database.class);
    userService = new UserService(mockDatabase);
    validUser = new User("Thanos Silva", "thanos.silva@example.com");
  }

  @Test
  @DisplayName("Test saveUser with valid user")
  public void testSaveUserValid() {
    userService.saveUser(validUser);
    verify(mockDatabase, times(1)).saveUser(validUser);
  }

  @Test
  @DisplayName("Test saveUser with null email")
  public void testSaveUserWithNullEmail() {
    User user = new User("Thanos Silva", null);
    assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user));
    verify(mockDatabase, times(0)).saveUser(any(User.class));
  }


  @Test
  @DisplayName("Test saveUser with null name")
  public void testSaveUserWithNullName() {
    User user = new User(null, "thanos.silva@example.com");
    assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user));
    verify(mockDatabase, times(0)).saveUser(any(User.class));
  }

  @Test
  @DisplayName("Test saveUser with empty name")
  public void testSaveUserWithEmptyName() {
    User user = new User("", "thanos.silva@example.com");
    assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user));
    verify(mockDatabase, times(0)).saveUser(any(User.class));
  }

  @Test
  @DisplayName("Test saveUser with empty email")
  public void testSaveUserWithEmptyEmail() {
    User user = new User("Thanos Silva", "");
    assertThrows(IllegalArgumentException.class, () -> userService.saveUser(user));
    verify(mockDatabase, times(0)).saveUser(any(User.class));
  }
}
