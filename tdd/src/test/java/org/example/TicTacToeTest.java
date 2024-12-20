package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testPlacePieceOutOfBoundsX() {
        TicTacToe game = new TicTacToe();
        assertThrows(RuntimeException.class, () -> game.placePiece(-1, 0));
    }

    @Test
    public void testPlacePieceOutOfBoundsY() {
        TicTacToe game = new TicTacToe();
        assertThrows(RuntimeException.class, () -> game.placePiece(0, 3));
    }

    @Test
    public void testPlacePieceOnOccupiedSpace() {
        TicTacToe game = new TicTacToe();
        game.placePiece(1, 1);
        assertThrows(RuntimeException.class, () -> game.placePiece(1, 1));
    }

    @Test
    public void testSwitchPlayers() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer());
        game.placePiece(0, 0);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void testWinningCondition() {
        TicTacToe game = new TicTacToe();
        game.placePiece(0, 0);
        game.placePiece(1, 0);
        game.placePiece(0, 1);
        game.placePiece(1, 1);
        game.placePiece(0, 2);
        assertTrue(game.checkWinner());
    }

    @Test
    public void testDrawCondition() {
        TicTacToe game = new TicTacToe();
        game.placePiece(0, 0);
        game.placePiece(0, 1);
        game.placePiece(0, 2);
        game.placePiece(1, 1);
        game.placePiece(1, 0);
        game.placePiece(1, 2);
        game.placePiece(2, 1);
        game.placePiece(2, 0);
        game.placePiece(2, 2);
        assertTrue(game.isDraw());
    }
}
