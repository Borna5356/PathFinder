import java.util.Random;

public class Maze {
    Random random = new Random();

    private int rows;
    private int cols;
    private Square[][] board;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Square[rows][cols];
        for (int row = 0; row < rows; row += 1) {
            for (int col = 0; col < cols; col += 1) {
                this.board[row][col] = new Square();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Square getSquare(int row, int col) {
        return board[row][col];
    }

    public int[] randomise() {
        int startRow = random.nextInt(rows);
        int startCol = 0;
        Square start = board[startRow][startCol];
        start.setType(SquareType.START);
        int endRow = random.nextInt(rows);
        int endCol = cols - 1;
        Square finish = board[endRow][endCol];
        finish.setType(SquareType.END);
        //create a path from the start position to the end position
        if (startRow < endRow) {
            for (int currentRow = startRow + 1; currentRow < endRow; currentRow += 1) {
                Square square = board[currentRow][startCol];
                square.setType(SquareType.EMPTY);
            }
        }
        else if (startRow > endRow) {
            for (int currentRow = startRow - 1; currentRow > endRow; currentRow -= 1) {
                Square square = board[currentRow][startCol];
                square.setType(SquareType.EMPTY);
            }
        }

        if (startCol < endCol) {
            for (int currentCol = startCol; currentCol < endCol; currentCol += 1) {
                Square square = board[endRow][currentCol];
                if (square.getType() == SquareType.START) {
                    continue;
                }
                square.setType(SquareType.EMPTY);
            }
        }
        else if (startCol > endCol) {
            for (int currentCol = startCol; currentCol > endCol; currentCol -= 1) {
                Square square = board[endRow][currentCol];
                if (square.getType() == SquareType.START) {
                    continue;
                }
                square.setType(SquareType.EMPTY);
            }
        }
        int[] startSquare = {startRow, startCol};
        return startSquare;
    }

    @Override
    public String toString() {
        String string = "  ";
        for (int colNum = 0; colNum < cols; colNum += 1) {
            string += " " + colNum + " ";
        }
        string += "\n";
        for (int row = 0; row < rows; row += 1) {
            string += row + " ";
            for (int col = 0; col < cols; col += 1) {
                Square square = board[row][col];
                string += square + "";
            }
            string += "\n";
        }

        return string;
    }

    public static void main(String[] args) {
        Maze board = new Maze(10, 10);
        System.out.println(board);
        board.randomise();
        System.out.println(board);
    }
    
}
