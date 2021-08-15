package maze;

public class MazeCoordinate {

    private final int row;
    private final int col;

    public MazeCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }
}