package lab.second.chess;

public class Rook extends Piece {
    private boolean moved;

    public Rook() {}

    public Rook(Position position) {
        super(position);
    }

    public Rook(Position position, String form, Color color) {
        super(position, form, color);
        moved = false;
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }
        if((from.getX() == to.getX()) || (from.getY() == to.getY())) {
            return true;
        }
        return false;
    }

    public boolean isMoved() {
        return moved;
    }
}