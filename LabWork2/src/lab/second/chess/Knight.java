package lab.second.chess;

public class Knight extends Piece {
    public Knight() {}

    public Knight(Position position, String form, Color color) {
        super(position, form, color);
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }
        if((Math.abs(from.getX() - to.getX()) == 2 && Math.abs(from.getY() - to.getY()) == 1)
            || (Math.abs(from.getX() - to.getX()) == 1 && Math.abs(from.getY() - to.getY()) == 2)) {
            return true;
        }
        return false;
    }
}