package com.example.atividades.atividade09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class ItemTest {

  private static Item item;

  private static final Faker faker = new Faker();

  @BeforeAll
  public static void setUp() {
    String itemName = faker.commerce().productName();
    item = new Item(itemName);
  }

  @Test
  @DisplayName("Test item creation with valid name")
  public void testItemCreation() {
    assertNotNull(item.getName());
    assertFalse(item.getName().isEmpty());
  }

  @Test
  @DisplayName("Test item name consistency")
  public void testItemNameConsistency() {
    String initialName = item.getName();
    String newName = faker.commerce().productName();
    item.setName(newName);
    assertEquals(newName, item.getName());
    assertNotEquals(initialName, item.getName());
  }

  
  @Test
  @DisplayName("Test setting empty name to item")
  public void testSetEmptyName() {
    assertThrows(IllegalArgumentException.class, () -> item.setName(""));
  }

  @Test
  @DisplayName("Test item equality")
  public void testItemEquality() {
    Item sameItem = new Item(item.getName());
    assertEquals(item.getName(), sameItem.getName());
  }

  @Test
  @DisplayName("Test setting null name to item")
  public void testSetNullName() {
    assertThrows(IllegalArgumentException.class, () -> item.setName(null));
  }

  @Test
  @DisplayName("Test item inequality")
  public void testItemInequality() {
    Item differentItem = new Item(faker.commerce().productName());
    assertNotEquals(item, differentItem);
  }
}
