package maze;

public class Maze {

    private final int rows;
    private final int columns;
    private final char[][] matrix;
    private boolean[][] explored;
    private MazeCoordinate startingPoint;
    private MazeCoordinate finishingPoint;


    public Maze(char[][] matrix) {

        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.explored = new boolean[rows][columns];
    }


    public MazeCoordinate getStartingPoint() {
        return startingPoint;
    }

    /**
     *  Loops inside 2D matrix and sets up starting and finishing point
     */
    public void initialize() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (Character.valueOf('S').compareTo(getCharacterFromMatrix(r, c)) == 0) {
                    startingPoint = new MazeCoordinate(r, c);
                    System.out.println(String.format("Starting point @ %s", startingPoint.toString()));
                } else if (Character.valueOf('G').compareTo(getCharacterFromMatrix(r, c)) == 0) {
                    finishingPoint = new MazeCoordinate(r, c);
                    System.out.println(String.format("Finishing point @ %s", finishingPoint.toString()));
                }
            }
        }

        System.out.println();
    }

    /**
     * Checks if coordinates are inside matrix or positive integers
     *
     * @param row
     * @param col
     * @return false if coordinates are out of matrix or negatives integers. Otherwise true.
     */
    public boolean isValidNode(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            return false;
        }
        return true;
    }

    public boolean isFinishingPoint(int row, int col) {
        return row == finishingPoint.getRow() && col == finishingPoint.getCol();
    }

    public boolean isWall(int row, int col) {
        if (Character.valueOf('X').compareTo(getCharacterFromMatrix(row, col)) == 0) {
            return true;
        }
        return false;
    }

    public boolean isExplored(int row, int col) {
        return explored[row][col];
    }

    public void setExplored(int row, int col) {
        explored[row][col] = true;
    }

    /**
     * Returns the character existing in the 2D matrix cell
     *
     * @param row
     * @param col
     * @return Character existing in the 2D matrix cell
     */
    private Character getCharacterFromMatrix(int row, int col) {
        return Character.valueOf(matrix[row][col]);
    }

    /**
     * Print the maze schema and information
     * about starting, finishing point and walls
     */
    public void printInputSchema() {

        System.out.println("Input Maze Schema:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}