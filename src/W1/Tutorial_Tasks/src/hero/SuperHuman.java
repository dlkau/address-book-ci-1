package W1.Tutorial_Tasks.src.hero;

// Library imports
import java.util.Arrays;
import java.util.HashSet;

/**
 * Provides an implementation for the SuperHuman class which inherits from
 * (or extends) the SuperHero class.
 */
public class SuperHuman extends SuperHero{
    // Define the attributes associated with the SuperHuman class
    private HashSet<SuperPower> currentPowers;

    /**
     * This constructor is used to instantiate the SuperHuman class.
     * @param realName the identity the SuperHuman generally assumes.
     * @param secretIdentity the identity the SuperHuman assumes when they become enhanced.
     * @param innatePowers the power the SuperHuman originally possesses.
     */
    public SuperHuman(String realName, String secretIdentity, SuperPower[] innatePowers){
        super(realName, secretIdentity);
        this.currentPowers = new HashSet<SuperPower>(Arrays.asList(innatePowers));
    }

    /**
     * When given an array of powers, each power is looped through and if it does
     * not currently exist in the HashSet, then it is added, else nothing happens.
     * @param newPowers the 'new' superpowers to be looped through.
     */
    public void acquirePowers(SuperPower[] newPowers){
        for(SuperPower power : newPowers){
            currentPowers.add(power);
        }
    }

    /**
     * This method returns a Boolean value which stipulates whether the object
     * possesses the queried power.
     * @param queriedPower the power to be queried.
     * @return a Boolean value depicting whether the SuperHuman as the queried
     * power or not.
     */
    @Override
    public boolean hasPower(SuperPower queriedPower){
        return currentPowers.contains(queriedPower);
    }

    /**
     * This method, when given an Array of SuperPowers, will remove each Power from
     * the HashSet if applicable.
     * @param oldPowers the array of powers to be removed.
     */
    public void losePowers(SuperPower[] oldPowers){
        for(SuperPower powerToRemove : oldPowers){
            currentPowers.remove(powerToRemove);
        }
    }

    /**
     * Calculates the total power the SuperHuman possesses.
     * @return an integer representing the SuperHuman's total power.
     */
    @Override
    public int totalPower(){
        // Initialise a totalPower variable
        int totalPower = 0;
        // Iterate over each power and add it to the total
        for(SuperPower power : currentPowers){
            totalPower += power.getValue();
        }
        return totalPower;
    }
}