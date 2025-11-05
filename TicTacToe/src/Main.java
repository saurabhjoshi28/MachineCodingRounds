import model.Board;
import model.Move;
import model.Player;
import service.Game;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Player 1: <Symbol Name>");
        String[] p1Input = sc.nextLine().split(" ");

        System.out.println("Enter Player 2: <Symbol Name>");
        String[] p2Input = sc.nextLine().split(" ");

        System.out.println("Start entering moves as 'row col', type 'exit' to stop:");

        Player p1 = new Player(p1Input[0].charAt(0), p1Input[1]);
        Player p2 = new Player(p2Input[0].charAt(0), p2Input[1]);

        Game game = new Game(p1, p2);
        game.start();
    }
}
/*
* Design tictactoe -->
* step 1. Gather requirements
*
* 1. 3x3 board
* 2. 2 Players
* 3. Each player takes turns alternatively
* 4. Symbols --> "O" and "X"
* 5. Every turn players puts his symbol on any empty cell
* 6. Game termination scenario -->
*   i. if board is full ---> draw
*   ii. if any line verti/hori/diag has all same symbol ---> player of that symbol wins.
*
* step 2. Nouns(Identification of entities)
* 1. Board
* 2. Players
* 3. Turns
* 4. Symbols
* 5. Move
* 6. Game
*
* step 3. Raw diagram -->
*           Game
*           /    \
*       Board  Players
*               /  \
*              A   B
* two types of approaches -- >
* 1. Top - Bottom
* 2. Bottom - Top
* */
