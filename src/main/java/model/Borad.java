package model;

public class Borad {
    private char[][] board;

    public Borad() {
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    public  Borad(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}

