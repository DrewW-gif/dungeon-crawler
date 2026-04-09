import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      int damageMBlocked = 0;
      int damageBlock = 0;
      boolean usedHPot = false;
      int invis = 0;
      int dInvis = 0;
      boolean usedInvis = false;
      boolean pBlocked = false;
      int amountItemBlocked = 0;
      int amountArmorBlocked = 0;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      
      // TODO: Create a Player at a random location in the Map
      Player player = new Player(100, 100, "player", (int)(Math.random() * dungeonMap.getNumRows()), (int)(Math.random() * dungeonMap.getNumCols()));
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
      System.out.println("Welcome what is your name?");
      String chosenName = scanner.nextLine();
      player.setName(chosenName);
      while (exitGame != true) {
      System.out.println("                   You are at coodinates: {" + player.getX() + ", " + player.getY() + "}");
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
                        
            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            }
            else if (input.equals("LOOK") || input.equals("SEARCH")) {
               System.out.println(player.look(dungeonMap));
            }
            if (input.equals("GRAB")) {
                String itemsInCurrentRoom = "Which item do you want to add to your inventory (press associated number to item): ";
                int itemNum = 0;
                for (int t = 0; t < player.getRoom(dungeonMap).getItems().size(); t++) {
                  itemNum = t + 1;
                  itemsInCurrentRoom = itemsInCurrentRoom + itemNum + ")" + player.getRoom(dungeonMap).getItems().get(t) + " ";
                }
                System.out.println(itemsInCurrentRoom);
                if (scanner.hasNextInt()) {
                  int selectedItem = scanner.nextInt();
                  scanner.nextLine();
                  if (player.getRoom(dungeonMap).getItems().size() > 0) {
                    if (selectedItem <= player.getRoom(dungeonMap).getItems().size() + 1 && selectedItem > 0) {
                      player.addItemToInventory(player.getRoom(dungeonMap).getItems().get(selectedItem - 1));
                      player.getRoom(dungeonMap).takeItem(selectedItem - 1);
                    }
                    else {
                      System.out.println("That item is not in this room");
                    }
                  }
               }
               else {
                  System.out.println("Invalid input! Please enter a number.");
                  scanner.nextLine();
               }
            }
            if (input.equals("DROP")) {
               String itemsInInventory = "Which item do you want to drop (press associated number to item): ";
               int count = 1;
               for (Item inventoryItem : player.getInventory()) {
                  itemsInInventory = itemsInInventory + count + ")" + inventoryItem + " ";
                  count++;
               }
               System.out.println(itemsInInventory);
               int selectedInventoryItem = scanner.nextInt();
               scanner.nextLine();
               if (selectedInventoryItem > 0 && selectedInventoryItem <= player.getInventory().size()) {
                  selectedInventoryItem -= 1;
                  int numOfItem = 0;
                  for (Item pickedItem : player.getInventory()) {
                     if (pickedItem.equals(player.getItemFromInventory(selectedInventoryItem))) {
                        numOfItem++;
                     }
                  }
                  if (numOfItem == 1) {
                     if (player.getItemFromInventory(selectedInventoryItem).isEquipped()) {
                        if (player.getItemFromInventory(selectedInventoryItem).getWhereEquipped().equals("Left")) {
                           player.unequipL();
                        }
                        else if (player.getItemFromInventory(selectedInventoryItem).getWhereEquipped().equals("Right")) {
                           player.unequipR();
                        }
                        else if (player.getItemFromInventory(selectedInventoryItem).getWhereEquipped().equals("Body")) {
                           player.unequipB();
                        }
                        else {
                           System.out.println("If you are seeing this something went wrong and some how the item you selected is not equipped");
                        }
                     }
                  }
                  System.out.println("You dropped " + player.getItemFromInventory(selectedInventoryItem));
                  player.getRoom(dungeonMap).dropItem(player.getItemFromInventory(selectedInventoryItem));
                  player.removeItemFromInventory(player.getItemFromInventory(selectedInventoryItem));
               }
               else {
                  System.out.println("You don't have that item");
               }
            }
            if (input.equals("ATTACK")) {
               System.out.println("Which moster would you like to attack?: ");
               int mCount = 0;
               for (int m = 0; m < player.getRoom(dungeonMap).getMonsters().size(); m++) {
                  mCount = m + 1;
                  System.out.println(mCount + ")" + player.getRoom(dungeonMap).getMonsters().get(m));
               }
               if (scanner.hasNextInt()) {
                  int chosenMonster = scanner.nextInt();
                  scanner.nextLine();
                  if (chosenMonster <= player.getRoom(dungeonMap).getMonsters().size() && chosenMonster > 0) {
                     System.out.println("You have chosen to attack the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + "!");
                     System.out.println("--------------------Preparing Battle--------------------");
                     System.out.println("Items equipped");
                     System.out.println("Left: " + player.checkLSlot());
                     System.out.println("Armor: " + player.checkBSlot());
                     System.out.println("Right: " + player.checkRSlot());
                     invis = 0;
                     dInvis = 0;
                     while (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth() > 0 && player.getHealth() > 0) {
                        damageBlock = 0;
                        usedHPot = false;
                        usedInvis = false;
                        pBlocked = false;
                        if (dInvis > 0) {
                           invis--;
                        }
                        amountItemBlocked = 0;
                        System.out.println(player.getName() + "'s Health: " + player.getHealth() + "   " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + "'s Health: " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth());
                        System.out.println("");
                        System.out.println("Which item do you want to use L)" + player.checkLSlot() + "   or R)" + player.checkRSlot());
                        String attack = scanner.nextLine().toUpperCase();
                        if (attack.equals("R")) {
                           if (!player.rSlotOpen()) {
                              if (player.checkRSlot().isMagicItem()) {
                                 if (player.getCurrentMana() >= player.checkRSlot().getManaCost()) {
                                    player.useMagicItem(player.checkRSlot().getManaCost());
                                    player.checkRSlot().used();
                                    if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                          
                                    }
                                    else {
                                       if (dInvis > 0) {
                                       
                                       }
                                       else {
                                          player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                       }
                                    }
                                 }
                                 else {
                                    System.out.println("You didn't  have enough mana to attack");
                                 }
                              }
                              if (player.checkRSlot().canBlock()) {
                                 damageBlock = player.checkRSlot().getAmountCanBlock();
                                 pBlocked = true;
                                 amountItemBlocked = player.checkRSlot().getAmountCanBlock();
                              }
                              if (player.checkRSlot().isSpecial()) {
                                 if (player.checkRSlot().isMagicItem() == false) {
                                    if (player.checkRSlot().getItemType().equals("Healing Potion")) {
                                       player.heal(20);
                                       player.checkRSlot().used();
                                       usedHPot = true;
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Potion of Invisibility")) {
                                       invis = 2;
                                       player.checkRSlot().used();
                                       usedInvis = true;
                                    }
                                    else  if (player.checkRSlot().getItemType().equals("Cursed Ring")) {
                                       if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                          
                                       }
                                       else {
                                          if (dInvis > 0) {
                                          
                                          }
                                          else {
                                             player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                          }
                                       }
                                       player.takeDamage(10);
                                       player.checkRSlot().used();
                                    }
                                 }
                              }
                              else if (player.checkRSlot().canReplishMana()) {
                                 player.addMana(player.checkRSlot().getReplishAmount());
                              }
                              else {
                                 if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                    
                                 }
                                 else {
                                    player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                 }
                              }
                           }
                           else {
                              if (damageMBlocked > 0) {
                                 
                              }
                              else {
                                 player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(1);
                              }
                           }
                        }  
                        else if (attack.equals("L")) {
                           if (!player.lSlotOpen()) {
                              if (player.checkLSlot().isMagicItem()) {
                                 if (player.getCurrentMana() >= player.checkLSlot().getManaCost()) {
                                    player.useMagicItem(player.checkLSlot().getManaCost());
                                    player.checkLSlot().used();
                                    if (player.checkLSlot().getDamage() - damageMBlocked <= 0) {
                                    
                                    }
                                    else {
                                       player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage() - damageMBlocked);
                                    }
                                 }
                                 else {
                                    System.out.println("You didn't  have enough mana to attack");
                                 }
                              }
                              if (player.checkLSlot().canBlock()) {
                                 damageBlock = player.checkLSlot().getAmountCanBlock();
                                 pBlocked = true;
                                 amountItemBlocked = player.checkLSlot().getAmountCanBlock();
                              }
                              if (player.checkLSlot().isSpecial()) {
                                 if (player.checkLSlot().isMagicItem() == false) {
                                    if (player.checkLSlot().getItemType().equals("Healing Potion")) {
                                       player.heal(20);
                                       player.checkLSlot().used();
                                       usedHPot = true;
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Potion of Invisibility")) {
                                       invis = 2;
                                       player.checkLSlot().used();
                                       usedInvis = true;
                                    }
                                    else  if (player.checkLSlot().getItemType().equals("Cursed Ring")) {
                                       if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                    
                                       }
                                       else {
                                          player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage() - damageMBlocked);
                                       }
                                       player.takeDamage(10);
                                       player.checkRSlot().used();
                                    }
                                 }
                              }
                              else if (player.checkLSlot().canReplishMana()) {
                                 player.addMana(player.checkLSlot().getReplishAmount() - damageMBlocked);
                              }
                              else {
                                 if (player.checkLSlot().getDamage() - damageMBlocked <= 0) {
                                    
                                 }
                                 else {
                                    player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage());
                                 }
                              }
                           }
                           else {
                              if (damageMBlocked > 0) {
                                 
                              }
                              else {
                                 player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(1);
                              }
                           }
                        }
                        if (!player.rSlotOpen()) {
                           if (player.checkRSlot().getDurability() <= 0) {
                              for (int r = 0; r < player.getInventory().size(); r++) {
                                 if (player.getItemFromInventory(r).isEquipped()) {
                                    if (player.getItemFromInventory(r).getWhereEquipped().equals("Right")) {
                                       player.removeItemFromInventory(player.getItemFromInventory(r));
                                       player.unequipR();
                                    }
                                 }
                              }
                           }
                        }
                        if (!player.lSlotOpen()) {
                           if (player.checkLSlot().getDurability() <= 0) {
                              for (int l = 0; l < player.getInventory().size(); l++) {
                                 if (player.getItemFromInventory(l).isEquipped()) {
                                    if (player.getItemFromInventory(l).getWhereEquipped().equals("Left")) {
                                       player.removeItemFromInventory(player.getItemFromInventory(l));
                                       player.unequipL();
                                    }
                                 }
                              }
                           }
                        }
                        if (!player.bSlotOpen()) {
                           if (player.checkBSlot().getDurability() <= 0) {
                              for (int b = 0; b < player.getInventory().size(); b++) {
                                 if (player.getItemFromInventory(b).isEquipped()) {
                                    if (player.getItemFromInventory(b).getWhereEquipped().equals("Body")) {
                                       player.removeItemFromInventory(player.getItemFromInventory(b));
                                       player.unequipB();
                                    }
                                 }
                              }
                           }
                        }
                           if (dInvis > 0) {
                              dInvis--;
                           }
                           player.addMana(1);
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth() <= 0) {
                              break;
                           }
                           damageMBlocked = 0;
                           if (!player.bSlotOpen()) {
                              damageBlock += player.checkBSlot().getAmountCanBlock();
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMonsterType().equals("Doppelganger")) {
                              damageMBlocked = damageBlock - amountItemBlocked;
                              if (usedInvis) {
                                 dInvis = 2;
                              }
                              else if (usedHPot) {
                                 player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).healM(20);
                              }
                              else if (pBlocked) {
                                 damageMBlocked += amountItemBlocked;
                              }
                              else {
                                 int soulProtection = (int)(damageBlock / 2);
                                 player.takeDamage(50 - player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth() - soulProtection);
                              }
                           }
                           else {
                              int monsterAttack = (int)(Math.random() * 3);
                              System.out.println(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " just " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack]);
                              if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).whereHeal() == monsterAttack) {
                                 if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] - damageBlock <= 0) {
                                       
                                 }
                                 else {
                                    if (invis > 0) {
                                    
                                    }
                                    else {
                                       player.takeDamage(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] - damageBlock);
                                    }
                                 }
                                 if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] > 0) {
                                    if (damageBlock > 0) {
                                       if (pBlocked) {
                                          if (attack.equals("R")) {
                                             player.checkRSlot().used();
                                          }
                                          if (attack.equals("L")) {
                                             player.checkLSlot().used();
                                          }
                                          if (!player.bSlotOpen()) {
                                             player.checkBSlot().used();
                                          }
                                       }
                                    }
                                 }
                                 player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).healM(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getHealAmount());
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).whereBlock() == monsterAttack) {
                                 damageMBlocked = player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getBlockAmount();
                              }
                              else {
                                 if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] - damageBlock <= 0) {
                                    
                                 }
                                 else {
                                    if (invis > 0) {
                                    
                                    }
                                    else {
                                       player.takeDamage(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] - damageBlock);
                                    }
                                 }
                                 if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] > 0) {
                                    if (damageBlock > 0) {
                                       if (pBlocked) {
                                          if (attack.equals("R")) {
                                             if (!player.rSlotOpen()) {
                                                player.checkRSlot().used();
                                             }
                                          }
                                          if (attack.equals("L")) {
                                             if (!player.lSlotOpen()) {
                                                player.checkLSlot().used();
                                             }
                                          }
                                          if (!player.bSlotOpen()) {
                                             player.checkBSlot().used();
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                        if (player.getHealth() <= 0) {
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("----------------   Y O U   D I E D   ------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           try {
                              Thread.sleep(2000);
                           } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                           }
                           System.out.println("");
                           System.out.println("");
                           System.out.println("");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("----------   G  A  M  E       O  V  E  R   ------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.println("-------------------------------------------------------");
                           System.out.print("-------------------------------------------------------");
                           exitGame = true;
                        }
                        else {
                           System.out.println("You killed the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Skeleton Warrior")) {
                              int ranDropNum = (int)(Math.random() * 6);
                              for (int d = 0; d < 0; d++) {
                                 player.getRoom(dungeonMap).addItem("Skeleton Bone");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Skeleton Bone");
                              }
                              int ranRSChance = (int)(Math.random() * 100);
                              int ranKSChance = (int)(Math.random() * 100);
                              if (ranRSChance == 16) {
                                 player.getRoom(dungeonMap).addItem("Rusty Sword");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Rusty Sword");
                              }
                              else if (ranKSChance == 512) {
                                 player.getRoom(dungeonMap).addItem("Knights Sword");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Knights Sword!!!!");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Goblin")) {
                              int ranGDChance = (int)(Math.random() * 100);
                              if (ranGDChance == 58) {
                                 player.getRoom(dungeonMap).addItem("Goblin Dagger");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Goblin Dagger");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Ancient Dragon")) {
                              player.getRoom(dungeonMap).addItem("Dragon Egg");
                              int ranASChance = (int)(Math.random() * 1000);
                              int randomAncientScrollChance = (int)(Math.random() * 1000);
                              int ranMRSChance = (int)(Math.random() * 1000);
                              if (randomAncientScrollChance == ranASChance) {
                                 player.getRoom(dungeonMap).addItem("Ancient Scroll");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped an -=-=-=-Ancient Scrol-=-=-=-!!!!");
                              }
                              if (ranMRSChance == 999) {
                                 player.getRoom(dungeonMap).addItem("Mysterious Rune Stone");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a -X-X-X-Mysterious Rune Stone-X-X-X-!!!");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Dark Sorcerer")) {
                              int ranMAChance = (int)(Math.random() * 20);
                              if (ranMAChance == 8) {
                                 player.getRoom(dungeonMap).addItem("Magic Amulet");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Magic Amulet");
                              }
                              int ranSBODChance = (int)(Math.random() * 1000);
                              if (ranSBODChance == 666) {
                                 player.getRoom(dungeonMap).addItem("Spellbook of Darkness");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a >>x<>x<>x<>x<Spellbook of Darkness>x<>x<>x<>x<<");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Lich")) {
                              int ranLSBODChance = (int)(Math.random() * 500);
                              int ranCRChance = (int)(Math.random() *100);
                              if (ranLSBODChance == 400) {
                                 player.getRoom(dungeonMap).addItem("Spellbook of Darkness");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a >>x<>x<>x<>x<Spellbook of Darkness>x<>x<>x<>x<<");
                              }
                              if (ranCRChance == 20) {
                                 player.getRoom(dungeonMap).addItem("Cursed Ring");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Cursed Ring");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Minotaur")) {
                              player.getRoom(dungeonMap).addItem("Minotaurs Axe");
                              System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Minotaurs Axe");
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Cave Serpent")) {
                              int ranVDChance = (int)(Math.random() * 100);
                              if (ranVDChance == 42) {
                                 player.getRoom(dungeonMap).addItem("Venomous Dagger");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a ~x~x~Vonomous Dagger~x~x~");
                              }
                           }
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).equals("Troll")) {
                              int ranClubChance = (int)(Math.random() * 10);
                              if (ranClubChance == 4) {
                                 player.getRoom(dungeonMap).addItem("Wooden Club");
                                 System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " dropped a Wooden Club");
                              }
                           }
                           player.getRoom(dungeonMap).monsterSlain(chosenMonster - 1);
                        }
                     }
                     else {
                        System.out.println("That is not a valid option");
                     }
                  }
                  else {
                     System.out.println("Invalid input! Please enter a number.");
                     scanner.nextLine();
                  }
               }
           
            if (input.equals("LOOK L")) {
               System.out.println(player.checkLSlot());
            }
            if (input.equals("LOOK R")) {
               System.out.println(player.checkRSlot());
            }
            if (input.equals("EQUIP")) {
               System.out.println("Where do you want to equip an item? R (right) L (left) or B (body)");
               String location = scanner.nextLine().toUpperCase();
               if (location.equals("B")) {
                  if (player.bSlotOpen()) {
                     if (player.getArmor().size() > 0) {
                        System.out.println("Which item would you like to equip? (press the cooresponding number): ");
                        player.getArmor();
                        for (int b = 0; b < player.getArmor().size(); b++) {
                           int aCount = b + 1;
                           System.out.println(aCount + ")" + player.getArmor().get(b));
                        }
                        if (scanner.hasNextInt()) {
                           int chosenArmor = scanner.nextInt();
                           if (chosenArmor - 1 <= player.getArmor().size()) {
                              player.equipB(player.getArmor().get(chosenArmor - 1));
                              player.getArmor().get(chosenArmor - 1).equipped();
                              System.out.println("You just equipped a " + player.getArmor().get(chosenArmor - 1) + " set");
                           }
                        }
                        else {
                           System.out.println("Invalid input! Please enter a number.");
                           scanner.nextLine(); // CRITICAL: Clear the letters out of the scanner
                        }
                     }
                     else {
                        System.out.println("Sorry you don't have and armor that can go there");
                     }
                  }
                  else {
                     System.out.println("You already have something equipped there");
                  }
               }
               else if (location.equals("L")) {
                  if (player.lSlotOpen()) {
                     System.out.println("Which item would you like to equip? (press the cooresponding number): ");
                     for (int j = 0; j <= player.getEquipableItems().size() - 1; j++) {
                        int count = j + 1;
                        player.getEquipableItems();
                        System.out.println(count + ")" + player.getEquipableItem(j));
                     }
                     if (scanner.hasNextInt()) {
                        int chosenEquip = scanner.nextInt();
                        if (player.getEquipableItems().size() > 0) {
                           if  (player.getEquipableItems().get(chosenEquip - 1).isEquipped()) {
                              System.out.println("This item is already equipped");
                           }
                           else {
                              if (chosenEquip <= player.getEquipableItems().size() + 1 && chosenEquip > 0) {
                                 player.equipL(player.getEquipableItems().get(chosenEquip - 1));
                                 player.getEquipableItems().get(chosenEquip - 1).equipped();
                                 System.out.println("You just equipped a " + player.getEquipableItems().get(chosenEquip - 1) + " to your Left equipment slot");
                              }
                           }
                        }
                     }
                     else {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.nextLine(); // CRITICAL: Clear the letters out of the scanner
                     }
                  }
                  else {
                     System.out.println("You already have " + player.checkLSlot() + " equipped there");
                  }
               }
               else if (location.equals("R")) {
                  if (player.rSlotOpen()) {
                     for (int k = 0; k <= player.getEquipableItems().size() - 1; k++) {
                        int count = k + 1;
                        player.getEquipableItems();
                        System.out.println(count + ")" + player.getEquipableItem(k));
                     }
                     if (scanner.hasNextInt()) {
                        int chosenEquip = scanner.nextInt();
                        if (player.getEquipableItems().size() > 0) {
                           if  (player.getEquipableItems().get(chosenEquip - 1).isEquipped()) {
                              System.out.println("This item is already equipped");
                           }
                           else {
                              if (chosenEquip <= player.getEquipableItems().size() + 1 && chosenEquip > 0) {
                                 player.equipR(player.getEquipableItems().get(chosenEquip - 1));
                                 player.getEquipableItems().get(chosenEquip - 1).equipped();
                                 System.out.println("You equipped a " + player.getEquipableItems().get(chosenEquip - 1) + "to your right equipment slot");
                              }
                           }
                        }
                     }
                     else {
                        System.out.println("You already have something equipped there");
                     }
                  }
                  else {
                     System.out.println("You already have " + player.checkRSlot() + " equipped there");
                  }
               }
               else {
                  System.out.print("That isn't an equipment slot");
               }
            }
            if (input.equals("UNEQUIP")) {
               System.out.println("What do you want to unequip from? R (right) L (left) or B (body)");
               String slot = scanner.nextLine().toUpperCase();
               if (slot.equals("R")) {
                  if (player.rSlotOpen()) {
                     System.out.println("This slot is empty");
                  }
                  else {
                     System.out.println("You just unequipped your " + player.checkRSlot() + " from your right equipment slot");
                     player.checkRSlot().unEquipped();
                     player.unequipR();
                  }
               }
               else if (slot.equals("L")) {
                  if (player.lSlotOpen()) {
                     System.out.println("This slot is empty");
                  }
                  else {
                     System.out.println("You just unequipped your " + player.checkLSlot() + " from your left equiipment slot");
                     player.checkLSlot().unEquipped();
                     player.unequipL();
                  }
               }
               else if (slot.equals("B")) {
                  if (player.bSlotOpen()) {
                     System.out.println("This slot is empty");
                  }
                  else {
                     System.out.println("You just took off your " + player.checkBSlot());
                     player.checkBSlot().unEquipped();
                     player.unequipB();
                  }
               }
               else {
                  System.out.println("That isn't an equipment slot");
               }
            }
            if (input.equals("INVENTORY")) {
               String curInventory = "Your inventory contains: ";
               for (Item inItem : player.getInventory()) {
                  curInventory = curInventory + "\n" + inItem;
               }
               System.out.println(curInventory);
            }
            if (input.equals("HEAL")) {
               //for (int iT = 0; iT < player.getInventory.size(); iT++) {
               //   if (player.getInventory().get(iT).getItemType().equals("Healing Potion")) {
               if (player.hasItem("Healing Potion")) {
               int countOfHeal = 0;
                  for (int h = 0; h < player.getInventory().size(); h++) {
                     if (player.getItemFromInventory(h).getItemType().equals("Healing Potion")) {
                        countOfHeal++;
                     }
                  }
                  if (countOfHeal > 1) {
                     for (int hp = 0; hp < player.getInventory().size(); hp++) {
                        if (player.getInventory().get(hp).getItemType().equals("Healing Potion")) {
                           if (player.getItemFromInventory(hp).isEquipped()) {
                              
                           }
                           else {
                              System.out.println("You just healed yourself your HP is now at :" + player.getHealth());
                              player.heal(20);
                              player.removeItemFromInventory(player.getItemFromInventory(hp));
                              break;
                           }
                        }
                     }
                  }
                  else {
                     for (int hPot = 0; hPot < player.getInventory().size(); hPot++) {
                        if (player.getInventory().get(hPot).getItemType().equals("Healing Potion")) {
                           if (player.getInventory().get(hPot).isEquipped()) {
                              if (player.getInventory().get(hPot).getWhereEquipped().equals("Left")) {
                                 System.out.println("You just healed yourself your HP is now at :" + player.getHealth());
                                 player.heal(20);
                                 player.unequipL();
                                 player.removeItemFromInventory(player.getItemFromInventory(hPot));
                                 break;
                              }
                              else if (player.getInventory().get(hPot).getWhereEquipped().equals("Right")) {
                                 System.out.println("You just healed yourself your HP is now at :" + player.getHealth());
                                 player.unequipR();
                                 player.removeItemFromInventory(player.getItemFromInventory(hPot));
                                 player.heal(20);
                                 break;
                              }
                           }
                           else {
                              System.out.println("You just healed yourself your HP is now at :" + player.getHealth());
                              player.removeItemFromInventory(player.getItemFromInventory(hPot));
                              player.heal(20);
                              break;
                           }
                        }
                     }
                  }
               }
               else {
                  System.out.println("You do not have the necessary item to heal yourself");
               }
            }
            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               if (direction.equals("UP")) {
                  if (player.getY() - 1 >= 0) {
                     player.moveTo(player.getX(), player.getY() - 1);
                  }
               } else if (direction.equals("DOWN")) {
                  if (player.getY() + 1 <= dungeonMap.getNumRows()) {
                     player.moveTo(player.getX(), player.getY() + 1);
                  }
               } else if (direction.equals("LEFT")) {   
                  if (player.getX() - 1 >= 0) {
                     player.moveTo(player.getX() - 1, player.getY());
                  }
               } else if (direction.equals("RIGHT")) {
                  if (player.getX() + 1 < dungeonMap.getNumCols()  - 1) {
                     player.moveTo(player.getX() + 1, player.getY());
                  }
               }
               else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
            
         // TODO: display a message to the user telling them their current coordinates every time they move
         //System.out.println("                   You are at coodinates: {" + player.getX() + ", " + player.getY() + "}");
         }
      }
   }
}