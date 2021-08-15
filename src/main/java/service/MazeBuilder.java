package service;

import maze.Maze;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeBuilder {

    private String filePath;
    private List<String> mazeLines;

    public MazeBuilder(String filePath) {
        this.filePath = filePath;
        mazeLines = new ArrayList<>();
    }

    /**
     * Parses the file given and returns all existing lines that form the maze
     *
     * @return all lines included in the input file
     */
    private List<String> mazeLinesFromFile() {

        try {

            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Populates maze list and checks if maze is in correct form
     * by checking the vertical and horizontal size of maze
     *
     * @return true if maze is correctly formed, otherwise false
     */
    private boolean isMazeCorrectlyFormed() {

        mazeLines.addAll(mazeLinesFromFile());

        int mazeRows = mazeLines.size();
        if (mazeRows == 0)
            return false;

        int mazeColumns = mazeLines.get(0).length();
        if (mazeColumns == 0)
            return false;

        return true;
    }

    /**
     * Builds and returns a new domain.Maze object consisting of a 2D array of characters
     * Each character represents the state of the maze block
     *
     * @return a new domain.Maze object
     */
    public Maze build() {

        if (!isMazeCorrectlyFormed())
            throw new IllegalArgumentException();

        int mazeRows = mazeLines.size();
        int mazeColumns = mazeLines.get(0).length();

        char[][] matrix = new char[mazeRows][mazeColumns];

        int row = 0;
        for (String line : this.mazeLines) {

            int column = 0;

            for (Character character : line.toCharArray()) {
                matrix[row][column++] = character;
            }

            row++;
        }

        return new Maze(matrix);
    }
}