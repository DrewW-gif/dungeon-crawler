import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private ArrayList<Item> equipableItems;
   private ArrayList<Item> armor;
   private String playerName;
   private int mana;
   private int health;
   private int currentX;
   private int currentY;
   private Item[] left;
   private Item[] right;
   private Item[] body;


   public Player(int mana, int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.mana = mana;
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      inventory = new ArrayList<Item>();
      Item startingSword = null;
      boolean isRustySword = false;
      while (isRustySword == false) {
         startingSword =  new Item();
         if (startingSword.getItemType().equals("Rusty Sword")) {
            inventory.add(startingSword);
            isRustySword = true;
         }
         else {
         }
      }
      Item healingPot = null;
      boolean isHealPot = false;
      while (isHealPot == false) {
         healingPot =  new Item();
         if (healingPot.getItemType().equals("Healing Potion")) {
            inventory.add(healingPot);
            isHealPot = true;
         }
         else {
         }
      }
      Item invis = null;
      boolean isInvis = false;
      while (isInvis == false) {
         invis = new Item();
         if (invis.getItemType().equals("Potion of Invisibility")) {
            inventory.add(invis);
            isInvis = true;
         }
         else {
         }
      }
      equipableItems = new ArrayList<Item>();
      armor = new ArrayList<Item>();
      left = new Item[1];
      right = new Item[1];
      body = new Item[1];
      left[0] = null;
      right[0] = null;
      body[0] = null;
      
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
   }

   public void addItemToInventory(Item item) {
      // TODO: add an item to inventory
      inventory.add(item);
   }
   
   public Item removeItemFromInventory(Item item) {
      // TODO: remove an item to inventory. Return the Item so it can returned to the Room that it is in
      inventory.remove(item);
      return item;
   }
   public boolean rSlotOpen() {
      boolean rSlotOpen = false;
      if (right[0] == null) {
         rSlotOpen = true;
      }
      return rSlotOpen;
   }
   public boolean lSlotOpen() {
      boolean lSlotOpen = false;
      if (left[0] == null) {
        lSlotOpen = true;
      }
      return lSlotOpen;
   }
   public boolean bSlotOpen() {
      boolean bSlotOpen = false;
      if (body[0] == null) {
         bSlotOpen = true;
      }
      return bSlotOpen;
   }
   public void equipL(Item equipLItem) {
      left[0] = equipLItem;
      equipLItem.setWhereEquipped("Left");
   }
   public Item checkLSlot() {
      return left[0];
   }
   public void unequipL() {
      left[0].setWhereEquipped(null);
      left[0] = null;
   }
   public void equipR(Item equipRItem) {
      right[0] = equipRItem;
      equipRItem.setWhereEquipped("Right");
   }
   public Item checkRSlot() {
      return right[0];
   }
   public void unequipR() {
      right[0].setWhereEquipped(null); 
      right[0] = null;
   }
   public void equipB(Item equipBItem) {
      body[0] = equipBItem;
      equipBItem.setWhereEquipped("Body");
   }
   public Item checkBSlot() {
      return body[0];
   }
   public void unequipB() {
      body[0].setWhereEquipped(null);
      body[0] = null;
   }  
   public ArrayList<Item> getEquipableItems() {
      for (int i = equipableItems.size() - 1; i > -1; i--) {
         equipableItems.remove(i);
      }
      for (int z = 0; z < inventory.size(); z++) {
         Item selectedItem = inventory.get(z);
         if (selectedItem.getEquipSlot(selectedItem.getItemType()).equals("hand")) {
            equipableItems.add(inventory.get(z));
         }
      }
      return equipableItems;
   }
   public Item getEquipableItem(int indexOfItem) {
      return equipableItems.get(indexOfItem);
   }
   public ArrayList<Item> getArmor() {
      for (int w = armor.size() - 1; w > -1; w--) {
         armor.remove(w);
      }
      for (int q = 0; q < inventory.size(); q++) {
         Item selectedAItem = inventory.get(q);
         if (selectedAItem.getEquipSlot(selectedAItem.getItemType()).equals("body")) {
            armor.add(inventory.get(q));
         }
      }
      return armor;
   }
   public boolean hasItem(String itemName) {
      boolean isInInventory = false;
      for (Item targetItem : inventory) {
         if (targetItem.getItemType().equals(itemName)) {
            isInInventory = true;
         }
      }
      return isInInventory;
   }
   public ArrayList<Item> getInventory() {
      return inventory;
   }
   public Item getItemFromInventory(int itemPos) {
      return inventory.get(itemPos);
   }
   public int getHealth() {
      return this.health;
   }
   public String getName() {
      return playerName;
   }
   public void setName(String newName) {
      playerName = newName;
   }
   public void takeDamage(int damage) {
      this.health -= damage;
   }
   public void useMagicItem(int manaCost) {
      this.mana -= manaCost;
   }
   public void heal(int healAmount) {
      int healthAfterHeal = this.health;
      healthAfterHeal += healAmount;
      if (healthAfterHeal <= 100) {
         this.health += healAmount;
      }
      else {
         this.health = 100;
      }
   }
   public void addMana(int addAmount) {
      this.mana += addAmount;
   }
   public int getCurrentMana() {
      return this.mana;
   }
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
      return map.getRoom(currentX, currentY).toString();
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
      currentX = x;
      currentY = y;
   }
   public int getX() {
      return currentX;
   }
   public int getY() {
      return currentY;
   }
   
   public Room getRoom(Map map) {
      // TODO: return the room object that the player is currently in, given the Map that was passed
      return map.getRoom(currentX, currentY);
   }
}