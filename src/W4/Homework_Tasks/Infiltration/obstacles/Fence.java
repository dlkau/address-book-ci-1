package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.Location;

/**
 * This class declaration will represent a fence from a given starting point to the
 * end location.
 */
public class Fence extends LocatableObstacle{
    private final Location end;

    /**
     * This constructor instantiates a new fence object using the start and end positions.
     * @param start the start position of the fence.
     * @param end the end position of the fence.
     */
    public Fence(Location start, Location end){
        super(start);
        this.end = end;
        if (!isAxial()){
            throw new IllegalArgumentException("Fence must be vertical or horizontal");
        }
    }

    /**
     * This returns a Boolean value denoting whether a fence is vertical or horizontal.
     * @return a Boolean value denoting whether a fence is vertical or horizontal.
     */
    private boolean isAxial(){
        return location.getX() == end.getX() || location.getY() == end.getY();
    }

    /**
     * Returns a Boolean value denoting whether a given location is obstructed or not.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value denoting whether a location is obstructed or not.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        int xDiffEnd = x - end.getX();
        int yDiffEnd = y - end.getY();
        int xDiffStart = x - location.getX();
        int yDiffStart = y - location.getY();
        // Taking advantage of 1-dimensional vector math:
        // Given two ends A and B, and a point P, if (P - A) * (P - B) <= 0
        // then P is between A and B
        // since AP and BP are pointing in opposite directions
        return xDiffEnd * xDiffStart <= 0 && yDiffEnd * yDiffStart <= 0;
    }

    /**
     * Returns the symbol encoding for the Fence obstacle.
     * @return the character encoding for the Fence obstacle.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.FENCE.getSymbol();
    }

    /**
     * This static method, given an argument, will instantiate and return a new Fence object.
     * @param arg the details associated with the Fence object.
     * @return a new Fence object.
     */
    public static Fence parse(String arg){
        String[] parts = arg.split(",");
        if (parts.length != 4){
            throw new IllegalArgumentException("Fence must have 4 coordinates: startX, startY, endX, endY");
        }
        int startX = Integer.parseInt(parts[0]);
        int startY = Integer.parseInt(parts[1]);
        int endX = Integer.parseInt(parts[2]);
        int endY = Integer.parseInt(parts[3]);
        Location start = new Location(startX, startY);
        Location end = new Location(endX, endY);
        return new Fence(start, end);
    }
}