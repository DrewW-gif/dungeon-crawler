import java.util.ArrayList;

public class Player {
   private ArrayList<String> tutorialSteps;
   private ArrayList<Item> inventory;
   private ArrayList<Item> equipableItems;
   private ArrayList<String> tutorial;
   private ArrayList<String> credits;
   private ArrayList<String> controls;
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
      controls = new ArrayList<String>();
      credits = new ArrayList<String>();
      inventory = new ArrayList<Item>();
      tutorial = new ArrayList<String>();
      tutorialSteps = new ArrayList<String>();
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
   /* Item invis = null;
      boolean isInvis = false;
      while (isInvis == false) {
         invis = new Item();
         if (invis.getItemType().equals("Potion of Invisibility")) {
            inventory.add(invis);
            isInvis = true;
         }
         else {
         }
      } */
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
   public ArrayList<String> getCredits() {
      return credits;
   }
   public void setWinCredits() {
      credits.add("Hello thank you for playing my game dispite it being a simple game a lot of work has gone into making this");
      credits.add("I hope you enjoyed playing the game despit it being created with only one way of beating it I know to get to this");
      credits.add("point you must've grinded ancient dragons for a while (or theres some kind of loop hole) but really hope you");
      credits.add("enjoyed this game and since you made it this far here are the credits");
      credits.add("Credit for creating the Map class and mechanics: Me");
      credits.add("Credit for creating the Room class and mechanics: Me");
      credits.add("Credit for creating the Monster class and mechanics: Me");
      credits.add("Credit for creating the Item class and mechanics: Me");
      credits.add("Credit for creating the Player class and mechanics: Me");
      credits.add("Credit for creating the Game class: Me");
      credits.add("Credit for creating the Game class mechanics:");
      credits.add("For the delay in printing lines: Google Gemini AI very helpful with that");
      credits.add("For the rest of the code: Me");
      credits.add("Credit for the editing and bug checks:");
      credits.add("Google Gemini AI very helpful for when I got stuck trying to figure out why I was trying to add a new Item or ");
      credits.add("Monster to a room instead of the filtered one very helpful for finding my contradicting lines of code");
      credits.add("The jGRASP compile messages helped me find most of my typos that were one or two letters off also helpful to");
      credits.add("see if I was missing brackets or other things but mostly brackets");
      credits.add("And finally Me for going through the code looking for bugs implementing the fixes from the compiling errors");
      credits.add("for making more compiling error and for running the code and going through rooms and testing to see if every");
      credits.add("(well hopefully every) game mechanic works correctly which seemed to be the most boring ways to find bugs");
      credits.add("Credit for teaching me how Java coding logic:");
      credits.add("My teacher Mr. Krowkower for helping me learn the basics of Java coding logic and methods");
      credits.add("And Google Gemini AI for explaining concepts that were way too confusing to understand at first and for also");
      credits.add("assisting me in Java coding logic for random side projects that I do often and correcting its own logic");
      credits.add("Finally Thank You for playing my game and hope you play again soon");
      credits.add("                                                                                    Game Finished 4/22/2026");
   }
   public void setCredits() {
      credits.add("Despite you giving up and exiting I still would like to thank you for trying my game out I know its really hard");
      credits.add("to beat because it requires alot of grinding but I would still like to give some credit to where its due:");
      credits.add("First I would like to thank Google's Gemini AI for assisting me with finding my contradicting code");
      credits.add("I would also like to thank jGRASP's compile messaegs for helping me find most of my typos in my code");
      credits.add("I would also like to thank my Teacher Mr. Krowkower for teaching me the basics of Java coding logic and methods");
      credits.add("I would also like to thank myself for creating most of this code");
      credits.add("Finally I'd like to thank you for giving my game a try and if you have the time I'd love you to try to win");
      credits.add("but I suppose it would take possibly hours if your luck sucks hope you come back and play again soon");
      credits.add("                                                                                    Game Finished 4/22/2026");
   }
   public void resetCredits() {
      for (int creditsLine = credits.size() - 1; creditsLine >= 0; creditsLine--) {
         credits.remove(creditsLine);
      }
   }
   public ArrayList<String> getControls() {
      return controls;
   }
   public void setControls() {
      controls.add("Here are the controls:");
      controls.add("coordinate system (x,y) is so top left is 0,0 up subtracts from y down adds left subtracts from x right adds");
      controls.add("Movement:                  (Capitalization does not matter)");
      controls.add("to move up: [Move Up]  to move down: [Move Down]  to move left: [Move Left]  to move right [Move Right]");
      controls.add("to look in a room to see its contents: [Look]  it will show items and monsters in the room");
      controls.add("to grab an item: [Grab] then use number associated with the item you want to put into your inventory");
      controls.add("to drop an item: [Drop] then use the number associated with the item you want to drop");
      controls.add("to view the contents of your inventory: [Inventory]");
      controls.add("to equip an item: [Equip]  then use the associated letter to which slot you want to equip an item to");
      controls.add("then type the number associated to the item you want to equip");
      controls.add("to unequip an item: [Unequip] then use the letter associated to what slot you want to unequip an item from");
      controls.add("to view what you have equipped in and of your slots: [Look _] replace the _ with a R L or B (b for body)");
      controls.add("for healing your character: [Heal] if you have full health it will use it still and it will be wasted");
      controls.add("for attacking a monster in your room: [Attack]  the use the number associated with the monster you want to fight");
      controls.add("to veiw controls: [Controls] it lists the different commands you can use but you probably already know that");
      controls.add("to exit: [Exit] it will end the game and run the simplified credits");
      controls.add("");
   }
   public ArrayList<String> getTutorial() {
      return tutorial;
   }
   public void setTutorial() {
      tutorial.add("Welcome new player you have chosen to do the tutorial level here you will learn the basics");
      tutorial.add("lets first look at what you have in your inventory to do that type [Inventory]");
      tutorial.add("great now that you are able to look in your inventory you can see what items you have");
      tutorial.add("now lets try equipping an item to do that type [Equip]");
      tutorial.add("now that you've done that select which quipment slot you want to equip an item to for our purposes use [R]");
      tutorial.add("great now select which item you want to equip to your right slot use the number [1] for the rusty sword");
      tutorial.add("great now to look into a room to see what there is in a room type [Look] to see whats around you");
      tutorial.add("oh look there is a Trap Disarming Kit lets go get it to do that type [Grab]");
      tutorial.add("now that you did that type the number associated with the Kit use [1]");
      tutorial.add("cool despite sounding very useful there isn't anything you can do with this though if its not equipable");
      tutorial.add("lets drop it to do that type [Drop]");
      tutorial.add("now type the number associated with the kit to drop it so use [3]");
      tutorial.add("Good now you know how to interact with most items");
      tutorial.add("Oh remeber when we looked around the room there was a Goblin lets attack it to do that type [Attack]");
      tutorial.add("Now choose which monster you want to attack for our purposes type [1]");
      tutorial.add("ok now we are in a battle with the goblin go and swing your rusty sword at it by typing [R]");
      tutorial.add("oh no the goblin attacked back repeat the last instruction until you have slain the goblin");
      tutorial.add("congratulations on slaying your first monster oh look the goblin dropped something lets look at the room");
      tutorial.add("oh looks like it dropped a Goblin Dagger lets grab it");
      tutorial.add("Good...  Oh no looks like you got hurt lets heal to do that type [Heal]");
      tutorial.add("Ok to see if we are good now type [Health] this will tell us what our health is at");
      tutorial.add("Great now that we are all healed equip the Goblin Dagger to your Left equipment slot");
      tutorial.add("ok now lets look to see it in our left slot type [Look L/R/B] for our purposes use [L]");
      tutorial.add("Great now lets go to another room [Move Up/Down/Left/Right] for our purposes lets go down");
      tutorial.add("Great now that you know how to do most things its time to start your real adventure");
      tutorial.add("for a list of all of the controls type [Controls] once you exit the tutorial");
      tutorial.add("not all controls are used in the tutorial good luck new player hope your adventure is a good one");
   }
   public ArrayList<String> getTutorialSteps() {
      return tutorialSteps;
   }
   public void setTutorialSteps() {
      tutorialSteps.add("");
      tutorialSteps.add("INVENTORY");
      tutorialSteps.add("");
      tutorialSteps.add("EQUIP");
      tutorialSteps.add("R");
      tutorialSteps.add("1");
      tutorialSteps.add("LOOK");
      tutorialSteps.add("GRAB");
      tutorialSteps.add("1");
      tutorialSteps.add("");
      tutorialSteps.add("DROP");
      tutorialSteps.add("3");
      tutorialSteps.add("");
      tutorialSteps.add("ATTACK");
      tutorialSteps.add("1");
      tutorialSteps.add("R");
      tutorialSteps.add("");
      tutorialSteps.add("LOOK");
      tutorialSteps.add("GRAB");
      tutorialSteps.add("HEAL");
      tutorialSteps.add("HEALTH");
      tutorialSteps.add("EQUIP");
      tutorialSteps.add("L");
      tutorialSteps.add("2");
      tutorialSteps.add("LOOK L");
      tutorialSteps.add("MOVE DOWN");
      tutorialSteps.add("");
      tutorialSteps.add("");
      tutorialSteps.add("");
   }
}