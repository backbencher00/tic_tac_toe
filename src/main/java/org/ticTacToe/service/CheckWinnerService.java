package org.ticTacToe.service;

import org.ticTacToe.models.Game;
import org.ticTacToe.models.Player;

import java.util.*;

public class CheckWinnerService {
    Game game;
    public HashMap<String, HashMap<String, Integer>> toCheckIfAnyWinner;

    public CheckWinnerService(Game game) {
        this.game = game;
        initiateHm();
    }


    private void initiateHm() {
        List<Player> players = game.getPlayers();
        int boardSize = game.getBoard().getSize();
        this.toCheckIfAnyWinner = new HashMap<>();
        HashMap<String, Integer> symbolCountDiagonalL = new HashMap<>();
        HashMap<String, Integer> symbolCountDiagonalR = new HashMap<>();

        for (Player pl : players) {
            String playerSymbol = pl.getName().substring(0, 1);
            symbolCountDiagonalL.put(playerSymbol, 0);
            symbolCountDiagonalR.put(playerSymbol, 0);
         }

        toCheckIfAnyWinner.put("diagonalLeft", symbolCountDiagonalL);
        toCheckIfAnyWinner.put("diagonalRight", symbolCountDiagonalR);

        for (int i = 0; i < boardSize; i++) {
            HashMap<String, Integer> symbolCountRow = new HashMap<>();
            for (Player pl : players) {
                String playerSymbol = pl.getName().substring(0, 1);
                symbolCountRow.put(playerSymbol, 0);
            }
            toCheckIfAnyWinner.put("row" + i, symbolCountRow);
         }

        for (int i = 0; i < boardSize; i++) {
            HashMap<String, Integer> symbolCountCol = new HashMap<>();
            for (Player pl : players) {
                String playerSymbol = pl.getName().substring(0, 1);
                symbolCountCol.put(playerSymbol, 0);
            }
            toCheckIfAnyWinner.put("col" + i, symbolCountCol);
         }
    }

    public boolean checkWinner(int row, int col,  String playerSymbol) {
        int boardSize = game.getBoard().getSize();
        if (row == col) {
            if (fillLeftDiagonalMap(playerSymbol)) {
                return true;
            }

        }
        if (fillRowMap(row, playerSymbol)) {
            return true;
        }

        if (fillColMap(col,playerSymbol)) {
            return true;
        }

        if (Math.abs(row - col) + 1 == boardSize) {
            if (fillRightDiagonalMap(playerSymbol)) {
                return true;
            }
        }
        return false;
    }

    public Boolean fillRowMap(int row, String playerSymbol) {
        String key = "row" + row;
        HashMap<String, Integer> symbolCount = toCheckIfAnyWinner.get(key);

        symbolCount.put(playerSymbol,  symbolCount.get(playerSymbol) + 1);
        toCheckIfAnyWinner.put(key, symbolCount);
        return updateTheTotalCountFilledCell(key, playerSymbol);

    }
    public boolean fillColMap(int col, String playerSymbol) {
        String key = "col" + col;
        HashMap<String, Integer> symbolCount = toCheckIfAnyWinner.get(key);
        symbolCount.put(playerSymbol,  symbolCount.get(playerSymbol) + 1);
        toCheckIfAnyWinner.put(key, symbolCount);
        return updateTheTotalCountFilledCell(key, playerSymbol);
    }


    public boolean fillLeftDiagonalMap(String playerSymbol) {
        String key = "diagonalLeft";
        HashMap<String, Integer> symbolCount = toCheckIfAnyWinner.get(key);

        symbolCount.put(playerSymbol,  symbolCount.get(playerSymbol) + 1);
        toCheckIfAnyWinner.put(key, symbolCount);
        return updateTheTotalCountFilledCell(key, playerSymbol);

    }

    public boolean fillRightDiagonalMap(String playerSymbol) {
        String key = "diagonalRight";
        HashMap<String, Integer> symbolCount = toCheckIfAnyWinner.get(key);
        symbolCount.put(playerSymbol,  symbolCount.get(playerSymbol) + 1);
        toCheckIfAnyWinner.put(key, symbolCount);
        return updateTheTotalCountFilledCell(key, playerSymbol);

    }

    private Boolean updateTheTotalCountFilledCell(String key, String playerSymbol) {
        int boardSize = game.getBoard().getSize();
        HashMap<String, Integer> symbolCount = toCheckIfAnyWinner.get(key);
        if (symbolCount.get(playerSymbol)==boardSize){
            return true;
        }
        return false;
    }
}
