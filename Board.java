import java.util.Random;

public class Board {
    
    private int rows;
    private int cols;
    private Square[][] board;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Square[rows][cols];
        for (int row = 0; row < rows; row += 1) {
            for (int col = 0; col < cols; col += 1) {
                this.board[row][col] = new Square();
            }
        }
    }

    public void randomise() {
        Random random = new Random();
        int row = random.nextInt(rows);
        int col = random.nextInt(cols);
        Square square = board[row][col];
        square.setType(SquareType.START);
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
        Board board = new Board(5, 5);
        System.out.println(board);
        board.randomise();
        System.out.println(board);
    }
    
}
