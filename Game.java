public class Game {
    
    private Maze maze;
    private Gamestate gamestate;
    private int[] currentSquare;
    private int row;
    private int col;

    public Game(Maze maze) {
        this.maze = maze;
        this.gamestate = null;
        this.currentSquare = null;
        this.row = 0;
        this.col = 0;
    }

    public void startGame() {
        currentSquare = maze.randomise();
        row = currentSquare[0];
        col = currentSquare[1];
        gamestate = Gamestate.INPROGRESS;

    }

    public boolean move(String command) {
        int new_row = 0;
        int new_col = 0;
        switch (command) {
            case "up":
                new_row = row - 1;
                new_col = col;
                break;

            case "down":
                new_row = row + 1;
                new_col = col;
                break;

            case "right":
                new_row = row;
                new_col = col + 1;
                break;

            case "left":
                new_row = row;
                new_col = col - 1;
                break;

            default:
                return false;
        }

        if ((0 > new_row  || new_row >= maze.getRows()) ||
            0 > new_col || new_col >= maze.getCols()) {
                return false;
        }
        Square new_square = maze.getSquare(new_row, new_col);
        if (new_square.getType() == SquareType.WALL || new_square.getType() == SquareType.VISTED) {
            return false;
        }
        else {
            Square current_square = maze.getSquare(row, col);
            if (current_square.getType() != SquareType.START) {
                current_square.setType(SquareType.VISTED);
                row = new_row;
                col = new_col;
            }
            return true;
        }
    }
}
