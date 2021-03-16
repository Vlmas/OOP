package lab.second.chess;

public class King extends Piece {
    private boolean moved;

    public King() {}

    public King(Position position, String form, Color color) {
        super(position, form, color);
        moved = false;
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }
        if((from.getX() == to.getX() && Math.abs(from.getY() - to.getY()) == 1) ||
                (from.getY() == to.getY() && Math.abs(from.getX() - to.getX()) == 1) ||
                (Math.abs(from.getX() - to.getX()) == Math.abs(from.getY() - to.getY())
                        && Math.abs(from.getY() - to.getY()) == 1)) {
            moved = true;
            return true;
        }
        return false;
    }

    public boolean isMoved() {
        return moved;
    }
}