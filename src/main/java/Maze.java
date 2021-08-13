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

    public void initialize() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (Character.valueOf('S').compareTo(getCharacter(r, c)) == 0) {
                    startingPoint = new MazeCoordinate(r, c);
                    System.out.println(String.format("Starting point @ %s", startingPoint.toString()));
                } else if (Character.valueOf('G').compareTo(getCharacter(r, c)) == 0) {
                    finishingPoint = new MazeCoordinate(r, c);
                    System.out.println(String.format("Finishing point @ %s", finishingPoint.toString()));
                }
            }
        }

        System.out.println();
    }

    public MazeCoordinate getStartingPoint() {
        return startingPoint;
    }

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
        if (Character.valueOf('X').compareTo(getCharacter(row, col)) == 0) {
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
    private Character getCharacter(int row, int col) {
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