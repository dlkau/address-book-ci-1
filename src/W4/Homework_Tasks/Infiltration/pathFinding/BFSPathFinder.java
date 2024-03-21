package W4.Homework_Tasks.Infiltration.pathFinding;

import W4.Homework_Tasks.Infiltration.common.Location;
import W4.Homework_Tasks.Infiltration.common.Map;

import java.util.*;

public class BFSPathFinder implements GridPathFinder {
    private Map map;

    /**
     * This constructor instantiates a new BFSPathFinder object.
     * @param map the map to instantiate the BFSPathFinder algorithm with.
     */
    public BFSPathFinder(Map map){
        this.map = map;
    }

    /**
     * This method finds the path from the start location to the end location.
     * @param startLocation the start location.
     * @param endLocation the end location.
     * @return a Path from the initial location to the end location.
     */
    @Override
    public Path findPath(Location startLocation, Location endLocation){
        Queue<Location> queue = new LinkedList<>();
        ArrayList<Location> visited = new ArrayList<>();
        HashMap<Location, Location> previous = new HashMap<>();

        // Breadth-first search
        queue.add(startLocation);
        while (!queue.isEmpty()){
            Location current = queue.remove();
            if (current.equals(endLocation)){
                break;
            }
            if (!visited.contains(current)){
                visited.add(current);
                Iterable<Location> neighbors = getNeighbors(current);
                for (Location neighbor : neighbors){
                    if(!visited.contains(neighbor)){
                        previous.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Backtrack from the end location to find the path
        List<Location> path = new Stack<>();
        Location current = endLocation;
        while (previous.containsKey(current)){
            path.add(current);
            current = previous.get(current);
        }
        path.add(startLocation);
        // Reverse the path so that it goes from the start location to the end location
        Collections.reverse(path);
        return new Path(path);
    }

    /**
     * This method retrieves the neighbors from a given location.
     * @param location the location which the neighbours need to sought from.
     * @return the neighbors of a given location.
     */
    @Override
    public Iterable<Location> getNeighbors(Location location){
        ArrayList<Location> neighbors = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        // Neighbours are locations which are to the left, right, up and down of the current location
        // and are not obstructed by an obstacle.
        if (!map.isLocationObstructed(x - 1, y)){
            neighbors.add(new Location(x - 1, y));
        }
        if (!map.isLocationObstructed(x + 1, y)){
            neighbors.add(new Location(x + 1, y));
        }
        if (!map.isLocationObstructed(x, y - 1)){
            neighbors.add(new Location(x, y - 1));
        }
        if (!map.isLocationObstructed(x, y + 1)) {
            neighbors.add(new Location(x, y + 1));
        }
        return neighbors;
    }
}