package interactables;

import items.Key;

public class Door implements Unlockable {
    private String name;
    private String requiredKeyId;
    private boolean locked;

    public Door(String name, String requiredKeyId) {
        this.name = name;
        this.requiredKeyId = requiredKeyId;
        this.locked = true;
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
            return "The door is already unlocked.";
        }
        if (key.getKeyId().equals(requiredKeyId)) {
            locked = false;
            return "The door creaks open!";
        }
        return "This key doesn't fit the door.";
    }

    @Override
    public String interact() {
        if (locked) {
            return "The door is locked tight.";
        }
        return "The door is open. You can escape!";
    }
}
