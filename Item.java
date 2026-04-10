public class Item {
   private String itemType;
   private boolean isEquipped;
   private boolean specialItem;
   private int durability;
   private int manaCost;
   private boolean magicItem;
   private boolean replishMana;
   private int amountMReplish;
   private int amountBlocks;
   private boolean canBlock;
   private String whereEquipped;
   private final String[] itemTypes = {
            "Rusty Sword",
            "Healing Potion",
            "Torch",
            "Ancient Scroll",
            "Chainmail Armor",
            "Silver Key",
            "Magic Amulet",
            "Goblin Dagger",
            "Spellbook of Fire",
            "Bag of Gold Coins",
            "Mysterious Rune Stone",
            "Skeleton Bone",
            "Cursed Ring",
            "Potion of Invisibility",
            "Iron Shield",
            "Dragon Egg",
            "Trap Disarming Kit",
            "Crystal Orb",
            "Venomous Dagger",
            "Tattered Map",
            "Knights Sword",
            "Wooden Club",
            "Minotaurs Axe",
            "Spellbook of Darkness",
            "Mana Potion"
        };
        private int attackDamage;
        private String whereEquip;

   public Item() {
      // TODO: Pick a random item type from itemTypes
      itemType = itemTypes[(int)(Math.random()* itemTypes.length)];
      if (itemType == "Rusty Sword") {
         attackDamage = 5;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 15;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Healing Potion") {
         attackDamage = 20;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 1;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Ancient Scroll") {
         attackDamage = 50; // vanishes after use
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 1;
         magicItem = true;
         manaCost = 35;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Chainmail Armor") {
         whereEquip = "body";
         isEquipped = false;
         specialItem = false;
         durability = 30;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 8;
         whereEquipped = null;
      }
      else if (itemType == "Magic Amulet") {
         attackDamage = 20; //shatters after 4 uses
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 4;
         magicItem = true;
         manaCost = 20;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 10;
         whereEquipped = null;
      }
      else if (itemType == "Goblin Dagger") {
         attackDamage = 3;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 15;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Spellbook of Fire") {
         attackDamage = 7;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 20;
         magicItem = true;
         manaCost = 10;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Mysterious Rune Stone") {
         attackDamage = 30; // shatters after use
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 1;
         magicItem = true;
         manaCost = 20;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Cursed Ring") {
         attackDamage = 15; //does 10 damage to user as well when used also breaks after 3 uses
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 3;
         magicItem = false;
         manaCost = 10;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Potion of Invisibility") {
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 1;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Iron Shield") {
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 30;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = true;
         amountBlocks = 5;
         whereEquipped = null;
      }
      else if (itemType == "Crystal Orb") {
         attackDamage = 5;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 10;
         magicItem = true;
         manaCost = 10;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Mana Potion") {
         attackDamage = 0;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 1;
         magicItem = false;
         manaCost = 0;
         replishMana = true;
         amountMReplish = 20;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Venomous Dagger") {
         attackDamage = 10;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 40;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Knights Sword") {
         attackDamage = 8;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 30;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Wooden Club") {
         attackDamage = 4;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 20;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Minotaurs Axe") {
         attackDamage = 8;
         whereEquip = "hand";
         isEquipped = false;
         specialItem = false;
         durability = 30;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else if (itemType == "Spellbook of Darkness") {
         attackDamage = 12; // vanishes after 3 uses
         whereEquip = "hand";
         isEquipped = false;
         specialItem = true;
         durability = 3;
         magicItem = true;
         manaCost = 20;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
      else {
         whereEquip = "";
         isEquipped = false;
         specialItem = false;
         durability = 0;
         magicItem = false;
         manaCost = 0;
         replishMana = false;
         amountMReplish = 0;
         canBlock = false;
         amountBlocks = 0;
         whereEquipped = null;
      }
   }
   public void equipped() {
      isEquipped = true;
   }
   public int getDamage() {
      return this.attackDamage;
   }
   public void unEquipped() {
      isEquipped = false;
   }
   public boolean isEquipped() {
      return isEquipped;
   }
   public String getItemType() {
      return this.itemType;
   }
   public String getEquipSlot(String itemType) {
      return this.whereEquip;
   }
   public boolean isSpecial() {
      return this.specialItem;
   }
   public int getDurability() {
      return this.durability;
   }
   public boolean isMagicItem() {
      return this.magicItem;
   }
   public int getManaCost() {
      return this.manaCost;
   }
   public boolean canReplishMana() {
      return this.replishMana;
   }
   public int getReplishAmount() {
      return this.amountMReplish;
   }
   public boolean canBlock() {
      return this.canBlock;
   }
   public int getAmountCanBlock() {
      return this.amountBlocks;
   }
   public void used() {
      this.durability -= 1;
   }
   public String getWhereEquipped() {
      return this.whereEquipped;
   }
   public void setWhereEquipped(String location) {
      this.whereEquipped = location;
   }
   public void setItemType(String itemName) {
      this.itemType = itemName;
   }
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return itemType;
      
   }
}