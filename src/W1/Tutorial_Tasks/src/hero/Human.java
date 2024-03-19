package W1.Tutorial_Tasks.src.hero;

/**
 * Provides an implementation for the Human class which inherits from
 * (or extends) the SuperHero class.
 */
public class Human extends SuperHero{

    /**
     * This constructor is used to instantiate the Human class.
     * @param realName the name the human generally uses.
     * @param secretIdentity the identity the SuperHero assumes when they are saving people.
     */
    public Human(String realName, String secretIdentity){
        super(realName, secretIdentity);
    }

    /**
     * Returns the total power the Human has, which will always be 0.
     * @return the total power the Human has (will always be 0).
     */
    @Override
    public int totalPower(){
        return 0;
    }

    /**
     * This method, when given a queried power, will determine whether the human has it.
     * For the case of the human, they do not possess any powers, so this method will
     * always return false.
     * @param queriedPower the power to be queried.
     * @return a boolean value denoting whether the Human has the power (always will be false).
     */
    @Override
    public boolean hasPower(SuperPower queriedPower){
        return false;
    }
}