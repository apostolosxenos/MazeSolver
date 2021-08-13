import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MazeBFSSolver {

    private Maze maze;
    private List<MazeCoordinate> path;
    private static final Map<String, int[]> DIRECTIONS = Map.of(
            "NORTH", new int[]{-1, 0},
            "SOUTH", new int[]{1, 0},
            "EAST", new int[]{0, 1},
            "WEST", new int[]{0, -1});

    public MazeBFSSolver(Maze maze) {
        this.maze = maze;
        path = new ArrayList<>();
    }

    /**
     * Attempts to find an available path from starting to finishing point by exploring neighboring nodes*
     */
    public void solve() {

        if (!explore(maze.getStartingPoint().getRow(), maze.getStartingPoint().getCol())) {
            System.err.println("No path found.");
        }
        else {
            System.out.println("Available path: ");
            System.out.println(path.toString());
        }
    }

    /**
     * Determines the availability of next node and move to it until it reaches to the finishing point.
     * Each successful move is added to the path. It runs recursively until it either reaches to the finishing point or to a deadlock.
     *
     * @param row   Row
     * @param col   Column
     * @return      true if it reaches the finishing point or false if there is no available node to move.
     */
    private boolean explore(int row, int col) {

        if (!maze.isValidNode(row, col) || maze.isWall(row, col) || maze.isExplored(row, col)) {
            return false;
        }

        path.add(new MazeCoordinate(row, col));
        maze.setExplored(row, col);

        if (maze.isFinishingPoint(row, col)) {
            return true;
        }

        for (String direction : DIRECTIONS.keySet()) {

            MazeCoordinate nextCoordinate = getNextCoordinate(row, col, direction);
            if (explore(nextCoordinate.getRow(), nextCoordinate.getCol())) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    /**
     * @param row   Row
     * @param col   Column
     * @param direction An available direction (NORTH, SOUTH, EAST, WEST)
     * @return  The coordinate to move which is always 1 node away
     */
    private MazeCoordinate getNextCoordinate(int row, int col, String direction) {
        int[] directionCoordinates = DIRECTIONS.get(direction);
        return new MazeCoordinate(row + directionCoordinates[0], col + directionCoordinates[1]);
    }

}
