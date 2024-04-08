package W6.Reading_Tasks.com.example;

/**
 * The class declaration below provides the implementation for a
 * bank account object.
 */
public class BankAccount {
    // Attributes for a Bank Account
    private int id;
    private String firstName;
    private String lastName;
    private int bankBalance;

    /**
     * This constructor is used to instantiate a new BankAccount object with a parameter for an id.
     * @param id the id for the bank account
     * @param firstName the first name of the person with the bank account
     * @param lastName the last name of the person with the bank account
     * @param bankBalance the balance of the person's bank account.
     */
    public BankAccount(int id, String firstName, String lastName, int bankBalance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankBalance = bankBalance;
    }

    /**
     * This constructor is used to instantiate a new BankAccount object without providing an id.
     * @param firstName the first name of the person with the bank account
     * @param lastName the last name of the person with the bank account
     * @param bankBalance the balance of the person's bank account.
     */
    public BankAccount(String firstName, String lastName, int bankBalance){
        // Since the id is auto-incremented, it is nice to have a constructor
        // without it.
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankBalance = bankBalance;
    }

    /**
     * This getter is used to return the id for the given BankAccount instance.
     * @return the id for the given BankAccount instance.
     */
    public int getId(){
        return this.id;
    }

    /**
     * This getter is used to return the first name for the given BankAccount instance.
     * @return the first name for this BankAccount instance.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * This getter is used to return the last name for the given BankAccount instance.
     * @return the lastname for this BankAccount instance.
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * This getter is used to return the balance for the given BankAccount.
     * @return the balance for this BankAccount instance.
     */
    public int getBankBalance(){
        return this.bankBalance;
    }

    /**
     * This setter is used to set the balance for this given instance of BankAccount.
     * @param bankBalance the balance to be set.
     */
    public void SetBankBalance(int bankBalance){
        this.bankBalance = bankBalance;
    }

    /**
     * This setter is used to set the first name for a given instance of BankAccount.
     * @param firstName the first name to be ascribed to the BankAccount object
     */
    public void SetFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * This setter is used to set the last name for a given instance of BankAccount.
     * @param lastName the last name to be ascribed ot the BankAccount object.
     */
    public void SetLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Outputs a String representation of an instance of a BankAccount object.
     * @return a String representing a BankAccount object.
     */
    @Override
    public String toString(){
        return "BankAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankBalance=" + bankBalance +
                '}';
    }
}