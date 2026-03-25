import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      
      // TODO: Create a Player at a random location in the Map
      Player player = new Player(100, "player", (int)(Math.random() * dungeonMap.getNumRows()), (int)(Math.random() * dungeonMap.getNumCols()));
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
            
      while (exitGame != true) {
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
                int selectedItem = scanner.nextLine();
                if (selectedItem =< player.getRoom(dungeonMap).getItems().size() + 1 && selectedItem > 0) {
                  player.addItemToInventory(player.getRoom(dungeonMap).getItems(selectedItem));
                  player.getRoom(dungeonMap).takeItem(selectedItem - 1);
                }
                else {
                  System.out.println("That item is not in this room");
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
                  if (player.getX() + 1 <= dungeonMap.getNumCols()) {
                     player.moveTo(player.getX() + 1, player.getY());
                  }
               } else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
            }
         // TODO: display a message to the user telling them their current coordinates every time they move
         System.out.println("                   You are at coodinates: {" + player.getX() + ", " + player.getY() + "}");
       }
   }
}