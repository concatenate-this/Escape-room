package interactables;

import items.Key;

public interface Unlockable {
    String getUnlockableName();
    boolean isLocked();
    String unlock(Key key);
    String interact();
}
