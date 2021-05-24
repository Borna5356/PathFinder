public class Square {
    
    private SquareType type;

    public Square() {
        this.type = SquareType.WALL;
    }

    public boolean isVisited() {
        return type == SquareType.VISTED; 
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
                return "[ ]";
            case VISTED:
                return "[V]";
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
        System.out.println(square);
    }
}
