package model;

public class Borad {
    private char[][] board;

    public Borad() {
        // Define a no-argument constructor that initializes the board to an empty 3x3 array
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }
    // Define a constructor that takes a 2D char array as an argument and sets the board to it
    public  Borad(char[][] board) {
        this.board = board;
    }
    // Define a getter method for the board
    public char[][] getBoard() {
        return board;
    }
    // Define a setter method for the board
    public void setBoard(char[][] board) {
        this.board = board;
    }
}

