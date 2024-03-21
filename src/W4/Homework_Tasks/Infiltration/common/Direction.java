package W4.Homework_Tasks.Infiltration.common;

/**
 * This enum provides the implementation for the four cardinal directions.
 */
public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    /**
     * This static method processes a direction, provided as a string, and returns one
     * of the enum value.
     * @param arg
     * @return
     */
    public static Direction parse(String arg){
        switch (arg.toUpperCase()){
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
            default:
                throw new IllegalArgumentException("Direction must be one of n, s, e, w");
        }
    }

    /**
     * This method returns the direction from one location to another.
     * @param from the starting location.
     * @param to the end location.
     * @return the direction from the first location to the second location.
     */
    public static Direction getDirection(Location from, Location to){
        int xDiff = to.getX() - from.getX();
        int yDiff = to.getY() - from.getY();
        if (xDiff == 0 && yDiff == 0){
            return null;
        }
        if (xDiff == 0) {
            return yDiff > 0 ? SOUTH : NORTH;
        }
        if (yDiff == 0){
            return xDiff >0 ? EAST : WEST;
        }
        return null;
    }
}