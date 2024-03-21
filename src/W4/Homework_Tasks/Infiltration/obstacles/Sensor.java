package W4.Homework_Tasks.Infiltration.obstacles;

import W4.Homework_Tasks.Infiltration.common.Location;

/**
 * This obstacle detects whether there are intruders in a given radius within a circular area.
 */
public class Sensor extends LocatableObstacle {
    private final double range;

    /**
     * This constructor instantiates a new Sensor object.
     * @param location the location of the Sensor.
     * @param range the range of the sensor.
     */
    public Sensor(Location location, double range){
        super(location);
        this.range = range;
    }

    /**
     * This method, given a location, determines whether it is obstructed by the sensor's location or not.
     * @param x The x coordinate of the location.
     * @param y The y coordinate of the location.
     * @return a Boolean value representing whether the location is obstructed or not.
     */
    @Override
    public boolean isLocationObstructed(int x, int y){
        double distance = Math.sqrt(Math.pow(location.getX() - x, 2) + Math.pow(location.getY() - y, 2));
        return distance <= range;
    }

    /**
     * This method returns a character representing the Sensor object.
     * @return a character representing the Sensor object.
     */
    @Override
    public char getSymbol(){
        return ObstacleType.SENSOR.getSymbol();
    }

    /**
     * This method, when given Sensor implementation details, will return a new Sensor object.
     * @param arg the implementation details for the Sensor object.
     * @return a Sensor object.
     */
    public static Sensor parse(String arg){
        String[] parts = arg.split(",");
        if (parts.length != 3){
            throw new IllegalArgumentException("Sensor must have 3 inputs (x, y, range)");
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        double range = Double.parseDouble(parts[2]);
        Location location = new Location(x, y);
        return new Sensor(location, range);
    }
}