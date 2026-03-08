package org.ticTacToe;

import org.ticTacToe.enums.GameDifficulty;
import org.ticTacToe.enums.PlayerType;
import org.ticTacToe.models.*;
import org.ticTacToe.service.CheckWinnerService;
import org.ticTacToe.service.GameBuilder;
import org.ticTacToe.service.GamePlayService;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select board size");

        int boardSize = sc.nextInt();
        System.out.println("Selected board size is: " + boardSize);

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
        GameBuilder gameBuilder = new GameBuilder(boardSize, players, difficultyLevel);
        Game game = gameBuilder.getBuildGame();
        CheckWinnerService winnerService = new CheckWinnerService(game);

        GamePlayService gamePlayService = new GamePlayService(game, winnerService);
        Queue<PlayerMove> playerMoves = gamePlayService.playTicTacTo();
        game.setPlayerMoves(playerMoves);
    }
}


