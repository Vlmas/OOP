package lab.second.chess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Board implements Externalizable {
    private Piece[][] pieces;

    public Board() {
        String poses = "abcdefgh";

        pieces = new Piece[8][8];

        for(int i = 0; i < 8; i++) {
            pieces[1][i] = new Pawn(new Position(poses.charAt(i) + "7"), "\u2659", Color.BLACK);
            pieces[6][i] = new Pawn(new Position(poses.charAt(i) + "2"), "\u265f", Color.WHITE);
        }

        pieces[7][4] = new King(new Position("e1"), "\u265a", Color.WHITE);
        pieces[0][4] = new King(new Position("e8"), "\u2654", Color.BLACK);

        pieces[7][3] = new Queen(new Position("d1"), "\u265b", Color.WHITE);
        pieces[0][3] = new Queen(new Position("d8"), "\u2655", Color.BLACK);

        pieces[7][0] = new Rook(new Position("a1"), "\u265c", Color.WHITE);
        pieces[7][7] = new Rook(new Position("h1"), "\u265c", Color.WHITE);
        pieces[0][0] = new Rook(new Position("a8"), "\u2656", Color.BLACK);
        pieces[0][7] = new Rook(new Position("h8"), "\u2656", Color.BLACK);

        pieces[7][1] = new Knight(new Position("b1"), "\u265e", Color.WHITE);
        pieces[7][6] = new Knight(new Position("g1"), "\u265e", Color.WHITE);
        pieces[0][1] = new Knight(new Position("b8"), "\u2658", Color.BLACK);
        pieces[0][6] = new Knight(new Position("g8"), "\u2658", Color.BLACK);

        pieces[7][2] = new Bishop(new Position("c1"), "\u265d", Color.WHITE);
        pieces[7][5] = new Bishop(new Position("f1"), "\u265d", Color.WHITE);
        pieces[0][2] = new Bishop(new Position("c8"), "\u2657", Color.BLACK);
        pieces[0][5] = new Bishop(new Position("f8"), "\u2657", Color.BLACK);
    }

    public void draw() {
        for(int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for(int j = 0; j < 8; j++) {
                if(pieces[i][j] != null) {
                    System.out.print(pieces[i][j].getForm() + " ");
                } else {
                    System.out.print("\u25b1 ");
                }
            }
            System.out.println();
        }
        System.out.println("  A \u2009\u2009B \u2009\u2009C \u2009\u2009D \u2009\u2009E \u2009\u2009F \u2009G \u2009\u2009H");
    }

    public Piece getPieceAt(Position from) {
        return pieces[from.getX()][from.getY()];
    }

    public void setPiecePositionAt(Position from, Position to) {
        pieces[to.getX()][to.getY()] = getPieceAt(from);
        pieces[to.getX()][to.getY()].setPosition(to);
        pieces[from.getX()][from.getY()] = null;
    }

    public void castle(Color movingPlayer, boolean kingSide) {
        int difference = (movingPlayer == Color.WHITE) ? 7 : 0;

        if(kingSide) {
            this.setPiecePositionAt(new Position("e" + (8 - difference)), new Position("g" + (8 - difference)));
            this.setPiecePositionAt(new Position("h" + (8 - difference)), new Position("f" + (8 - difference)));
        } else {
            this.setPiecePositionAt(new Position("e" + (8 - difference)), new Position("c" + (8 - difference)));
            this.setPiecePositionAt(new Position("a" + (8 - difference)), new Position("d" + (8 - difference)));
        }
    }

    public String toString() {
        String result="";

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(pieces[i][j] != null) {
                    result += "1 ";
                } else {
                    result += "0 ";
                }
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(pieces);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        pieces = (Piece[][]) in.readObject();
    }
}