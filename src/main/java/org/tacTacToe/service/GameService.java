package org.tacTacToe.service;

import org.tacTacToe.enums.GameDifficulty;
import org.tacTacToe.models.*;

import java.util.*;

public class GameService{

    public Game getBuildGame(int boardSize, List<Player> players, GameDifficulty difficulty){
        Cell[][] cells = new Cell[boardSize][boardSize];
        Board board = Board
                .builder()
                .id("b1")
                .cell(cells)
                .players(players)
                .size(boardSize)
                .build(); ;
        return Game.builder()
                .id("g1")
                .board(board)
                .difficulty(difficulty)
                .players(players)
                .build();
    }

    public static Queue<PlayerMove> playTicTacTo(Game game) {
        Scanner sc = new Scanner(System.in);
        int move = 0;
        Queue<Player> playerTurn = getPlayersTurns(game.getPlayers());
        Queue<PlayerMove> recordMove = new LinkedList<>();
        int boardSize = game.getBoard().getSize();
        while (move < boardSize * boardSize) {
            Player pl = playerTurn.poll();
            System.out.println(pl.getName() + " please make  a move");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x<0 || y< 0 || x>= boardSize || y>= boardSize){
                System.out.println("wrong input please try again");
                continue;
            }
            CellPosition cellPosition = CellPosition
                    .builder().x(x).y(y).build();
            PlayerMove playerMove = PlayerMove
                    .builder()
                    .moveId(move + game.getId() + game.getBoard().getId())
                    .moveSymbol( pl.getName().substring(0, 1))
                    .playerId(pl.getId()).build();
            Cell[][] cell = game.getBoard().getCell();
            cell[x][y] = Cell
                    .builder()
                    .boardId(game.getBoard().getId())
                    .move(playerMove)
                    .cellCordinate(cellPosition)
                    .build();
            recordMove.offer(playerMove);
            printBoardAfterEveryMove(cell);
            String isWinner = checkIfAnyPlayerWin(cell, boardSize);
            if(!isWinner.equals("-1")){
                System.out.println("winner : " + isWinner);
                break;
            }
            playerTurn.offer(pl);
            move++;
        }
        return recordMove;
    }

    public static Queue<Player> getPlayersTurns(List<Player> players){
        Queue<Player> playerTurn = new LinkedList<>();
        for(Player player : players){
            playerTurn.offer(player);
        }
        return playerTurn;
    }
    public static void printBoardAfterEveryMove(Cell [][] cells){
        for(int i = 0; i< cells.length; i++){
            for(int j = 0; j< cells[i].length ; j++){
                if(cells[i][j] != null && cells[i][j].getMove() != null){
                    System.out.print(" " + cells[i][j].getMove().getMoveSymbol());
                }else {
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }

    public static String checkIfAnyPlayerWin(Cell [][] cells, int boardSize){
        for(int i = 0; i< cells.length; i++){
            HashMap<String, Integer> horizontal = new HashMap<>();
            for(int j = 0; j< cells[i].length ; j++){
                if(cells[i][j] != null && cells[i][j].getMove() != null){
                    String key = cells[i][j].getMove().getPlayerId();
                    if(!horizontal.containsKey(key)){
                        horizontal.put(key, 1);
                    }else{
                        horizontal.put(key, horizontal.get(key)+1);
                    }
                }
            }

            for(Map.Entry<String, Integer> isWinner : horizontal.entrySet()){
                if(isWinner.getValue().equals(boardSize)){


                    return isWinner.getKey();
                }
            }
        }
//-------------------------------------------------------------------------------
        for(int i = 0; i< cells.length; i++){
            HashMap<String, Integer> vertical = new HashMap<>();
            for(int j = 0; j< cells[i].length ; j++){
                if(cells[j][i] != null && cells[j][i].getMove() != null){
                    String key = cells[j][i].getMove().getPlayerId();
                    if(!vertical.containsKey(key)){
                        vertical.put(key, 1);
                    }else{
                        vertical.put(key, vertical.get(key)+1);
                    }
                }


            }
            for(Map.Entry<String, Integer> isWinner : vertical.entrySet()){
                if(isWinner.getValue().equals(boardSize)){
                    return isWinner.getKey();
                }
            }
        }
//----------------------------------------------------------------------------------
        HashMap<String, Integer> leftDiagonal = new HashMap<>();
        for(int i = 0; i< cells.length; i++){
            for(int j = 0; j< cells[i].length ; j++){
                if(i==j){
                    if(cells[j][i] != null && cells[j][i].getMove() != null){
                        String key = cells[j][i].getMove().getPlayerId();
                        if(!leftDiagonal.containsKey(key)){
                            leftDiagonal.put(key, 1);
                        }else{
                            leftDiagonal.put(key, leftDiagonal.get(key)+1);
                        }
                    }
                }
            }
        }

        for(Map.Entry<String, Integer> isWinner : leftDiagonal.entrySet()){
            if(isWinner.getValue().equals(boardSize)){
                return isWinner.getKey();
            }
        }

        //----------------------------------------------------------------------------------
        HashMap<String, Integer> rightDiagonal = new HashMap<>();
        for(int i = 0; i< cells.length; i++){
            for(int j = 0; j< cells[i].length ; j++){
                if(i+j == boardSize-1){
                    if(cells[j][i] != null && cells[j][i].getMove() != null){
                        String key = cells[j][i].getMove().getPlayerId();
                        if(!rightDiagonal.containsKey(key)){
                            rightDiagonal.put(key, 1);
                        }else{
                            rightDiagonal.put(key, leftDiagonal.get(key)+1);
                        }
                    }
                }
            }
        }

        for(Map.Entry<String, Integer> isWinner : rightDiagonal.entrySet()){
            if(isWinner.getValue().equals(boardSize)){
                return isWinner.getKey();
            }
        }

        return "-1";


    }
}
