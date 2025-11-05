package service;

import model.Board;
import model.Move;
import model.Player;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private final Scanner scanner;
    Player currentPLayer;

    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.board = new Board(3);
        this.currentPLayer = p1;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        board.printBoard();

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid Move");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]) - 1; // converting to 0-indexed
                col = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Move");
                continue;
            }

            if (!board.isValidMove(row, col)) {
                System.out.println("Invalid Move");
                continue;
            }

            Move move = new Move(row, col);
            board.makeMove(currentPLayer, move);
            board.printBoard();

            if (board.checkWin(currentPLayer)) {
                System.out.println(currentPLayer.getName() + " won the game");
                return;
            }

            if (board.isFull()) {
                System.out.println("Game Over");
                return;
            }

            switchPlayer();
        }

        // Only reached if 'exit' is typed
        System.out.println("Game Over");
    }

    private void switchPlayer() {
        currentPLayer = (currentPLayer == player1) ? player2 : player1;
    }
}
