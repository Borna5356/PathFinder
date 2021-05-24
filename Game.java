public class Game {
    
    private Maze maze;
    private int[] current_pos;

    public Game(Maze maze) {
        this.maze = maze;
        this.current_pos = null;
    }

    public void startGame() {
        current_pos = maze.randomise();
    }

    public int[] canMove(String command) {
        int row = current_pos[0];
        int col = current_pos[1];
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
                return null;
        }

        if ((0 > new_row  || new_row >= maze.getRows()) ||
            0 > new_col || new_col >= maze.getCols()) {
                return null;
        }
        Square new_square = maze.getSquare(new_row, new_col);
        if (new_square.getType() == SquareType.WALL || new_square.isVisited() || 
            new_square.getType() == SquareType.START) {
            return null;
        }
        else {
            int[] new_pos = {new_row, new_col};
            return new_pos;
        }
    }

    public boolean move(String command) {
        int[] new_pos = canMove(command);
        if (new_pos == null) {
            return false;
        }

        int row = current_pos[0];
        int col = current_pos[1];
        int new_row = new_pos[0];
        int new_col = new_pos[1];
        Square new_square = maze.getSquare(new_row, new_col);
        Square current_square = maze.getSquare(row, col);
        
        row = new_row;
        col = new_col;
        current_pos = new_pos;
        if (current_square.getType() != SquareType.START) {
            current_square.setType(SquareType.VISTED);
        }
        if (new_square.getType() != SquareType.END) {
            new_square.setType(SquareType.CURRENT);
        }
        return true;
    }

    public boolean hasWon() {
        int row = current_pos[0];
        int col = current_pos[1];
        Square current_square = maze.getSquare(row, col);
        if (current_square.getType() == SquareType.END) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasLost() {
        String[] commands = {"up", "down", "left", "right"};
        for (String command : commands) {
            if (canMove(command) != null) {
                return false;
            }
        }
        return true;
    }
}
