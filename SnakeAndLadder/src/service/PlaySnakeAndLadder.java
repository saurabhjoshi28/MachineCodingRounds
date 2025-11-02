package service;

import model.Board;
import model.Dice;
import model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlaySnakeAndLadder {
    private Board board;
    private Dice dice;
    private Queue<Player> players;

    public PlaySnakeAndLadder(List<Player> playerList, Dice dice, Board board) {
        this.players = new LinkedList<>(playerList);
        this.dice = dice;
        this.board = board;
    }

    public void startGame(){
        boolean winnerFound = false;

        while (!winnerFound){
            Player currentPlayer = players.poll();
            int currentPosition = currentPlayer.getPosition();
            int diceValue = dice.roll();
            int nextPosition = currentPosition + diceValue;
            if (nextPosition > board.getSize()){
                nextPosition = currentPosition;
            }else {
                nextPosition = board.getNewPosition(currentPosition, diceValue);
            }

            System.out.println(currentPlayer.getName() + " rolled a dice " + diceValue + " and moved from " + currentPosition + " to " + nextPosition);

            currentPlayer.setPosition(nextPosition);

            if (nextPosition == board.getSize()){
                System.out.println(currentPlayer.getName() + " wins the game");
                winnerFound = true;
            }else{
                players.offer(currentPlayer);
            }

        }
    }
}
