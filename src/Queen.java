public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean checkMassive = line >= 0 && line <= 7 && column >= 0 && column <= 7 && toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7;

        if (line != toLine || column != toColumn) {
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                return checkMassive;
            } else if (column == toColumn) {
                return checkMassive;
            } else if (line == toLine) {
                return checkMassive;
            }

        }

        return false;

    }

    @Override
    public String getSymbol() {
        return "Q";
    }

}
