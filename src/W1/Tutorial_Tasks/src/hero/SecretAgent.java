package W1.Tutorial_Tasks.src.hero;

/**
 * Provides an implementation for the Secret Agent class which inherits from
 * (or extends) the Hero class.
 */
public class SecretAgent implements Hero{
    // Define the attributes associated with the Secret Agent class
    private String trueName;
    private String codeName;
    private String gadget;
    private String currentName;

    /**
     * This constructor is used to instantiate the SecretAgent class.
     * @param trueName the Secret Agent's true name.
     * @param codeName the nae the Secret Agent uses at work.
     * @param gadget the Secret Agent's favourite gadget.
     */
    public SecretAgent(String trueName, String codeName, String gadget){
        this.trueName = trueName;
        this.codeName = codeName;
        this.gadget = gadget;
        this.currentName = trueName;
    }

    /**
     * Returns the current identity the Secret Agent is using.
     * @return the Secret Agent's current identity.
     */
    public String currentIdentity(){
        return currentName;
    }

    /**
     * This getter returns the Secret Agent's favourite gadget.
     * @return the Secret Agent's favourite gadget.
     */
    public String getGadget(){
        return gadget;
    }

    /**
     * Switches the current identity the Secret Agent's identities.
     */
    public void switchIdentity(){
        if(currentName.equals(trueName)){
            currentName = codeName;
        } else {
            currentName = trueName;
        }
    }
}