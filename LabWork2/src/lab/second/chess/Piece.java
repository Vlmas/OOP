package lab.second.chess;

import java.io.Serializable;
import java.util.Objects;

public abstract class Piece implements Serializable {
    private Position position;
    private String form;
    private Color color;

    public Piece() {}

    public Piece(Position position) {
        this.position = position;
    }

    public Piece(Position position, Color color) {
        this(position);
        this.color = color;
    }

    public Piece(Position position, String form, Color color) {
        this(position, color);
        this.form = form;
    }

    public abstract boolean isLegalMove(Position from, Position to);

    public boolean isLegalMove(Position to) {
        return !this.position.equals(to);
    }

    public Position getPosition() {
        return position;
    }

    public String getForm() {
        return form;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Piece piece = (Piece) obj;
        return (color == piece.color && position.equals(piece.position) && form.equals(piece.form));
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, form, color);
    }
}