package interactables;
import items.Item;
import items.Key;

public class Locker implements Unlockable {
    private String name;
    private String requiredKeyId;
    private boolean locked;
    private Item contents;

    public Locker(String name, String requiredKeyId, Item contents) {
        this.name = name;
        this.requiredKeyId = requiredKeyId;
        this.locked = true;
        this.contents = contents;
    }

    @Override
    public String getUnlockableName() {
        return name;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public String unlock(Key key) {
        if (!locked) {
            return "The " + name + " is already unlocked.";
        }
        if (key.getKeyId().equals(requiredKeyId)) {
            locked = false;
            return "Click! The " + name + " unlocks.";
        }
        return "This key doesn't fit.";
    }

    @Override
    public String interact() {
        if (locked) {
            return "The " + name + " is locked. You need a key.";
        }
        if (contents != null) {
            String msg = "Inside the " + name + " you find: " + contents.getName();
            return msg;
        }
        return "The " + name + " is empty.";
    }

    public Item takeContents() {
        Item item = contents;
        contents = null;
        return item;
    }
}
