package W4.Homework_Tasks.Infiltration.pathFinding;

import W4.Homework_Tasks.Infiltration.common.Location;
import W4.Homework_Tasks.Infiltration.common.Map;

import java.util.*;

public class DepthFirstPathFinder  implements GridPathFinder {
    // Add necessary attributes
    private Map map;

    /**
     * This constructor creates a new DepthFirstPathFinder object
     *
     * @param map the map to instantiate the DepthFirstPathFinder algorithm with.
     */
    public DepthFirstPathFinder(Map map) {
        this.map = map;
    }

    /**
     * This method finds the path from the start location to the end location using the depth first search implementation.
     * This search algorithm uses a LIFO structure to store the frontiers it comes across in the tree.
     * @param startLocation the start location.
     * @param endLocation the end location.
     * @return a Path from the initial location to the end location.
     */
    @Override
    public Path findPath(Location startLocation, Location endLocation){
        // Implement the LIFO data structure
        Stack<Location> stack = new Stack<>();
        // Store the nodes that have been visited
        ArrayList<Location> visitedNodes = new ArrayList<>();
        HashMap<Location, Location> previous = new HashMap<>();
        // Testing whether the bounds are set correctly
        //System.out.printf("%d, %d, %d, %d\n", (Math.max(startLocation.getX(), endLocation.getX()) + 2), (Math.min(startLocation.getX(), endLocation.getX()) - 2),(Math.min(startLocation.getY(), endLocation.getY()) -2), (Math.max(startLocation.getY(), endLocation.getY()) + 2));
        // depthFirstSearch
        stack.push(startLocation);
        while (!stack.isEmpty()){
            Location current = stack.pop();
            if (current.equals(endLocation)){
                break;
            }
            if (!visitedNodes.contains(current)){
                visitedNodes.add(current);
                //System.out.printf("%d, %d\n", current.getX(), current.getY());
                // Ensures the depth first search algorithm doesn't continue to search outside the map
                if((current.getX() <= Math.max(startLocation.getX(), endLocation.getX()) + 2) &&
                        (current.getX() >= Math.min(startLocation.getX(), endLocation.getX()) - 2) &&
                        (current.getY() >= Math.min(startLocation.getY(), endLocation.getY()) -2) &&
                        (current.getY() <= Math.max(startLocation.getY(), endLocation.getY()) + 2)){
                    Iterable<Location> neighbors = getNeighbors(current);
                    for (Location neighbor : neighbors){
                        if(!visitedNodes.contains(neighbor)){
                            previous.put(neighbor, current);
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        // Generate a path from the end location
        List<Location> path = new Stack<>();
        Location current = endLocation;
        while (previous.containsKey(current)){
            path.add(current);
            current = previous.get(current);
        }
        path.add(startLocation);
        // Make sure the path goes from start to end
        Collections.reverse(path);
        return new Path(path);
    }

    /**
     * This method will retrieve all the neighbours from a given location
     *
     * @param location the location which needs to have its neighbours found
     * @return a list of neighbours from the given location
     */
    public List<Location> getNeighbors(Location location) {
        ArrayList<Location> neighbours = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();

        // The following will see if a neighbour exists in a given location
        if (!map.isLocationObstructed(x - 1, y)) {
            // Add the neighbour to the left
            neighbours.add(new Location(x - 1, y));
        }
        // If the obstacle is to the right of the given location
        if (!map.isLocationObstructed(x + 1, y)) {
            neighbours.add(new Location(x + 1, y));
        }
        // If the obstacle is above the given location
        if (!map.isLocationObstructed(x, y + 1)) {
            neighbours.add(new Location(x, y + 1));
        }
        // If the obstacle is below the given location
        if (!map.isLocationObstructed(x, y - 1)) {
            neighbours.add(new Location(x, y - 1));
        }
        // Return all the neighbours
        return neighbours;
    }
}