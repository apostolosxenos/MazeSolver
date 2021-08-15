import algorithm.MazeBFSSolver;
import maze.Maze;
import maze.MazeCoordinate;
import service.MazeBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filePath;

        if (Files.exists(Paths.get("maze.txt"))) {
            filePath = "maze.txt";
        }
        else if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("You must specify the full filepath: ");
            filePath = scanner.nextLine();
        } else
            filePath = args[0];


        if (filePath.isBlank() || !Paths.get(filePath).toFile().exists()) {
            throw new IllegalArgumentException("File does not exist.");
        }

        MazeBuilder mb = new MazeBuilder(filePath);
        Maze maze = mb.build();
        maze.printInputSchema();
        maze.initialize();

        MazeBFSSolver ms = new MazeBFSSolver(maze);
        List<MazeCoordinate> path = ms.solve();

        if (path.isEmpty())
            System.out.println("There is no available path.");
        else {
            System.out.println("Available path:");
            System.out.println(path.toString());
        }

    }
}
