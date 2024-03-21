package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.Direction;
import W4.Homework_Tasks.Infiltration.common.Location;

public class Laser extends LocatableObstacle {
    // This will be used to describe the location the laser is facing.
    Direction direction;

    /**
     * This method is used to instantiate a new Laser object.
     * @param location this is the location where the laser will be placed.
     * @param direction the direction the laser is facing.
     */
    public Laser(Location location, Direction direction){
        super(location);
        this.direction = direction;
    }

    /**
     * This method is sued to determine whether a particular location results in the agent being in line with the laser.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value denoting whether the agent is in a place which is being obstructed by the laser.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        switch (this.direction){
            case NORTH:
                return (x == this.location.getX() && y >= this.location.getY());
            case EAST:
                return (y == this.location.getY() && x >= this.location.getX());
            case SOUTH:
                return (x == this.location.getX() && y <= this.location.getY());
            case WEST:
                return (y == this.location.getY() && x <= this.location.getX());
            default:
                throw new IllegalArgumentException("An unexpected argument was provided. It must either be NORTH," +
                        "EAST, SOUTH or WEST");
        }
    }

    /**
     * This method returns the symbol associated with the laser obstacle.
     * @return the character associated with the laser obstacle.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.LASER.getSymbol();
    }

    /**
     * This method returns a laser object with the appropriate characteristics based on the provided string argument.
     * @param argument the string argument characterising the Laser.
     * @return the Laser object with the specified characteristics.
     */
    public static Laser parse(String argument){
        // Split the string argument
        String[] splitArgs = argument.split(",");
        if(splitArgs.length != 3){
            throw new IllegalArgumentException("The incorrect number of arguments were supplied");
        }
        int x, y;
        x = Integer.parseInt(splitArgs[0]);
        y = Integer.parseInt(splitArgs[1]);
        Direction dir = Direction.parse(splitArgs[2]);
        Location loc = new Location(x, y);
        return new Laser(loc, dir);
    }
}