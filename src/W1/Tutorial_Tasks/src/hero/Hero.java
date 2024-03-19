package W1.Tutorial_Tasks.src.hero;

/**
 * This interface defines the two methods which are common to all heroes.
 */
public interface Hero {
    /**
     * This returns a string which identifies the current identity a
     * Hero is exhibiting.
     * @return the identity the hero is currently expressing.
     */
    public String currentIdentity();

    /**
     * Allows the hero to switch his/her identity.
     */
    public void switchIdentity();
}
