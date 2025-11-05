package model;

public class Board {
    private final int size;
    private final char[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializedBoard();
    }
    private void initializedBoard(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                grid[i][j] = '.';
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(grid[i][j]);
                if (j != size - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col){
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == '.';
    }

    public void makeMove(Player player, Move move){
        grid[move.getRow()][move.getCol()] = player.getSymbol();
    }

    public boolean isFull(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == '.') return false;
            }
        }
        return true;
    }

    public boolean checkWin(Player player){
        char symbol = player.getSymbol();
        for (int i = 0; i < size; i++){
            if(checkRow(i, symbol) || checkCol(i, symbol)){
                return true;
            }
        }

        return checkDiag(symbol) || checkAntiDiag(symbol);
    }

    private boolean checkRow(int row, char symbol){
        for (int j = 0; j < size; j++){
            if (grid[row][j] != symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, char symbol){
        for (int i = 0; i < size; i++){
            if (grid[i][col] != symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiag(char symbol){
        for (int i = 0; i < size; i++){
            if (grid[i][i] != symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiag(char symbol){
        for (int i = 0; i < size; i++){
            if (grid[i][size - 1 - i] != symbol){
                return false;
            }
        }
        return true;
    }

}
