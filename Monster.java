public class Monster {
private String monsterType;
   private final String[] monsterTypes = {
            "Goblin",
            "Skeleton Warrior",
            "Zombie",
            "Orc",
            "Dark Sorcerer",
            "Giant Spider",
            "Vampire Bat",
            "Slime",
            "Mimic",
            "Lich",
            "Troll",
            "Werewolf",
            "Gargoyle",
            "Wraith",
            "Minotaur",
            "Basilisk",
            "Doppelgänger",
            "Demon Hound",
            "Cave Serpent",
            "Ancient Dragon"
        };
   private int mHealth = 0;
   private String[] mAttackName;
   private int[] mAttackDamage;
   private int whereHealAttack;
   private int whereBlock;
   private int healAmount;
   private int blockAmount;
   public Monster() {
      // TODO: Pick a random monster type from monsterTypes
      monsterType = monsterTypes[(int)(Math.random()* monsterTypes.length)];
      mAttackName = new String[3];
      mAttackDamage = new int[3];
      if (monsterType == "Goblin") {
         mHealth = 20;
         mAttackName[0] = "stabbed you";
         mAttackName[1] = "eat a herb";
         mAttackName[2] = "clubbed you";
         
         mAttackDamage[0] = 2;
         mAttackDamage[1] = 0; //heal 2 damage from goblin
         mAttackDamage[2] = 4;
         
         whereHealAttack = 1;
         whereBlock = -1;
         healAmount = 2;
         blockAmount = 0;
         
      }
      else if (monsterType == "Skeleton Warrior") {
         mHealth = 30;
         mAttackName[0] = "slashed you with its sword";
         mAttackName[1] = "blocked with its sheild";
         mAttackName[2] = "stabbed you";
         
         mAttackDamage[0] = 5;
         mAttackDamage[1] = 0; //-5 damage from your next attack
         mAttackDamage[2] = 6;
         
         whereHealAttack = -1;
         whereBlock = 1;
         healAmount = 0;
         blockAmount = 5;
      }
      else if (monsterType == "Zombie") {
         mHealth = 25;
         mAttackName[0] = "scratched you";
         mAttackName[1] = "punched you";
         mAttackName[2] = "bit you";
         
         mAttackDamage[0] = 3;
         mAttackDamage[1] = 2;
         mAttackDamage[2] = 4;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Orc") {
         mHealth = 35;
         mAttackName[0] = "swung its sword";
         mAttackName[1] = "eat a herb";
         mAttackName[2] = "punched you";
         
         mAttackDamage[0] = 6;
         mAttackDamage[1] = 0; //heals 3 damage from orc
         mAttackDamage[2] = 4;
         
         whereHealAttack = 1;
         whereBlock = -1;
         healAmount = 3;
         blockAmount = 0;
      }
      else if (monsterType == "Dark Sorcerer") {
         mHealth = 40;
         mAttackName[0] = "used shadow lance";
         mAttackName[1] = "used void spikes";
         mAttackName[2] = "used heal";
         
         mAttackDamage[0] = 8;
         mAttackDamage[1] = 6;
         mAttackDamage[2] = 0; //heals 6 damage from d sorcerer
         
         whereHealAttack = 2;
         whereBlock = -1;
         healAmount = 6;
         blockAmount = 0;
      }
      else if (monsterType == "Giant Spider") {
         mHealth = 25;
         mAttackName[0] = "sheilded itself";
         mAttackName[1] = "bit you";
         mAttackName[2] = "used venom spray";
         
         mAttackDamage[0] = 0; // -3 damage from your next attack
         mAttackDamage[1] = 4;
         mAttackDamage[2] = 3;
         
         whereHealAttack = -1;
         whereBlock = 0;
         healAmount = 0;
         blockAmount = 3;
      }
      else if (monsterType == "Vampire Bat") {
         mHealth = 20;
         mAttackName[0] = "bit you";
         mAttackName[1] = "clawed you";
         mAttackName[2] = "shrieked";
         
         mAttackDamage[0] = 2; // heals 5 damage from bat
         mAttackDamage[1] = 3;
         mAttackDamage[2] = 2;
         
         whereHealAttack = 0;
         whereBlock = -1;
         healAmount = 5;
         blockAmount = 0;
      }
      else if (monsterType == "Slime") {
         mHealth = 10;
         mAttackName[0] = "used jello body";
         mAttackName[1] = "spit slime at you";
         mAttackName[2] = "bounce";
         
         mAttackDamage[0] = 0; //heals 5 damage from itself and stacks raising health
         mAttackDamage[1] = 1;
         mAttackDamage[2] = 2;
         
         whereHealAttack = 0;
         whereBlock = -1;
         healAmount = 5;
         blockAmount = 0;
      }
      else if (monsterType == "Mimic") {
         mHealth = 30;
         mAttackName[0] = "mimicked a Dark Sorcerer and used shadow lance";
         mAttackName[1] = "mimicked a Demon Hound and used hellfire";
         mAttackName[2] = "mimicked a Werewolf and used regenerate";
         
         mAttackDamage[0] = 8;
         mAttackDamage[1] = 8;
         mAttackDamage[2] = 6; //heals 6 damage from self
         
         whereHealAttack = 2;
         whereBlock = -1;
         healAmount = 6;
         blockAmount = 0;
      }
      else if (monsterType == "Lich") {
         mHealth = 50;
         mAttackName[0] = "used abysses wrath";
         mAttackName[1] = "used flame of darkness";
         mAttackName[2] = "used soul drain";
         
         mAttackDamage[0] = 15;
         mAttackDamage[1] = 12;
         mAttackDamage[2] = 8; //also heals 8 damage from self also stacks
         
         whereHealAttack = 2;
         whereBlock = -1;
         healAmount = 8;
         blockAmount = 0;
      }
      else if (monsterType == "Troll") {
         mHealth = 40;
         mAttackName[0] = "sheilded itself";
         mAttackName[1] = "punched you";
         mAttackName[2] = "swung its club";
         
         mAttackDamage[0] = 6; // -6 damage from your next attack
         mAttackDamage[1] = 4;
         mAttackDamage[2] = 8;
         
         whereHealAttack = 0;
         whereBlock = 0;
         healAmount = 0;
         blockAmount = 6;
      }
      else if (monsterType == "Werewolf") {
         mHealth = 40;
         mAttackName[0] = "used regenerate";
         mAttackName[1] = "bit you";
         mAttackName[2] = "clawed you";
         
         mAttackDamage[0] = 0; //heal 8 damage from self
         mAttackDamage[1] = 8;
         mAttackDamage[2] = 5;
         
         whereHealAttack = 0;
         whereBlock = -1;
         healAmount = 8;
         blockAmount = 0;
      }
      else if (monsterType == "Gargoyle") {
         mHealth = 35;
         mAttackName[0] = "slashed you";
         mAttackName[1] = "clawed you";
         mAttackName[2] = "bit you";
         
         mAttackDamage[0] = 3;
         mAttackDamage[1] = 3;
         mAttackDamage[2] = 4;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Wraith") {
         mHealth = 25;
         mAttackName[0] = "used will o' wisp";
         mAttackName[1] = "used spirit drain";
         mAttackName[2] = "used hex";
         
         mAttackDamage[0] = 4;
         mAttackDamage[1] = 3; //heals 3 from itself as well
         mAttackDamage[2] = 3;
         
         whereHealAttack = 1;
         whereBlock = -1;
         healAmount = 3;
         blockAmount = 0;
      }
      else if (monsterType == "Minotaur") {
         mHealth = 40;
         mAttackName[0] = "swung its axe";
         mAttackName[1] = "charged at you";
         mAttackName[2] = "punched you";
         
         mAttackDamage[0] = 9;
         mAttackDamage[1] = 6;
         mAttackDamage[2] = 4;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Basilisk") {
         mHealth = 30;
         mAttackName[0] = "peers into your eyes";
         mAttackName[1] = "bit you";
         mAttackName[2] = "swung its tail";
         
         mAttackDamage[0] = 7;
         mAttackDamage[1] = 5;
         mAttackDamage[2] = 3;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Doppelgänger") {
         mHealth = 50;
         mAttackName[0] = "copy";
         mAttackName[1] = "copy";
         mAttackName[2] = "copy";
         
         mAttackDamage[0] = 0;
         mAttackDamage[1] = 0;
         mAttackDamage[2] = 0;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Demon Hound") {
         mHealth = 40;
         mAttackName[0] = "used revitalizing flame";
         mAttackName[1] = "clawed you";
         mAttackName[2] = "used hellfire";
         
         mAttackDamage[0] = 2; // heals 4 from self
         mAttackDamage[1] = 4;
         mAttackDamage[2] = 8;
         
         whereHealAttack = 0;
         whereBlock = -1;
         healAmount = 4;
         blockAmount = 0;
      }
      else if (monsterType == "Cave Serpent") {
         mHealth = 30;
         mAttackName[0] = "used poison breath";
         mAttackName[1] = "swung its tail";
         mAttackName[2] = "bit you";
         
         mAttackDamage[0] = 8;
         mAttackDamage[1] = 4;
         mAttackDamage[2] = 5;
         
         whereHealAttack = -1;
         whereBlock = -1;
         healAmount = 0;
         blockAmount = 0;
      }
      else if (monsterType == "Ancient Dragon") {
         mHealth = 60;
         mAttackName[0] = "used dragons breath";
         mAttackName[1] = "used dragons blessing";
         mAttackName[2] = "used dragons rage";
         
         mAttackDamage[0] = 10;
         mAttackDamage[1] = 10; //heals 15 damage from self
         mAttackDamage[2] = 15;
         
         whereHealAttack = 1;
         whereBlock = -1;
         healAmount = 15;
         blockAmount = 0;
      }
   }
   public String getMonsterType() {
      return this.monsterType;
   }
   public int getMHealth() {
      return this.mHealth;
   }
   public void takeDamage(int damage) {
      this.mHealth -= damage;
   }
   public String[] getMAttacks() {
      return this.mAttackName;
   }
   public int[] getMAttackDamage() {
      return this.mAttackDamage;
   }
   public int whereHeal() {
      return this.whereHealAttack;
   }
   public int whereBlock() {
      return this.whereBlock;
   }
   public int getHealAmount() {
      return this.healAmount;
   }
   public int getBlockAmount() { 
      return this.blockAmount;
   }
   public void healM(int healNum) {
      this.mHealth += healNum;
   }
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return monsterType;
      
   }
}