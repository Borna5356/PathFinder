import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TestGame {
    
    @Test
    public void moveFalse() {
        // setup
        Maze maze = new Maze(4, 4);
        Game game = new Game(maze);
        game.startGame();
        boolean expected = false;

        // invoke
        boolean actual = game.move("left");

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void moveTrue() {
        // setup
        Maze maze = new Maze(4, 4);
        Game game = new Game(maze);
        maze.random.setSeed(1);
        game.startGame();
        boolean expected = true;

        // invoke
        boolean actual = game.move("up");
        System.out.println(maze);

        // analyze
        assertEquals(expected, actual);
    }

    @Test
    public void checkSquareIsVisted() {
        // setup
        Maze maze = new Maze(4, 4);
        Game game = new Game(maze);
        maze.random.setSeed(1);
        game.startGame();
        game.move("up");
        Square current_square = maze.getSquare(1, 0);
        Square new_square = maze.getSquare(0, 0);
        SquareType expected = SquareType.VISTED;
        SquareType expected_type = SquareType.CURRENT;
        
        //invoke
        game.move("up");
        System.out.println(maze);
        SquareType actual = current_square.getType();
        SquareType actual_type = new_square.getType();

        // analyze
        assertEquals(expected, actual);
        assertEquals(expected_type, actual_type);
    }

    @Test
    public void hasWonTrue() {
        // setup
        Maze maze = new Maze(2, 2);
        Game game = new Game(maze);
        maze.random.setSeed(1);
        game.startGame();
        System.out.println(maze);
        game.move("up");
        System.out.println(maze);
        game.move("right");
        System.out.println(maze);
        boolean expected = true;
        
        // invoke
        boolean actual = game.hasWon();

        // analzye
        assertEquals(expected, actual);
    }

    @Test
    public void hasLostTrue() {
        // setup
        Maze maze = new Maze(4, 4);
        Game game = new Game(maze);
        maze.random.setSeed(1);
        game.startGame();
        Square square = maze.getSquare(1, 1);
        square.setType(SquareType.EMPTY);
        System.out.println(maze);
        game.move("up");
        game.move("right");
        game.move("up");
        game.move("left");
        System.out.println(maze);
        boolean expected = true;
        
        // invoke
        boolean actual = game.hasLost();

        // analzye
        assertEquals(expected, actual);
    }    
}
