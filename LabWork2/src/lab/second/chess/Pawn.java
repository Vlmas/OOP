package lab.second.chess;

public class Pawn extends Piece {
    private boolean moved;
    private Board board;

    public Pawn() {}

    public Pawn(Position position, String form, Color color) {
        super(position, form, color);
        this.moved = false;
        this.board = null;
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }

        int differenceLong = (this.getColor() == Color.WHITE) ? -2 : 2;
        int differenceShort = (this.getColor() == Color.WHITE) ? -1 : 1;

        if(!moved && (from.getX() + differenceLong == to.getX() || from.getX() + differenceShort == to.getX())
                && from.getY() == to.getY() && board.getPieceAt(to) == null) {
            moved = true;
            return true;
        }
        else if(from.getX() + differenceShort == to.getX() && (Math.abs(from.getY() - to.getY()) == 1)) {
            return (board.getPieceAt(to) != null && board.getPieceAt(to).getColor() != this.getColor());
        }
        else if(from.getX() + differenceShort == to.getX() && from.getY() == to.getY() && board.getPieceAt(to) == null) {
            return true;
        }
        return false;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}