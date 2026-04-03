public class GameRunner {
   public static void main(String[] args) {
      Room room = new Room();
      Map map = new Map(6, 5);
      //System.out.println(map.getRandomRoom());
      //System.out.println(map.getRandomRoom());
      //System.out.println(map.getRandomRoom());
      int h = (int)(Math.random() * 3);
      for (int w = 0; w < 1000; w ++) {
         h = (int)(Math.random() * 3);
         System.out.println(h);
      }
      
   }
}