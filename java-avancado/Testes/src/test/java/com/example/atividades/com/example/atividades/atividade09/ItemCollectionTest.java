package com.example.atividades.atividade09;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemCollectionTest {

  private ItemCollection itemCollection;
  private Item item1;
  private Item item2;

  @BeforeEach
  public void setUp() {
    itemCollection = new ItemCollection();
    item1 = new Item("Sword");
    item2 = new Item("Shield");
  }

  @Test
  @DisplayName("Test addItem")
  public void testAddItem() {
    itemCollection.addItem(item1);
    List<Item> expectedItems = new ArrayList<>();
    expectedItems.add(item1);
    assertEquals(expectedItems, itemCollection.getItems());
  }

  @Test
  @DisplayName("Test removeItem")
  public void testRemoveItem() {
    itemCollection.addItem(item1);
    itemCollection.addItem(item2);
    itemCollection.removeItem(item1);
    List<Item> expectedItems = new ArrayList<>();
    expectedItems.add(item2);
    assertEquals(expectedItems, itemCollection.getItems());
  }

  @Test
  @DisplayName("Test addItem with null item")
  public void testAddNullItem() {
    assertThrows(IllegalArgumentException.class, () -> itemCollection.addItem(null));
  }

  @Test
  @DisplayName("Test getItems")
  public void testGetItems() {
    assertTrue(itemCollection.getItems().isEmpty());
    itemCollection.addItem(item1);
    itemCollection.addItem(item2);
    List<Item> expectedItems = new ArrayList<>();
    expectedItems.add(item1);
    expectedItems.add(item2);
    assertEquals(expectedItems, itemCollection.getItems());
  }

  @Test
  @DisplayName("Test removeItem with item not in collection")
  public void testRemoveItemNotInCollection() {
    assertThrows(IllegalArgumentException.class, () -> itemCollection.removeItem(item1));
  }

 
}
