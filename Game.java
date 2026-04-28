import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      int damageMBlocked = 0;
      int damageBlock = 0;
      boolean usedHPot = false;
      int invis = 0;
      int dInvis = 0;
      boolean next = false;
      boolean go = false;
      boolean usedInvis = false;
      boolean moveOn = false;
      int tHealth = 100;
      int tMana = 100;
      int tMHealth = 0;
      boolean pBlocked = false;
      int amountItemBlocked = 0;
      int amountArmorBlocked = 0;
      boolean monsterSpawns = true;
      boolean attacked = false;
      String input = null;
      boolean beatTheGame = false;
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
      System.out.println("Welcome " + chosenName + " do you want to do the tutorial first?");
      System.out.println("Anything that happenneds in the tutorial will no be carried over into the actual game after you finish");
      System.out.println("                                                                               [Yes/No]");
      String yesOrNo = scanner.nextLine().toUpperCase();
      if (yesOrNo.equals("YES")) {
         player.setTutorial();
         player.setTutorialSteps();
         int tx = 0;
         int ty = 0;
         attacked = false;
         for (int tutorialStep = 0; tutorialStep <= player.getTutorialSteps().size(); tutorialStep++) {
            next = false;
            moveOn = false;
            while (next == false) {
               System.out.println("                                   You are at coordinates: {" + tx + ", " + ty + "}");
               System.out.println(player.getTutorial().get(tutorialStep));
               String response = scanner.nextLine().toUpperCase();
               if (tutorialStep > 0) {
                  if (player.getTutorialSteps().get(tutorialStep - 1).equals("ATTACK")) {
                     tutorialStep += 1;
                     tMana = 100;
                     boolean chosen = false;
                     while (chosen == false) {
                        System.out.println("Which monster would you like to attack:");
                        System.out.println("1)Goblin");
                        String Goblin = scanner.nextLine();
                        if (Goblin.equals("1")) {
                           System.out.println("You have chosen to attack the Goblin");
                           System.out.println("--------------------Preparing Battle--------------------");
                           System.out.println("Items equipped");
                           System.out.println("Left: Empty");
                           System.out.println("Armor: Empty");
                           System.out.println("Right: Rusty Sword");
                           System.out.println(chosenName + "'s Health: 100  Goblin's Health: 20");
                           System.out.println("Your current mana is at " + tMana);
                           System.out.println("");
                           boolean r = false;
                           tutorialStep += 1;
                           while (r == false) {
                              System.out.println("Which item do you want to use L)Empty  or R)Rusty Sword");
                              System.out.println(player.getTutorial().get(tutorialStep));
                              String R = scanner.nextLine().toUpperCase();
                              if (R.equals("R")) {
                                 tutorialStep += 1;
                                 System.out.println("You swing your rusty sword towards the Goblin");
                                 tMHealth -= 5;
                                 System.out.println("The Goblin just stabbed you");
                                 tHealth -= 2;
                                 tMana++;
                                 System.out.println(chosenName + "'s Health: " + tHealth + "  Goblin's Health: " + tMHealth);
                                 System.out.println("Your currnt mana is at " + tMana);
                                 System.out.println("");
                                 System.out.println(player.getTutorial().get(tutorialStep));
                                 boolean battling = true;
                                 while (battling == true) {
                                    System.out.println("Which item do you want to use L)Empty  or R)Rusty Sword");
                                    String tAttack = scanner.nextLine().toUpperCase();
                                    System.out.println(chosenName + "'s Health: " + tHealth + "  Goblin's Health: " + tMHealth);
                                    System.out.println("Your currnt mana is at " + tMana);
                                    System.out.println("");
                                    System.out.println("Which item do you want to use L)Empty  or R)Rusty Sword");
                                    String leftOrRight = scanner.nextLine().toUpperCase();
                                    if (leftOrRight.equals("R")) {
                                       System.out.println("You swing your rusty sword towards the Goblin");
                                       tMHealth -= 5;
                                    }
                                    else if (leftOrRight.equals("L")) {
                                       
                                    }
                                    else {
                                       
                                    }
                                 }
                              }
                              else if (R.equals("L")) {
                                 System.out.println("Sorry before you try punching the Goblin attack  it with your sword it does more damage than your fists type [R]");
                              }
                              else {
                                 System.out.println("Sorry we are trying to attack the goblinif you get distracted in a real fight the monster will still attack type [R]");
                              }
                           }
                        }
                        else {
                           System.out.println("Sorry we are trying to attack the Goblin try typing [1]");
                        }
                     }
                  }
               }
               if (player.getTutorialSteps().get(tutorialStep).equals("")) {
                  if (response.contains("")) {
                     next = true;
                  }
               }
               else {
                  if (response.equals(player.getTutorialSteps().get(tutorialStep))) {
                     if (player.getTutorialSteps().get(tutorialStep).equals("INVENTORY")) {
                        System.out.println("Your inventory contains:");
                        System.out.println("Rusty Sword");
                        System.out.println("Healing Potion");
                        next = true;
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("EQUIP")) {
                        if (tutorialStep < 10) {
                           tutorialStep += 1;
                        }
                        moveOn = false;
                        go = false;
                        while (moveOn == false) {
                           System.out.println("Where do you want to equip an item? R (right) L (left) or B (body)");
                           if (tutorialStep < 10) {
                              System.out.println(player.getTutorial().get(tutorialStep));
                           }
                           String lOrR = scanner.nextLine().toUpperCase();
                           if (tutorialStep < 10) {
                              if (lOrR.equals("R")) {
                                 tutorialStep += 1;
                                 while (go == false) {
                                    System.out.println("Which item would you like to equip? (press the cooresponding number): ");
                                    System.out.println("1)Rusty Sword");
                                    System.out.println("2)Healing Potion");
                                    System.out.println(player.getTutorial().get(tutorialStep));
                                    String one = scanner.nextLine();
                                    if (one.equals("1")) {
                                       System.out.println("You equipped a Rusty Sword to your right equipment slot");
                                       go = true;
                                       next = true;
                                       moveOn = true;
                                    }
                                    else {
                                       System.out.println("Sorry we are trying to equip the Rusty Sword try again");
                                    }
                                 }
                              }
                              else {
                                 System.out.println("Sorry we are trying to equip something to the Right equipment slot try typing [R]");
                              }
                           }
                           else {
                              if (lOrR.equals("L")) {
                                 System.out.println("Which item would you like to equip? (press the cooresponding number): ");
                                 System.out.println("1)Rusty Sword");
                                 System.out.println("2)Goblin Dagger");
                                 String two = scanner.nextLine();
                                 if (two.equals("2")) {
                                    System.out.println("You equipped a Goblin Dagger to your left equipment slot");
                                    go = true;
                                    next = true;
                                    moveOn = true;
                                 }
                                 else {
                                    System.out.println("Sorry we are trying to equip the Goblin Dagger try again");
                                 }
                              }
                              else {
                                 System.out.println("Sorry we are trying to equip something to the Left equipment slot try typing [L]");
                              }
                           }
                        }
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("LOOK")) {
                        if (attacked == true) {
                           System.out.println("Items in room:");
                           System.out.println(" a Trap Disarming Kit");
                           System.out.println(" a Goblin Dagger");
                           System.out.println("");
                           System.out.println("Monsters in room:");
                           next = true;
                        }
                        else {
                           System.out.println("Items in room:");
                           System.out.println(" a Trap Disarming Kit");
                           System.out.println("");
                           System.out.println("Monsters in room:");
                           System.out.println(" a Goblin stares at you");
                           next = true;
                        }
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("GRAB")) {
                        if (attacked == false) {
                           tutorialStep += 1;
                           boolean didIt = false;
                           while (didIt == false) {
                              System.out.println("Which item do you want to add to your inventory (press associated number to item): ");
                              System.out.println("1)Trap Disarming Kit");
                              System.out.println(player.getTutorial().get(tutorialStep));
                              String isOne = scanner.nextLine();
                              if (isOne.equals("1")) {
                                 System.out.println("You reach down and grab the Trap Disarming Kit");
                                 didIt = true;
                                 next = true;
                              }
                              else {
                                 System.out.println("Sorry we are trying to grab the Trap Disarming Kit try typing [1]");
                              }
                           }
                        }
                        else {
                           boolean doneIt = false;
                           while (doneIt == false) {
                              System.out.println("Which item do you want to add to your inventory (press associated number to item): ");
                              System.out.println("1)Trap Disarming Kit");
                              System.out.println("2)Goblin Dagger");
                              String isTwo = scanner.nextLine();
                              if (isTwo.equals("2")) {
                                 System.out.println("You reach down and grab the Goblin Dagger");
                                 doneIt = true;
                                 next = true;
                              }
                              else {
                                 System.out.println("Sorry we are trying to pick up the Goblin Dagger try typing [2]");
                              }
                           }
                        }
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("DROP")) {
                        boolean dropped = false;
                        tutorialStep += 1;
                        while (dropped == false) {
                           System.out.println("Which item do you want to drop (press associated number to item): 1))Rusty Sword 2)Healing Potion 3)Trap Disarming Kit");
                           System.out.println(player.getTutorial().get(tutorialStep));
                           String three = scanner.nextLine();
                           if (three.equals("3")) {
                              System.out.println("You dropped the Trap Disarming Kit");
                              dropped = true;
                              next = true;
                           }
                           else {
                              System.out.println("Sorry we are trying to drop the Trap Disarming Kit try typing [3]");
                           }
                        }
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("HEAL")) {
                        if (tHealth + 20 > 100) {
                           tHealth = 100;
                           next = true;
                        }
                        else {
                           tHealth += 20;
                           next = true;
                        }
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("HEALTH")) {
                        System.out.println("Your health is at " + tHealth);
                        next = true;
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("LOOK L")) {
                        System.out.println("Goblin Dagger");
                        next = true;
                     }
                     else if (player.getTutorialSteps().get(tutorialStep).equals("MOVE DOWN")) {
                        ty++;
                        next = true;
                     }
                  }
                  else {
                     System.out.println("Thats not what we are trying to do right now please try again");
                  }
               }
            }
         }
      }
      else {
         System.out.println("You have chosen to start the game good luck " + chosenName);
      }
      System.out.println("--------------------------Loading New Game------------------------");
      System.out.println("");
      System.out.println("~~~~~~ OBJECTIVE: Defeat all of the monsters in the dungeon ~~~~~~");
      while (exitGame != true) {
      if (attacked == false) {
      System.out.println("                   You are at coodinates: {" + player.getX() + ", " + player.getY() + "}");
            System.out.print("Enter command: ");
            input = scanner.nextLine().toUpperCase();
      }
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
                      System.out.println("You reach down and grab the " + player.getRoom(dungeonMap).getItems().get(selectedItem - 1));
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
               if (scanner.hasNextInt()) {
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
                     if (player.getItemFromInventory(selectedInventoryItem).getItemType().equals("Dragon Egg")) {
                        System.out.println("You place the dragon egg on the ground as you start to walk away the egg hatches into an Ancient Dragon");
                        player.removeItemFromInventory(player.getItemFromInventory(selectedInventoryItem));
                     }
                     else {
                        System.out.println("You dropped the " + player.getItemFromInventory(selectedInventoryItem));
                        player.getRoom(dungeonMap).dropItem(player.getItemFromInventory(selectedInventoryItem));
                        player.removeItemFromInventory(player.getItemFromInventory(selectedInventoryItem));
                     }
                  }
                  else {
                     System.out.println("You don't have that item");
                  }
               }
               else {
                  System.out.println("Invalid input! Please enter a number.");
                  scanner.nextLine();
               }
            }
            if (input.equals("ATTACK") || attacked == true) {
               int chosenMonster = 0;
               if (attacked == false) {
                  System.out.println("Which moster would you like to attack?: ");
                  int mCount = 0;
                  for (int m = 0; m < player.getRoom(dungeonMap).getMonsters().size(); m++) {
                     mCount = m + 1;
                     System.out.println(mCount + ")" + player.getRoom(dungeonMap).getMonsters().get(m));
                  }
               }
               if (scanner.hasNextInt() || attacked == true) {
                  if (attacked == false) {
                     chosenMonster = scanner.nextInt();
                     scanner.nextLine();
                  }
                  else {
                     chosenMonster = (int)(Math.random() * player.getRoom(dungeonMap).getMonsters().size());
                     chosenMonster += 1;
                  }
                  if (chosenMonster <= player.getRoom(dungeonMap).getMonsters().size() && chosenMonster > 0) {
                     if (attacked == false) {
                        System.out.println("You have chosen to attack the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                     }
                     else {
                        System.out.println("You have been attacked by a " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + "!!!!");
                     }
                     System.out.println("--------------------Preparing Battle--------------------");
                     System.out.println("Items equipped");
                     System.out.println("Left: " + player.checkLSlot());
                     System.out.println("Armor: " + player.checkBSlot());
                     System.out.println("Right: " + player.checkRSlot());
                     invis = 0;
                     dInvis = 0;
                     attacked = false;
                     while (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth() > 0 && player.getHealth() > 0) {
                        damageBlock = 0;
                        usedHPot = false;
                        usedInvis = false;
                        pBlocked = false;
                        if (invis > 0) {
                           invis--;
                        }
                        amountItemBlocked = 0;
                        System.out.println(player.getName() + "'s Health: " + player.getHealth() + "   " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + "'s Health: " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth());
                        System.out.println("Your current mana is at " + player.getCurrentMana());
                        System.out.println("");
                        System.out.println("Which item do you want to use L)" + player.checkLSlot() + "   or R)" + player.checkRSlot());
                        String attack = scanner.nextLine().toUpperCase();
                        if (attack.equals("R")) {
                           if (!player.rSlotOpen()) {
                              if (player.checkRSlot().isMagicItem()) {
                                 if (player.getCurrentMana() >= player.checkRSlot().getManaCost()) {
                                    player.useMagicItem(player.checkRSlot().getManaCost());
                                    player.checkRSlot().used();
                                    if (player.checkRSlot().getItemType().equals("Ancient Scroll")) {
                                       System.out.println("You read the incantation on the scroll in the ancient tongue a great power surges through you as you stare at the");
                                       System.out.println(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " you release the power at it in a runic swirl of power");
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Magic Amulet")) {
                                       System.out.println("You release the power in the amulet at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Spellbook of Fire")) {
                                       System.out.println("As you read the incantation on the page a blazing fire forms infront of you as the symbol on the page of the book");
                                       System.out.println("glows brighter and as you release the inferno upon the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " the page crumbles to ashes");
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Mysterious Rune Stone")) {
                                       System.out.println("As you transfer mana into the rune stone the markings on it begin to glow bright blue and you release a powerful");
                                       System.out.println("energy toward the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Crystal Orb")) {
                                       System.out.println("As you channel mana into the crystal orb a beam of magic shoots out towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                          System.out.println("...but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                    }
                                    else {
                                       if (dInvis > 0) {
                                          System.out.println(" ...but you missed");
                                       }
                                       else {
                                          if (player.checkRSlot().canPierce()) {
                                             if (player.checkRSlot().getItemType().equals("Mysterious Rune Stone")) {
                                                damageMBlocked = (int)(damageMBlocked * 0.5);
                                             }
                                             else if (player.checkRSlot().getItemType().equals("Ancient Scroll")) {
                                                damageMBlocked = 0;
                                             }
                                             else if (player.checkRSlot().getItemType().equals("Spellbook of Darkness")) {
                                                damageMBlocked = 0;
                                             }
                                             else {
                                                damageMBlocked = (int)(damageMBlocked * 0.75);
                                             }
                                          }
                                          player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                       }
                                    }
                                 }
                                 else {
                                    System.out.println("You didn't have enough mana to attack");
                                    player.useMagicItem(player.getCurrentMana());
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
                                       System.out.println("You drink a healing potion and heal 20 health points");
                                       player.heal(20);
                                       player.checkRSlot().used();
                                       usedHPot = true;
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Potion of Invisibility")) {
                                       System.out.println("You drink a potion of invisibility and fade from the room");
                                       invis = 2;
                                       player.checkRSlot().used();
                                       usedInvis = true;
                                    }
                                    else  if (player.checkRSlot().getItemType().equals("Cursed Ring")) {
                                       if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                          System.out.println("You released the energy kept within the cursed ring but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                       }
                                       else {
                                          if (dInvis > 0) {
                                             System.out.println("You released the energy kept within cursed ring but you missed");
                                          }
                                          else {
                                             System.out.println("You release the energy kept within the cursed ring as it glows brighter a burst of magic power is");
                                             System.out.println("released toward the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                             player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                          }
                                       }
                                       System.out.println("The cursed ring glows brighter as you feel your body slightly weaken");
                                       player.takeDamage(10);
                                       player.checkRSlot().used();
                                    }
                                 }
                              }
                              else if (player.checkRSlot().canReplishMana()) {
                                 player.addMana(player.checkRSlot().getReplishAmount());
                              }
                              else {
                                    if (player.checkRSlot().getItemType().equals("Rusty Sword")) {
                                       System.out.println("You swing your rusty sword towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Goblin Dagger")) {
                                       System.out.println("You slice at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " with your goblin dagger");
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Venomous Dagger")) {
                                       System.out.println("You slice at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " with your venomous dagger");
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Knights Sword")) {
                                       System.out.println("You swing your knights sword towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Wooden Club")) {
                                       System.out.println("You swing your wooden club towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkRSlot().getItemType().equals("Minotaurs Axe")) {
                                       System.out.println("You swing your minotaurs axe towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                 if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                    System.out.println(" ... but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                 }
                                 else {
                                    if (dInvis > 0) {
                                       System.out.println(" ...but you missed");
                                    }
                                    else {
                                       if (player.checkRSlot().canPierce()) {
                                          damageMBlocked = (int)(damageMBlocked * 0.75);
                                       }
                                       player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkRSlot().getDamage() - damageMBlocked);
                                    }
                                 }
                              }
                           }
                           else {
                              if (damageMBlocked > 0) {
                                 System.out.println("You swing your fists at the " +player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " but it protected itself");
                              }
                              else {
                                 if (dInvis > 0) {
                                    System.out.println(" ... but you missed");
                                 }
                                 else {
                                    System.out.println("You swing your fists at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(1);
                                 }
                              }
                           }
                        }  
                        else if (attack.equals("L")) {
                           if (!player.lSlotOpen()) {
                              if (player.checkLSlot().isMagicItem()) {
                                 if (player.getCurrentMana() >= player.checkLSlot().getManaCost()) {
                                    player.useMagicItem(player.checkLSlot().getManaCost());
                                    player.checkLSlot().used();
                                    if (player.checkLSlot().getItemType().equals("Ancient Scroll")) {
                                       System.out.println("You read the incantation on the scroll in the ancient tongue a great power surges through you as you stare at the");
                                       System.out.println(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " you release the power at it in a runic swirl of power");
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Magic Amulet")) {
                                       System.out.println("You release the power in the amulet at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Spellbook of Fire")) {
                                       System.out.println("As you read the incantation on the page a blazing fire forms infront of you as the symbol on the page of the book");
                                       System.out.println("glows brighter and as you release the inferno upon the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " the page crumbles to ashes");
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Mysterious Rune Stone")) {
                                       System.out.println("As you transfer mana into the rune stone the markings on it begin to glow bright blue and you release a powerful");
                                       System.out.println("energy toward the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Crystal Orb")) {
                                       System.out.println("As you channel mana into the crystal orb a beam of magic shoots out towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    if (player.checkLSlot().getDamage() - damageMBlocked <= 0) {
                                       System.out.println("...but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                    }
                                    else {
                                       if (dInvis > 0) {
                                          System.out.println(" ...but you missed");
                                       }
                                       else {
                                          if (player.checkLSlot().canPierce()) {
                                             if (player.checkLSlot().getItemType().equals("Mysterious Rune Stone")) {
                                                damageMBlocked = (int)(damageMBlocked * 0.5);
                                             }
                                             else if (player.checkLSlot().getItemType().equals("Ancient Scroll")) {
                                                damageMBlocked = 0;
                                             }
                                             else if (player.checkLSlot().getItemType().equals("Spellbook of Darkness")) {
                                                damageMBlocked = 0;
                                             }
                                             else {
                                                damageMBlocked = (int)(damageMBlocked * 0.75);
                                             }
                                          }
                                          player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage() - damageMBlocked);
                                       }
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
                                       System.out.println("You drink a healing potion and heal 20 health points");
                                       player.heal(20);
                                       player.checkLSlot().used();
                                       usedHPot = true;
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Potion of Invisibility")) {
                                       System.out.println("You drink a potion of invisibility and fade from the room");
                                       invis = 2;
                                       player.checkLSlot().used();
                                       usedInvis = true;
                                    }
                                    else  if (player.checkLSlot().getItemType().equals("Cursed Ring")) {
                                       if (player.checkRSlot().getDamage() - damageMBlocked <= 0) {
                                          System.out.println("You released the energy kept within the cursed ring but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                       }
                                       else {
                                          if (dInvis > 0) {
                                             System.out.println("You released the energy kept within cursed ring but you missed");
                                          }
                                          else {
                                             System.out.println("You release the energy kept within the cursed ring as it glows brighter a burst of magic power is");
                                             System.out.println("released toward the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                             player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage() - damageMBlocked);
                                          }
                                       }
                                       System.out.println("The cursed ring grows brighter as you feel your body slightly weaken");
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
                                    if (player.checkLSlot().getItemType().equals("Rusty Sword")) {
                                       System.out.println("You swing your rusty sword towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Goblin Dagger")) {
                                       System.out.println("You slice at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " with your goblin dagger");
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Venomous Dagger")) {
                                       System.out.println("You slice at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " with your venomous dagger");
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Knights Sword")) {
                                       System.out.println("You swing your knights sword towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Wooden Club")) {
                                       System.out.println("You swing your wooden club towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    else if (player.checkLSlot().getItemType().equals("Minotaurs Axe")) {
                                       System.out.println("You swing your minotaurs axe towards the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    }
                                    if (player.checkLSlot().getDamage() - damageMBlocked <= 0) {
                                       System.out.println("...but the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " protected itself completely");
                                    }
                                    else {
                                       if (dInvis > 0) {
                                          System.out.println(" ...but you missed");
                                       }
                                       else {
                                          if (player.checkLSlot().canPierce()) {
                                             damageMBlocked = (int)(damageMBlocked * 0.75);
                                          }
                                          player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(player.checkLSlot().getDamage());
                                       }
                                    }
                                 }
                              }
                           }
                           else {
                              if (damageMBlocked > 0) {
                                 System.out.println("You swing your fists at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " but it protected itself");
                              }
                              else {
                                 if (dInvis > 0) {
                                    System.out.println(" ...but you missed");
                                 }
                                 else {
                                    System.out.println("You swing your fists at the " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1));
                                    player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).takeDamage(1);
                                 }
                              }
                           }
                        }
                        if (!player.rSlotOpen()) {
                           if (player.checkRSlot().getDurability() <= 0) {
                              for (int r = 0; r < player.getInventory().size(); r++) {
                                 if (player.getItemFromInventory(r).isEquipped()) {
                                    if (player.getItemFromInventory(r).getWhereEquipped().equals("Right")) {
                                       if (player.checkRSlot().getItemType().contains("Potion")) {
                                          System.out.println("The empty potion bottle seems to evaporate into the air and disappears");
                                       }
                                       else {
                                          System.out.println("Your " + player.checkRSlot() + " broke");
                                       }
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
                                       if (player.checkLSlot().getItemType().contains("Potion")) {
                                          System.out.println("The empty potion bottle seems to evapotate into the air and disappears");
                                       }
                                       else {
                                          System.out.println("Your " + player.checkLSlot() + " broke");
                                       }
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
                                       System.out.println("Your " + player.checkBSlot() + " broke");
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
                                 System.out.println("The Doppelganger used shadow cloak and dissappeared");
                                 dInvis = 2;
                              }
                              else if (usedHPot) {
                                 player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).healM(15);
                                 System.out.println("The Doppelganger used heal and healed itself");
                              }
                              else if (pBlocked) {
                                 System.out.println("The DoppelGanger sheilded itself");
                                 damageMBlocked += amountItemBlocked;
                              }
                              else {
                                 int soulProtection = (int)(damageBlock / 4);
                                 System.out.println("The Doppelganger spoke something that sounded some what like an incantation in the ancient tongue and dark runic symbols");
                                 System.out.println("form around the Doppelganger and you circling the both of you as you feel a familiar pain spreading through out your");
                                 System.out.println("body as the symbols fade the Doppelganger stares into your eyes and grins with your smile");
                                 player.takeDamage(50 - player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMHealth() - soulProtection);
                              }
                           }
                           else {
                              int monsterAttack = (int)(Math.random() * 3);
                              if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("slashed you with its sword")) {
                                 damageBlock = (int)(damageBlock * 0.9);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("stabbed you")) {
                                 damageBlock = (int)(damageBlock * 0.8);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used shadow lance")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used void spikes")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used venom spray")) {
                                 damageBlock = (int)(damageBlock * 0.75);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("shrieked")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("mimicked a Dark Sorcerer and used shadow lance")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("mimicked a Demon Hound and used hellfire")) {
                                 damageBlock = (int)(damageBlock * 0.75);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used abysses wrath")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used flame of darkness")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used soul drain")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used will o' wisp")) {
                                 damageBlock = (int)(damageBlock * 0.75);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used spirit drain")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used hex")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("swung its axe")) {
                                 damageBlock = (int)(damageBlock * 0.75);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("charged at you")) {
                                 damageBlock = (int)(damageBlock * 0.6);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("peers into your eyes")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used hellfire")) {
                                 damageBlock = (int)(damageBlock * 0.7);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used poison breath")) {
                                 damageBlock = (int)(damageBlock * 0.6);
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used dragons breath")) {
                                 damageBlock = 0;
                              }
                              else if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack].equals("used dragons rage")) {
                                 damageBlock = (int)(damageBlock * 0.5);
                              }
                              System.out.println(player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " just " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttacks()[monsterAttack]);
                              if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).whereHeal() == monsterAttack) {
                                 if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] - damageBlock <= 0) {
                                    if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMAttackDamage()[monsterAttack] > 0) {
                                       System.out.println("But you successfully blocked");
                                    }
                                 }
                                 else {
                                    if (invis > 0) {
                                       System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " missed");
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
                                    System.out.println("But you successfully blocked");
                                 }
                                 else {
                                    if (invis > 0) {
                                       System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " missed");
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
                           if (!player.rSlotOpen()) {
                           if (player.checkRSlot().getDurability() <= 0) {
                              for (int r = 0; r < player.getInventory().size(); r++) {
                                 if (player.getItemFromInventory(r).isEquipped()) {
                                    if (player.getItemFromInventory(r).getWhereEquipped().equals("Right")) {
                                       System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " just broke your " + player.checkRSlot());
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
                                       System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " just broke your " + player.checkLSlot());
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
                                       System.out.println("The " + player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1) + " just broke your " + player.checkBSlot());
                                       player.removeItemFromInventory(player.getItemFromInventory(b));
                                       player.unequipB();
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
                           if (player.getRoom(dungeonMap).getMonsters().get(chosenMonster - 1).getMonsterType().equals("Doppelganger")) {
                              System.out.println("You've defeated the Doppelganger would you like to end the game and win or would you like to continue playing");
                              System.out.println("if you choose to continue you will have to clear out the dungeon again and defeat the Doppelganger once again");
                              System.out.println("to win and if you choose to exit you will win if you enter anything that isn't [stay] or [leave] you will");
                              System.out.println("be automatically transferred to the win screen what will you choose");
                              String nextAction = scanner.nextLine().toUpperCase();
                              if (nextAction.equals("STAY")) {
                                 System.out.println("You decided to stay...");
                                 System.out.println("------------Generating Monsters-----------");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 for (int mRow = 0; mRow < dungeonMap.getNumRows(); mRow++) {
                                    for (int mCol = 0; mCol < dungeonMap.getNumCols(); mCol++) {
                                       dungeonMap.getRoom(mRow, mCol).spawnMonster();
                                    }
                                 }
                                 System.out.println("Monsters replenished returning to game");
                                 monsterSpawns = true;
                              }
                              else if (nextAction.equals("LEAVE")) {
                                 System.out.println("You decided to leave congratulations!!!!");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("----------------  C O N G R A T U L A T I O N S  --------------------");
                                 System.out.println("------------------  Y  O  U      W  I  N  !!!!  ---------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 for (int end = 0; end < 10; end++) {
                                    try {
                                       Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                       Thread.currentThread().interrupt();
                                    }
                                    System.out.println("");
                                 }
                                 player.setWinCredits();
                                 for (int endCredits = 0; endCredits < player.getCredits().size(); endCredits++) {
                                    System.out.println(player.getCredits().get(endCredits));
                                    try {
                                       Thread.sleep(4000);
                                    } catch (InterruptedException e) {
                                       Thread.currentThread().interrupt();
                                    }
                                    System.out.println("");
                                    try {
                                       Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                       Thread.currentThread().interrupt();
                                    }
                                 }
                                 beatTheGame = true;
                                 exitGame = true;
                              }
                              else {
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("------------------  Y  O  U      W  I  N  !  ------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.println("---------------------------------------------------------------------");
                                 System.out.print("---------------------------------------------------------------------");
                                 beatTheGame = true;
                                 exitGame = true;
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
            if (input.equals("HEALTH")) {
               System.out.println("Your health is at " + player.getHealth());
            }
            if (input.equals("CHECK MANA")) {
               System.out.println("Your mana is at " + player.getCurrentMana());
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
                           scanner.nextLine();
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
                        scanner.nextLine();
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
            if (input.equals("RUN WINNERS CREDITS")) {
               player.setWinCredits();
               System.out.println("");
               System.out.println("");
               for (int runCredits = 0; runCredits < player.getCredits().size(); runCredits++) {
                  System.out.println(player.getCredits().get(runCredits));
                  try {
                     Thread.sleep(4000);
                  } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                  }
                  System.out.println("");
                  try {
                     Thread.sleep(1000);
                  } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                  }
               }
               player.resetCredits();
            }
            if (input.equals("CONTROLS")) {
               player.setControls();
               for (int controlLine = 0; controlLine < player.getControls().size(); controlLine++) {
                  System.out.println(player.getControls().get(controlLine));
                  try {
                     Thread.sleep(4000);
                  } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                  }
                  System.out.println("");
                  try {
                     Thread.sleep(1000);
                  } catch (InterruptedException e) {
                     Thread.currentThread().interrupt();
                  }
               }
            }
            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               int potentialAttack = (int)(Math.random() * 5);
               if (direction.equals("UP")) {
                  if (player.getY() - 1 >= 0) {
                     if (player.getRoom(dungeonMap).checkForMonsters()) {
                        if (potentialAttack == 4) {
                           attacked = true;
                         } 
                         else {
                            player.moveTo(player.getX(), player.getY() - 1);
                         }
                      }
                      else {
                         player.moveTo(player.getX(), player.getY() - 1);
                      }
                  }
               } else if (direction.equals("DOWN")) {
                  if (player.getY() + 1 <= dungeonMap.getNumRows()) {
                     if (player.getRoom(dungeonMap).checkForMonsters()) {
                        if (potentialAttack == 4) {
                           attacked = true;
                        }
                        else {
                           player.moveTo(player.getX(), player.getY() + 1);
                        }
                     }
                     else {
                        player.moveTo(player.getX(), player.getY() + 1);
                     }
                  }
               } else if (direction.equals("LEFT")) {   
                  if (player.getX() - 1 >= 0) {
                     if (player.getRoom(dungeonMap).checkForMonsters()) {
                        if (potentialAttack == 4) {
                           attacked = true;
                        }
                        else {
                           player.moveTo(player.getX() - 1, player.getY());
                        }
                     }
                     else {
                        player.moveTo(player.getX() - 1, player.getY());
                     }
                  }
               } else if (direction.equals("RIGHT")) {
                  if (player.getX() + 1 < dungeonMap.getNumCols()  - 1) {
                     if (player.getRoom(dungeonMap).checkForMonsters()) {
                        if (potentialAttack == 4) {
                           attacked = true;
                        }
                        else {
                           player.moveTo(player.getX() + 1, player.getY());
                        }
                     }
                     else {
                        player.moveTo(player.getX() + 1, player.getY());
                     }
                  }
               }
               else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
            
         // TODO: display a message to the user telling them their current coordinates every time they move
         //System.out.println("                   You are at coodinates: {" + player.getX() + ", " + player.getY() + "}");
         }
         int countOfEmptyRooms = 0;
         if (monsterSpawns = true) {
            for (int r = 0; r < dungeonMap.getNumRows(); r++) {
               for (int c = 0; c < dungeonMap.getNumCols(); c++) {
                  if (dungeonMap.getRoom(r, c).checkForMonsters() == false) {
                     countOfEmptyRooms++;
                  }
                  else {
                  }
               }
            }
         }
         if (countOfEmptyRooms == dungeonMap.getNumRows() * dungeonMap.getNumCols()) {
            monsterSpawns = false;
            dungeonMap.getRoom(0, 0).spawnDoppelganger();
            System.out.println("The Doppelganger appeared in room {0,0}");
         }
         else {
            for (int row = 0; row < dungeonMap.getNumRows(); row++) {
               for (int col = 0; col < dungeonMap.getNumCols(); col++) {
                  int monsterSpawnChance = (int)(Math.random() * 100);
                  if (monsterSpawnChance == 97) {
                     dungeonMap.getRoom(row, col).spawnMonster();
                  }
               }
            }
         }
      }
      if (beatTheGame == false) {
         player.setCredits();
         for (int exiting = 0; exiting < 10; exiting++) {
            try {
               Thread.sleep(500);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
            System.out.println("");
         }
         for (int exitingCredits = 0; exitingCredits < player.getCredits().size(); exitingCredits++) {
            System.out.println(player.getCredits().get(exitingCredits));
            try {
               Thread.sleep(4000);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
            System.out.println("");
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
         }
      }
   }
}