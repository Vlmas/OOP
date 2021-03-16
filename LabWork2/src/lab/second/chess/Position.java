package lab.second.chess;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private String boardPosition;
    private int x;
    private int y;

    public Position() {}

    public Position(String boardPosition) {
        this.boardPosition = boardPosition;
        this.x = 7 - (Character.getNumericValue(boardPosition.charAt(1)) - 1);
        this.y = (boardPosition.charAt(0) - 97);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getBoardPosition() {
        return this.boardPosition;
    }

    public String toString() {
        return getX() + " " + getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Position position = (Position) obj;
        return (x == position.x && y == position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}