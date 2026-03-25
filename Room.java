import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      
      int numOfItems = (int)(Math.random() * maxNumberOfItems);
      int numOfMonsters = (int)(Math.random() * maxNumberOfItems);
      itemsInRoom = new ArrayList<Item>();
      monstersInRoom = new ArrayList<Monster>();
      if (numOfItems == 0) {
         numOfItems = 1;
      }
      if (numOfMonsters == 0) {
         numOfMonsters = 1;
      }
      for (int i = 0; i < numOfItems; i++) {
         itemsInRoom.add(new Item());
      }
      for (int x = 0; x < numOfMonsters; x++) {
         monstersInRoom.add(new Monster());
      }
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      
   }
   public ArrayList getItems() {
      return itemsInRoom;
   }
   public void takeItem(int itemVal) {
      itemsInRoom.remove(itemVal);
   }
   public void dropItem(Item item) {
      itemsInRoom.add(item);
   }
   
   public String toString() {
      String returnString = "Items in room: ";

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      for (Item item : itemsInRoom) {
         returnString = returnString + " " + item;
      }
      returnString = returnString + "  Monsters in room: ";
      for (Monster monster : monstersInRoom) {
         returnString = returnString + " " + monster;
      }
      return returnString;
   }

   }