package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.Location;

/**
 * This class provides the implementation details for the Guard obstacle.
 */
public class Guard extends LocatableObstacle {

    /**
     * This constructor instantiates a new Guard object on the map
     * using the given position.
     * @param location the location the guard is to be instantiated at.
     */
    public Guard(Location location){
        super(location);
    }

    /**
     * This method returns whether the given location is obstructed or not.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value denoting whether the given location is occupied or not.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        // A guard obstructs its own location
        return this.location.getX() == x &&
                this.location.getY() == y;
    }

    /**
     * This method returns the character encoding for the Guard object.
     * @return the character encoding of the Guard object as specified in the ObstacleType Enum.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.GUARD.getSymbol();
    }

    /**
     * This static method is used to instantiate a new Guard Object from a string argument.
     * @param arg the string argument representative of the 'x' and 'y' position of the guard.
     * @return an instantiated Guard Object based on the supplied 'x,y' value.
     */
    public static Guard parse(String arg){
        Location location = Location.parse(arg);
        return new Guard(location);
    }
}