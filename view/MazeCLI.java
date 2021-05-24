package view;

import java.util.Scanner;

import model.Game;
import model.Maze;

public class MazeCLI {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the maze(EX: 2 3): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        Maze maze = new Maze(rows, cols);
        Game game = new Game(maze);
        game.startGame();
        System.out.println(maze);
        while (!game.hasLost() && !game.hasWon()) {
            System.out.print("Enter a direction to move: ");
            String command = scanner.nextLine();
            if (game.canMove(command) != null) {
                game.move(command);
                System.out.println(maze);
            }
            else {
                System.out.println("Invalid move");
                System.out.println(maze);
            }
        }
        if (game.hasWon()) {
            System.out.println("The maze was completed");
        }
        else {
            System.out.println("You hit a deadend");
        }

        scanner.close();
    }
}
