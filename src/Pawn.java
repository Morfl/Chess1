public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean checkMassive = line >= 0 && line <= 7 && column >= 0 && column <= 7 && toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7;
        if (line != toLine) {
            if (color.equals("White")) {
                if (line == 1 && toLine == line + 2) {
                    if (toColumn == column) {
                        return checkMassive;
                    }
                } else if (toLine == line + 1) {
                    if (toColumn == column) {
                        return checkMassive;
                    }
                }
            } else if (color.equals("Black")) {
                if (line == 6 && toLine == line - 2) {
                    if (toColumn == column) {
                        return checkMassive;
                    }
                } else if (toLine == line - 1) {
                    if (toColumn == column) {
                        return checkMassive;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}
