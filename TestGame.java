import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
