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

        if (!checkMassive) {
            return false;
        }


        if (chessBoard.board[toLine][toColumn] == null) {
            if (line != toLine) {
                if (color.equals("White")) {
                    if (line == 1 && toLine == line + 2) {
                        if (toColumn == column) {
                            beQueen(chessBoard, toLine, toColumn);
                            return true;
                        }
                    } else if (toLine == line + 1) {
                        if (toColumn == column) {
                            beQueen(chessBoard, toLine, toColumn);
                            return true;
                        }
                    }
                } else if (color.equals("Black")) {
                    if (line == 6 && toLine == line - 2) {
                        if (toColumn == column) {
                            beQueen(chessBoard, toLine, toColumn);
                            return true;
                        }
                    } else if (toLine == line - 1) {
                        if (toColumn == column) {
                            beQueen(chessBoard, toLine, toColumn);
                            return true;
                        }
                    }
                }
            }
        } else if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            if (line != toLine) {
                if (color.equals("White")) {
                    if (toLine == line + 1 && (toColumn == column + 1 || toColumn == column - 1)) {
                        beQueen(chessBoard, toLine, toColumn);
                        return true;
                    }
                } else if (color.equals("Black")) {
                    if (toLine == line - 1 && (toColumn == column + 1 || toColumn == column - 1)) {
                        beQueen(chessBoard, toLine, toColumn);
                        return true;
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

    public void beQueen(ChessBoard chessBoard, int line, int column) {
        if (color.equals("White")) {
            if (line == 7) {
                chessBoard.promotePawn(line, column, new Queen(color));
            }
        } else if (color.equals(("Black"))) {
            if (line == 0) {
                chessBoard.promotePawn(line, column, new Queen(color));
            }
        }
    }

}
