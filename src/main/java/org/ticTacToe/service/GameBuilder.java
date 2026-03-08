package org.ticTacToe.service;

import org.ticTacToe.enums.GameDifficulty;
import org.ticTacToe.models.Board;
import org.ticTacToe.models.Cell;
import org.ticTacToe.models.Game;
import org.ticTacToe.models.Player;

import java.util.HashMap;
import java.util.List;

public class GameBuilder {

    int boardSize;
    List<Player> players;
    GameDifficulty difficulty;

    public GameBuilder(int boardSize, List<Player> players, GameDifficulty difficulty) {
        this.boardSize = boardSize;
        this.players = players;
        this.difficulty = difficulty;
    }

    public Game getBuildGame() {
        Cell[][] cells = new Cell[boardSize][boardSize];
        Board board = Board
                .builder()
                .id("b1")
                .cell(cells)
                .players(players)
                .size(boardSize)
                .build();
        ;
        return Game.builder()
                .id("g1")
                .board(board)
                .difficulty(difficulty)
                .players(players)
                .build();
    }

}
