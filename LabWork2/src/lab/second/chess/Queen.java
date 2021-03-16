package lab.second.chess;

public class Queen extends Piece {
    public Queen() {}

    public Queen(Position position, String form, Color color) {
        super(position, form, color);
    }

    @Override
    public boolean isLegalMove(Position from, Position to) {
        if(!super.isLegalMove(to)) {
            return false;
        }
        if((new Rook(from).isLegalMove(from, to)) || (new Bishop(from).isLegalMove(from, to))) {
            return true;
        }
        return false;
    }
}