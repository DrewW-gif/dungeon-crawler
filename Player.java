import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private String playerName;
   private int health;
   private int currentX;
   private int currentY;


   public Player(int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
   }

   public void addItemToInventory(Item item) {
      // TODO: add an item to inventory
   }
   
   public Item removeItemFromInventory(Item item) {
      // TODO: remove an item to inventory. Return the Item so it can returned to the Room that it is in
   }
   
   
   public boolean hasItem(String itemName) {
      return false;
   }
   
   
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
   }
   
   public Room getRoom(Map map) {
      // TODO: return the room object that the player is currently in, given the Map that was passed
   }
}