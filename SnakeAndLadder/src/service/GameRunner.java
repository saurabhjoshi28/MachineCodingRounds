package service;

import model.Board;
import model.Dice;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {
    private Board board;
    private Dice dice;
    private List<Player> players;

    public void initializeGame(){
        Scanner sc = new Scanner(System.in);
        board = new Board(100);
        System.out.print("Enter number of snakes: ");
        int snakeCount = sc.nextInt();
        for (int i = 0; i < snakeCount; i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            board.setSnake(head, tail);
        }

        System.out.print("Enter number of ladders: ");
        int ladderCount = sc.nextInt();
        for (int i = 0; i < ladderCount; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            board.setLadder(start, end);
        }

        System.out.print("Enter number of players: ");
        int playerCount = sc.nextInt();
        players = new ArrayList<>();

        for (int i = 0; i < playerCount; i++){
            String name = sc.next();
            players.add(new Player(name));
        }

        dice = new Dice();

    }

    public void startGame(){
        PlaySnakeAndLadder game = new PlaySnakeAndLadder(players, dice, board);
        game.startGame();
    }
}
