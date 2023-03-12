package model;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private char symbol;

    public Bot(char symbol) {
        this.symbol = symbol;
    }

    // Returns the bot's next move based on the current state of the Tic Tac Toe board
    public int[] makeMove(char[][] board) {
        int[] move = minimax(board, symbol);
        return new int[]{move[1], move[2]};
    }

    // The minimax algorithm, which recursively searches the game tree to determine the best move for the bot
    private int[] minimax(char[][] board, char player) {
        char opponent = (player == 'X') ? 'O' : 'X';

        // Check for terminal states (i.e., a player has won or the board is full)
        if (hasWon(board, symbol)) {
            return new int[]{10, -1, -1};
        } else if (hasWon(board, opponent)) {
            return new int[]{-10, -1, -1};
        } else if (isFull(board)) {
            return new int[]{0, -1, -1};
        }

        // Find all empty cells on the board
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        // Apply minimax algorithm to each empty cell to find the best move for the bot
        int bestScore = (player == symbol) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = new int[]{-1, -1};
        for (int[] cell : emptyCells) {
            int row = cell[0];
            int col = cell[1];
            board[row][col] = player;
            int[] score = minimax(board, (player == symbol) ? opponent : symbol);
            board[row][col] = ' ';
            if (player == symbol && score[0] > bestScore) {
                bestScore = score[0];
                bestMove = cell;
            } else if (player == opponent && score[0] < bestScore) {
                bestScore = score[0];
                bestMove = cell;
            }
        }

        return new int[]{bestScore, bestMove[0], bestMove[1]};
    }

    // Returns true if the Tic Tac Toe board is full (i.e., there are no empty cells), false otherwise
    private boolean isFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    // Returns true if the specified player has won the game, false otherwise
    private boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Horizontal win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Vertical win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false; // No win
}}
