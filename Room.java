import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private boolean isMonstersInRoom;
   private Monster doppelganger;
   private Monster newMonster;
   private Monster dragon;
   private final int maxNumberOfMonsters = 3;
   private final int maxNumberOfItems = 3;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      
      int numOfItems = (int)(Math.random() * maxNumberOfItems);
      int numOfMonsters = (int)(Math.random() * maxNumberOfItems);
      itemsInRoom = new ArrayList<Item>();
      monstersInRoom = new ArrayList<Monster>();
      Item potentialItem = null;
      Monster potentialMonster = null;
      doppelganger = null;
      newMonster = null;
      dragon = null;
      boolean isMonstersInRoom = true;
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
         monstersInRoom.add(potentialMonster);
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
   public boolean checkForMonsters() {
      if (monstersInRoom.size() <= 0) {
         isMonstersInRoom = false;
      }
      else {
         isMonstersInRoom = true;
      }
      return isMonstersInRoom;
   }
   public void spawnDoppelganger() {
      boolean isDoppelganger = false;
      while (isDoppelganger == false) {
         doppelganger = new Monster();
         if (doppelganger.getMonsterType().equals("Doppelganger")) {
            isDoppelganger = true;
         }
      }
      monstersInRoom.add(doppelganger);
   }
   public void spawnDragon() {
      boolean isDragon = false;
      while (isDragon == false) {
         dragon = new Monster();
         if (dragon.getMonsterType().equals("Ancient Dragon")) {
            isDragon = true;
         }
      }
      monstersInRoom.add(dragon);
   }
   public void spawnMonster() {
      boolean notDoppelganger = false;
      while (notDoppelganger == false) {
         newMonster = new Monster();
         if (newMonster.getMonsterType().equals("Doppelganger")) {
            
         }
         else {
            notDoppelganger = true;
         }
      }
      monstersInRoom.add(newMonster);
   }
   public String toString() {
      String returnString = "Items in room: \n";

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      for (Item item : itemsInRoom) {
         returnString = returnString + " a " + item + "\n";
      }
      returnString = returnString + "\n Monsters in room: \n";
      for (Monster monster : monstersInRoom) {
         returnString = returnString + " a " + monster + " stares at you \n";
      }
      return returnString;
   }

   }