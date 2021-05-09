public class Square {
    
    private boolean visited;
    private SquareType type;

    public Square() {
        this.visited = false;
        this.type = SquareType.WALL;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        this.visited = true;
    }

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }

    @Override 
    public String toString() {
        switch (type) {
            case EMPTY:
                if (visited) {
                    return "[V]";
                }
                return "[ ]";
            case END:
                return "[E]";
            case START:
                return "[S]";
            case WALL:
                return "[W]";
            case CURRENT:
                return "[C]";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square.setType(SquareType.EMPTY);
        System.out.println(square);
        square.visit();
        System.out.println(square);
    }
}
