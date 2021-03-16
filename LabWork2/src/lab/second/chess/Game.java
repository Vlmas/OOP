package lab.second.chess;

import java.io.*;
import java.util.Scanner;

public class Game {
    private final Scanner input;
    private Board board;
    private Color movingPlayer;
    private boolean castleType;

    public Game() {
        this.board = new Board();
        this.movingPlayer = Color.WHITE;
        this.input = new Scanner(System.in);
    }

    public void start() throws InterruptedException {
        String guide;
        Position from;
        Position to;

        greet();

        loop:
        while(true) {
            Thread.sleep(1500);
            drawTopSeparator();
            board.draw();
            drawBottomSeparator();
            showMovingPlayer();

            System.out.println("Enter starting position..");
            guide = input.nextLine();

            switch(guide) {
                case "q", "Q" -> {
                    System.out.println("Thank you for the game!");
                    break loop;
                }
                case "save", "Save" -> {
                    System.out.println("Saving current progress..");
                    saveBoard();
                    Thread.sleep(500);
                    System.out.println("Progress saved!");
                    Thread.sleep(1000);
                    continue loop;
                }
                case "load", "Load" -> {
                    System.out.println("Loading last progress..");
                    loadBoard();
                    Thread.sleep(500);
                    System.out.println("Progress loaded!");
                    Thread.sleep(1000);
                    continue loop;
                }
            }

            from = new Position(guide);

            if (ownPiece(from)) {
                System.out.println("Enter destination position..");

                guide = input.nextLine();
                to = new Position(guide);

                movePiece(from, to);
            } else {
                System.out.println("Choose your own piece!");
            }
            swapMovingPlayer();
        }
    }

    public boolean ownPiece(Position position) {
        try {
            return board.getPieceAt(position).getColor() == movingPlayer;
        } catch(NullPointerException exc) {
            System.out.println("There is no piece at that position!");
            return false;
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Out of board!");
            return false;
        }
    }

    public boolean destinationNotBusy(Position position) {
        Piece piece = board.getPieceAt(position);

        if(piece != null) {
            return !ownPiece(piece.getPosition());
        }
        return true;
    }

    public void movePiece(Position from, Position to) {
        try {
            if(board.getPieceAt(from) instanceof Pawn) {
                ((Pawn) board.getPieceAt(from)).setBoard(board);
            }
            if(checkForCastle(from, to)) {
                board.castle(movingPlayer, castleType);
                System.out.println("Good Move!");
            }
            else if(destinationNotBusy(to)) {
                if(board.getPieceAt(from).isLegalMove(from, to)) {
                    board.setPiecePositionAt(from, to);
                    System.out.println("Good move!");
                } else {
                    System.out.println("Illegal move!");
                }
            } else {
                System.out.println("Not Allowed! Field is busy by your own piece!");
            }
        } catch (NullPointerException exc) {
            System.out.println("Not Allowed! There is no piece at that position!");
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Out of board!");
        }
    }

    public void drawTopSeparator() {
        System.out.println("----------------------\n");
    }

    public void drawBottomSeparator() {
        System.out.println("\n----------------------");
    }

    public void greet() {
        System.out.println("Welcome to Chess!");
    }

    public void showMovingPlayer() {
        String moving = (movingPlayer == Color.WHITE) ? "White" : "Black";
        System.out.println(moving + "'s move!");
    }

    public void swapMovingPlayer() {
        movingPlayer = (movingPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    public boolean checkForCastle(Position from, Position to) {
        if(board.getPieceAt(from) instanceof King && !((King) board.getPieceAt(from)).isMoved()) {
            int difference = (movingPlayer == Color.WHITE) ? 7 : 0;

            if(from.getBoardPosition().equals("e" + (8 - difference))
                && to.getBoardPosition().equals("g" + (8 - difference)) &&
                board.getPieceAt(new Position("h" + (8 - difference))) instanceof Rook &&
                !((Rook) board.getPieceAt(new Position("h" + (8 - difference)))).isMoved()) {

                castleType = true;
                return (
                    board.getPieceAt(new Position("f" + (8 - difference))) == null &&
                    board.getPieceAt(new Position("g" + (8 - difference))) == null
                );
            }
            else if(from.getBoardPosition().equals("e" + (8 - difference)) &&
                to.getBoardPosition().equals("c" + (8 - difference)) &&
                board.getPieceAt(new Position("a" + (8 - difference))) instanceof Rook &&
                !((Rook) board.getPieceAt(new Position("a" + (8 - difference)))).isMoved()) {

                castleType = false;
                return (
                    board.getPieceAt(new Position("d" + (8 - difference))) == null &&
                    board.getPieceAt(new Position("c" + (8 - difference))) == null &&
                    board.getPieceAt(new Position("b" + (8 - difference))) == null
                );
            }
        }
        return false;
    }

    public String toString() {
        return board.toString();
    }

    public void saveBoard() {
        try {
            FileOutputStream fileStream = new FileOutputStream("game_data.txt");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(board);
        } catch(Exception exc) {
            System.out.println("Failed to save data!");
        }
    }

    public void loadBoard() {
        try {
            FileInputStream fileStream = new FileInputStream("game_data.txt");
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            board = (Board) objectStream.readObject();
        } catch(Exception exc) {
            System.out.println("Failed to load data!");
        }
    }
}