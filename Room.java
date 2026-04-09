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
      Item potentialItem = null;
      Monster potentialMonster = null;
      if (numOfItems == 0) {
         numOfItems = 1;
      }
      if (numOfMonsters == 0) {
         numOfMonsters = 1;
      }
      for (int i = 0; i < numOfItems; i++) {
         boolean obtainableItem = false;
         while (obtainableItem == false) {
            potentialItem = new Item();
            if (potentialItem.getItemType().equals("Cursed Ring")) {
               
            }
            else if (potentialItem.getItemType().equals("Dragon Egg")) {
               
            }
            else if (potentialItem.getItemType().equals("Spellbook of Darkness")) {
               
            }
            else if (potentialItem.getItemType().equals("Minotaurs Axe")) {
               
            }
            else if (potentialItem.getItemType().equals("Ancient Scroll")) {
               
            }
            else if (potentialItem.getItemType().equals("Mysterious Rune Stone")) {
               
            }
            else {
               obtainableItem = true;
            }
         }
         itemsInRoom.add(potentialItem);
      }
      for (int x = 0; x < numOfMonsters; x++) {
         boolean notBoss = false;
         while (notBoss == false) {
            potentialMonster = new Monster();
            if (potentialMonster.getMonsterType().equals("Doppelganger")) {
            
            }
            else {
               notBoss = true;
            }
         }
         monstersInRoom.add(new Monster());
      }
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      
   }
   public ArrayList<Item> getItems() {
      return itemsInRoom;
   }
   public void takeItem(int itemVal) {
      itemsInRoom.remove(itemVal);
   }
   public void dropItem(Item item) {
      itemsInRoom.add(item);
   }
   public ArrayList<Monster> getMonsters() {
      return monstersInRoom;
   }
   public void monsterSlain(int monsterVal) {
      monstersInRoom.remove(monsterVal);
   }
   public void addItem(String itemName) {
      Item itemToAdd = new Item();
      itemToAdd.setItemType(itemName);
      itemsInRoom.add(itemToAdd);
   }
   public String toString() {
      String returnString = "Items in room: ";

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      for (Item item : itemsInRoom) {
         returnString = returnString + " a " + item;
      }
      returnString = returnString + "   Monsters in room: ";
      for (Monster monster : monstersInRoom) {
         returnString = returnString + " " + monster + " stares at you ";
      }
      return returnString;
   }

   }