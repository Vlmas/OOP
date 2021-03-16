package lab.second.chess;

public class Bishop extends Piece {
    public Bishop() {}

    public Bishop(Position position) {
        super(position);
    }

    public Bishop(Position position, String form, Color color) {
        super(position, form, color);
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }
        if(Math.abs(to.getX() - from.getX()) == Math.abs(to.getY() - from.getY())) {
            return true;
        }
        return false;
    }
}