package W1.Tutorial_Tasks.src.hero;

// Library imports

import java.util.Arrays;
import java.util.HashSet;

/**
 * Provides an implementation for the Enhanced Human class which inherits from
 * (or extends) the SuperHero class.
 */
public class EnhancedHuman extends SuperHero{
    // Define the attributes associated with the EnhancedHuman class
    private HashSet<SuperPower> acquiredPowers;
    private boolean enhanced;

    /**
     * This constructor is used to instantiate the EnhancedHuman class.
     * @param normalIdentity the identity the Enhanced Human generally assumes.
     * @param enhancedIdentity the identity the Enhanced Human assumes when they become enhanced.
     * @param acquiredPowers the power they acquire when they are enhanced.
     */
    public EnhancedHuman(String normalIdentity, String enhancedIdentity, SuperHero[] acquiredPowers){
        super(normalIdentity, enhancedIdentity);
        // Convert the Array of powers into a HashSet (removes any duplicate powers that may exist in the array)
        this.acquiredPowers = new HashSet<SuperPower>(Arrays.asList(acquiredPowers));
        enhanced = false;
    }

    /**
     * Determines whether the EnhancedHuman has the queried power and is
     * currently enhanced.
     * @param queriedPower the power to be queried.
     * @return a Boolean denoting whether the enhanced human has the queried power.
     */
    @Override
    public boolean hasPower(SuperPower queriedPower){
        return enhanced && acquiredPowers.contains(queriedPower);
    }

    /**
     * Calculates the total power the EnhancedHuman possesses.
     * @return an integer representing the Enhanced Human's total power.
     */
    @Override
    public int totalPower(){
        // Initialise a totalPower variable
        int totalPower = 0;
        // Ensure the human is enhanced before calculating the total power
        if (enhanced){
            for (SuperPower power : acquiredPowers){
                totalPower += power.getValue();
            }
            return totalPower;
        }
        // Return 0 if the Enhanced Human is not currently enhanced.
        else{
            return 0;
        }
    }

    /**
     * Switches the Enhanced Human's identity to their alter ego and,
     * based on their current identity, switches whether they are
     * enhanced or not.
     */
    @Override
    public void switchIdentity(){
        super.switchIdentity();
        enhanced = !enhanced;
    }
}