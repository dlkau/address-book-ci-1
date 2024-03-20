package W3.Homework_Tasks.Infiltration.obstacles;

/**
 * This will represent some sort of obstacle that is able to block locations within the map.
 * The obstacle objects will also be represented by some sort of symbol as well.
 */
public interface Obstacle {

    /**
     * This will return the symbol that is associated with the given obstacle.
     * @return the symbol of the obstacle.
     */
    char getSymbol();

    /**
     * This method returns a true value if the provide location is obstructed by an obstacle, otherwise
     * it returns false.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return A boolean denoting whether the location has been obstructed by an obstacle or not.
     */
    boolean isLocationObstructed(int x, int y);
}
