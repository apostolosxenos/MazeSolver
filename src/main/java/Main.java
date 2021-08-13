import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filePath;

        if (args.length == 0) {
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
        ms.solve();
    }
}
