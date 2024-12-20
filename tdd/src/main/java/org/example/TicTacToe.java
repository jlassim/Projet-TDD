package org.example;

import java.util.Arrays;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private int turn;
    private TicTacToeSave save;

    // Constructeur pour initialiser le jeu
    public TicTacToe() {
        this.board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        this.currentPlayer = 'X';
        this.turn = 1;
        this.save = new TicTacToeSave(new MockDB("tic-tac-toe"));
    }

    // Méthode pour placer un pion
    public boolean placePiece(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            throw new RuntimeException("Invalid position.");
        }
        if (board[x][y] != ' ') {
            throw new RuntimeException("Position already occupied.");
        }

        board[x][y] = currentPlayer;
        Data move = new Data(turn++, x, y, currentPlayer);
        if (!save.saveMove(move)) {
            return false; // Retourne false en cas d'échec de la sauvegarde
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    // Méthode pour vérifier le gagnant
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }

    // Méthode pour vérifier un match nul
    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return !checkWinner();
    }

    // Méthode pour afficher la grille
    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("Bienvenue dans le jeu Tic-Tac-Toe!");

        // Afficher l'état initial de la grille
        game.displayBoard();

        // Exemple de jeu
        game.placePiece(0, 0); // Joueur X
        game.displayBoard();
        game.placePiece(1, 1); // Joueur O
        game.displayBoard();
        game.placePiece(0, 1); // Joueur X
        game.displayBoard();
        game.placePiece(1, 0); // Joueur O
        game.displayBoard();
        game.placePiece(0, 2); // Joueur X gagne !

        // Afficher l'état final du jeu
        game.displayBoard();
        if (game.checkWinner()) {
            System.out.println("Le joueur " + game.getCurrentPlayer() + " a gagné !");
        } else if (game.isDraw()) {
            System.out.println("Match nul !");
        }
    }
}

