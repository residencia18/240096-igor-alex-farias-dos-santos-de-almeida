package com.example.atividades.atividade10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

  @Test
  void testGetUserInfo_ReturnsNull() {
    // Arrange
    UserService userService = new UserService();

    // Act
    User user = userService.getUserInfo(123);

    // Assert
    assertNull(user);
  }
}
