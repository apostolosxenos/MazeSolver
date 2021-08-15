package maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    private static final char[][] MATRIX = new char[][]{
            {'S', 'X', '_', '_'},
            {'_', '_', '_', '_'},
            {'X', '_', 'X', '_'},
            {'X', 'X', '_', '_'},
            {'X', 'G', '_', 'X'},
    };
    private static final int OUT_OF_BOUNDS_ROW = 5;
    private static final int OUT_OF_BOUNDS_COLUMN = 4;
    private Maze maze;
    Random random;

    @BeforeEach
    void setUp() {
        maze = new Maze(MATRIX);
        random = new Random();
    }

    @Test
    void shouldBeTrueWhenCoordsAreInsideMatrixBounds() {

        // GIVEN
        int[] insideCoords = random.ints(2,
                0,
                4).toArray();
        MazeCoordinate mazeCoordinate = new MazeCoordinate(insideCoords[0], insideCoords[1]);

        // WHEN
        boolean validLocation = maze.isValidNode(mazeCoordinate.getRow(), mazeCoordinate.getCol());

        // THEN
        assertTrue(validLocation);
    }

    @Test
    void shouldBeFalseWhenCoordsAreNegativeIntegers() {

        // GIVEN
        int[] negatives = random.ints(2, Integer.MIN_VALUE, -1).toArray();
        MazeCoordinate mazeCoordinate = new MazeCoordinate(negatives[0], negatives[1]);

        // WHEN
        boolean validLocation = maze.isValidNode(mazeCoordinate.getRow(), mazeCoordinate.getCol());

        // THEN
        assertFalse(validLocation);
    }

    @Test
    void shouldBeFalseWhenCoordsAreGreaterThanMatrixBounds() {

        // GIVEN
        MazeCoordinate mazeCoordinate = new MazeCoordinate(OUT_OF_BOUNDS_ROW, OUT_OF_BOUNDS_COLUMN);

        // WHEN
        boolean validLocation = maze.isValidNode(mazeCoordinate.getRow(),mazeCoordinate.getCol());

        // THEN
        assertFalse(validLocation);

    }
}