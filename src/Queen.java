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
        if (isPathClear(chessBoard, line, column, toLine, toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null) {
                if (line != toLine || column != toColumn) {
                    if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                        return checkMassive;
                    } else if (column == toColumn) {
                        return checkMassive;
                    } else if (line == toLine) {
                        return checkMassive;
                    }
                }
            } else if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                if (line != toLine || column != toColumn) {
                    if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                        return checkMassive;
                    } else if (column == toColumn) {
                        return checkMassive;
                    } else if (line == toLine) {
                        return checkMassive;
                    }
                }
            }
        }
        return false;

    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    public boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepLine = Integer.compare(toLine, line);
        int stepColumn = Integer.compare(toColumn, column);
        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;

        while (currentLine != toLine || currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }
        return true;
    }

}
