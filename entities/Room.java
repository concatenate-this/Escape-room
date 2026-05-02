
package entities;
import game.GameEngine;
import interactables.Unlockable;
import items.Item;
import java.util.ArrayList;
import java.util.List;
import puzzles.Puzzle;
public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Unlockable> unlockables;
    private List<Puzzle> puzzles;
    private boolean doorVisible;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.unlockables = new ArrayList<>();
        this.puzzles = new ArrayList<>();
        this.doorVisible = false;
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item takeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public void addUnlockable(Unlockable u) {
        unlockables.add(u);
    }

    public Unlockable getUnlockable(String name) {
        for (Unlockable u : unlockables) {
            if (u.getUnlockableName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    public void addPuzzle(Puzzle p) {
        puzzles.add(p);
    }

    public Puzzle getPuzzle(String name) {
        for (Puzzle p : puzzles) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

 

    public boolean isDoorVisible() {
        return doorVisible;
    }

    public void describe() throws InterruptedException {
        GameEngine.typeWriter("\n=== " + name + " ===",100);
        GameEngine.typeWriter(description, 100);
        if (!items.isEmpty()) {
            System.out.println("\nYou see:");
            for (Item item : items) {
            
            try{
            Thread.sleep(1000);
            }
           catch(InterruptedException e) {
               throw new InterruptedException("Problem in typing");
           }
                System.out.println(" - " + item.getName());
            }
        }

       for (Unlockable u : unlockables) {
            
            try{
            Thread.sleep(100);
            }
           catch(InterruptedException e) {
               throw new InterruptedException("Problem in typing");
           }
            System.out.println(" - " + u.getUnlockableName() + (u.isLocked() ? " (locked)" : " (unlocked)"));
            
        }

        for (Puzzle p : puzzles) {
            if (!p.isSolved()) {
                 
            try{
            Thread.sleep(100);
            }
           catch(InterruptedException e) {
               throw new InterruptedException("Problem in typing");
           }
                System.out.println(" - " + p.getName() + " (unsolved)");
            }
        }

      
    }
}
