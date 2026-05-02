
package entities;
import items.Item;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() { 
        return name;
    }

    // Controlled access — no direct list exposure
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("Added to inventory: " + item.getName());
    }

    public boolean removeItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public boolean hasItem(String itemName) {
        return getItem(itemName) != null;
    }

    public void showInventory() throws InterruptedException {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("=== Inventory ===");
        for (Item item : inventory) {
            try{
            Thread.sleep(500);
            }
           catch(InterruptedException e) {
               throw new InterruptedException("Problem in typing");
           }
           
            System.out.println(" - " + item.toString());
           
        }
    }
}
