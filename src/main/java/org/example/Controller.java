package org.example;

import model.Bot;
import model.Borad;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/bot")
public class Controller {
    @PostMapping
    // Map the request parameters to the boardString and symbol variables
    public Borad getBoard(@RequestParam("board") String boardString, @RequestParam("symbol") char symbol) {
        // Convert the boardString parameter to a 2D char array
        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            board[row][col] = boardString.charAt(i);
        }
        // Create new bot with the specified symbol and make a move on the board
        Bot bot = new Bot(symbol);
        int[] move = bot.makeMove(board);
        board[move[0]][move[1]] = symbol;
        // Return the updated board as a Borad object
        return new Borad(board);
    }

}

