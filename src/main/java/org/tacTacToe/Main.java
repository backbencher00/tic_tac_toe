package org.tacTacToe;

import org.tacTacToe.enums.GameDifficulty;
import org.tacTacToe.enums.PlayerType;
import org.tacTacToe.models.*;
import org.tacTacToe.service.GameService;

import java.util.*;

import static org.tacTacToe.service.GameService.playTicTacTo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //first select the game board;
        // select the players
        // if there is remaining positions it is filled by bots;
        // if there are all the bots (edge case)
        // minimum there should be 2 players with minimum 1 human
        //select the difficultyLevel
        GameService service = new GameService();

        int boardSize = 3;
        GameDifficulty difficultyLevel = GameDifficulty.EASY;
        List<Player> players = new ArrayList<>();
        players.add(Player
                .builder()
                .id("p1")
                .name("sourabh")
                .type(PlayerType.HUMAN)
                .build());

        players.add(Player
                .builder()
                .id("p2")
                .name("udit")
                .type(PlayerType.HUMAN)
                .build());
        Game game = service.getBuildGame(boardSize, players, difficultyLevel);
        Queue<PlayerMove> playerMoves = playTicTacTo(game);
        game.setPlayerMoves(playerMoves);
    }




}


