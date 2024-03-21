package W4.Homework_Tasks.Infiltration.obstacles;

/**
 * This enum represents the different types of obstacles that can be assumed on the map.
 */
public enum ObstacleType {
    GUARD("g", 'g'),
    FENCE("f", 'f'),
    SENSOR("s", 's'),
    CAMERA("c", 'c'),
    WALL("w", 'w');

    private final String argumentName;
    private final char symbol;

    /**
     * This constructs a new ObstacleType object with the argument name and the flag.
     * @param argumentName the argument name of the obstacle type.
     * @param symbol the flag of the obstacle type.
     */
    ObstacleType(String argumentName, char symbol){
        this.argumentName = argumentName;
        this.symbol = symbol;
    }

    /**
     * This method returns the argument name of the given ObstacleType.
     * @return the argument name of the ObstacleType.
     */
    public String getArgumentName(){
        return argumentName;
    }

    /**
     * This method returns the symbol of the given ObstacleType.
     * @return the symbol of the given ObstacleType.
     */
    public char getSymbol(){
        return symbol;
    }
}