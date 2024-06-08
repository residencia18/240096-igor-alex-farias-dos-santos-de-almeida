package com.example.atividades.atividade10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserManagerTest {

  @Test
  void testFetchUserInfo_UserFound() {
    // Arrange
    UserService mockUserService = mock(UserService.class);
    UserManager userManager = new UserManager(mockUserService);
    int userId = 123;
    User expectedUser = new User("Flash", "flash@example.com");
    when(mockUserService.getUserInfo(userId)).thenReturn(expectedUser);

    // Act
    User actualUser = userManager.fetchUserInfo(userId);

    // Assert
    assertEquals(expectedUser, actualUser);
  }

  @Test
  void testFetchUserInfo_UserNotFound() {
    // Arrange
    UserService mockUserService = mock(UserService.class);
    UserManager userManager = new UserManager(mockUserService);
    int userId = 123;
    when(mockUserService.getUserInfo(userId)).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> {
      userManager.fetchUserInfo(userId);
    });
  }
}
