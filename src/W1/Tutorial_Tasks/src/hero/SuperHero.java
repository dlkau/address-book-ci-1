package W1.Tutorial_Tasks.src.hero;

import W1.Tutorial_Tasks.src.hero.*;

public abstract class SuperHero implements Hero {
    // Define the attributes associated with the SuperHero class
    private String trueIdentity;
    private String alterEgo;
    private String currentIdentity;

    /**
     * This constructor is used to define the base characteristics of a Super Hero
     * which each inheriting class will implement.
     * @param trueIdentity the identity the hero has at birth.
     * @param alterEgo the hero identity the SuperHero class assumes.
     */
    public SuperHero(String trueIdentity, String alterEgo){
        this.trueIdentity = trueIdentity;
        this.alterEgo = alterEgo;
        this.currentIdentity = trueIdentity;
    }

    /**
     * Returns as string denoting the current identity the SuperHero assumes.
     * @return a String representing the SuperHero's current identity.
     */
    @Override
    public String currentIdentity(){
        return this.currentIdentity;
    }

    /**
     * This method when invoked, switches the SuperHero's current identity to
     * their alter ego.
     */
    @Override
    public void switchIdentity(){
        if(currentIdentity.equals(this.alterEgo)){
            this.currentIdentity = this.trueIdentity;
        } else {
            this.currentIdentity = this.alterEgo;
        }
    }

    /**
     * The method determines whether the SuperHero has the queried power.
     * @param queriedPower the power to be queried.
     * @return a boolean denoting whether the SuperHero has htis power.
     */
    public abstract boolean hasPower(SuperPower queriedPower);

    /**
     * This method returns the total power the superhero has based on their
     * currently possessed powers.
     * @return an integer representing the sum of all his or her powers.
     */
    public abstract int totalPower();
}