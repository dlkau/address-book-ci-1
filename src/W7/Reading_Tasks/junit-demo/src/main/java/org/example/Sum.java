package org.example;

/**
 * This sum class is used to sum two numbers together.
 */
public class Sum {

    /**
     * This sum adds two given numbers together.
     * @param i the first number to be summed.
     * @param i1 the second number to be summed.
     * @return the total sum between the two values.
     */
    public int doSum(int i, int i1) throws Exception {
        int sum = i + i1;
        if (i > 0 && i1 > 0 && sum < 0) {
            throw new Exception("Overflow!");
        }
        return sum;
    }
}