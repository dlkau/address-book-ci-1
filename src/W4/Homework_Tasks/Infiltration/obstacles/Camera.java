package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.*;

/**
 * This class defines the attributes and methods for a Camera obstacle
 */
public class Camera extends LocatableObstacle{
    private final Direction direction;

    /**
     * This constructor is used to instantiate a new Camera object with its given location and direction.
     * @param location the location of the camera.
     * @param direction the direction of the camera.
     */
    public Camera(Location location, Direction direction){
        super(location);
        this.direction = direction;
    }

    /**
     * This method returns a Boolean value denoting whether a given location is obstructed or not.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value denoting whether a given location is obstructed or not.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        // Cameras obstruct all locations in their cone of vision
        int xDiff = x - location.getX();
        int yDiff = y - location.getY();
        switch (direction){
            case NORTH:
                return Math.abs(xDiff) <= -yDiff;
            case EAST:
                return Math.abs(yDiff) <= xDiff;
            case SOUTH:
                return Math.abs(xDiff) <= -xDiff;
            case WEST:
                return Math.abs(yDiff) <= -xDiff;
            default:
                throw new IllegalStateException("Camera direction must be one of NORTH, EAST, SOUTH, WEST");
        }
    }

    /**
     * Returns the symbol encoding for the camera object.
     * @return the character encoding for the camera object.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.CAMERA.getSymbol();
    }

    /**
     * This method, given the appropriate arguments, will return a new Camera object.
     * @param arg the arguments for the Camera object.
     * @return the new Camera object.
     */
    public static Camera parse(String arg){
        String[] parts = arg.split(",");
        if(parts.length != 3){
            throw new IllegalStateException("Camera direction must be one of NORTH, EAST, SOUTH, WEST");
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Direction direction = Direction.parse(parts[2]);
        Location location = new Location(x,y);
        return new Camera(location, direction);
    }
}