
package game;
public class Main {
     public static void typeWriter(String text, int delay) {

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("\nTyping interrupted!");
                return; // stop method if interrupted
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.start();
    }
}
