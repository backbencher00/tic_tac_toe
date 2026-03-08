package org.ticTacToe.service;

import org.ticTacToe.Main;
import org.ticTacToe.models.*;

import java.util.*;

public class GamePlayService {
    Game game;
    CheckWinnerService service;

    public GamePlayService(Game game, CheckWinnerService service) {
        this.game = game;
        this.service = service;
    }

    public Queue<PlayerMove> playTicTacTo() {
        int boardSize = game.getBoard().getSize();
        int totalMove = boardSize * boardSize;

        Queue<Player> playerTurn = getPlayersTurns(game.getPlayers());
        Queue<PlayerMove> recordMove = new LinkedList<>();

        int move = 0;
        while (move < totalMove) {
            Player pl = playerTurn.poll();
            String playerSymbol = pl.getName().substring(0,1);
            System.out.println(pl.getName() + " please make  a move");
            int moveTry = 0;
            int row = -1;
            int col = -1;
            while (moveTry < 3){
                Scanner sc = new Scanner(System.in);
                row = sc.nextInt();
                col = sc.nextInt();

                if (row >= 0 && col >=0 && row < boardSize && col < boardSize ) {
                    Cell[][] cell = game.getBoard().getCell(); // already played for this cell
                    if(cell[row][col] == null) break;

                }
                System.out.println("wrong input please try again");
                moveTry++;
            }

            if(moveTry == 3)throw  new RuntimeException("all retry exhaust");

            PlayerMove playerMove = recordPlayerMove(move, pl, recordMove);

            Cell[][] cell = getCells(row, col, playerMove);

            printBoardAfterEveryMove(cell);
            boolean isWinnner = service.checkWinner(row, col, playerSymbol);
            for(Map.Entry<String, Integer> it : service.toCheckIfAnyWinner.get("diagonalLeft").entrySet()){
                System.out.println(it.getKey() + " : " + it.getValue());

            }

            if (isWinnner) {
                System.out.println(pl.getName() + " won the game .................!!");
                break;
            }

            playerTurn.offer(pl);
            move++;
        }
        return recordMove;
    }

    private PlayerMove recordPlayerMove(int move, Player pl, Queue<PlayerMove> recordMove) {
        PlayerMove playerMove = PlayerMove.builder()
                .moveId(move + game.getId() + game.getBoard().getId())
                .moveSymbol(pl.getName().substring(0, 1))
                .playerId(pl.getId()).build();
        recordMove.offer(playerMove);
        return playerMove;
    }

    private Cell[][] getCells(int row, int col, PlayerMove playerMove) {
        Cell[][] cell = game.getBoard().getCell();
        cell[row][col] = Cell
                .builder()
                .boardId(game.getBoard().getId())
                .move(playerMove)
                .cellCoordinate(CellPosition.builder().x(row).y(col).build())
                .build();
        return cell;
    }

    public Queue<Player> getPlayersTurns(List<Player> players) {
        Queue<Player> playerTurn = new LinkedList<>();
        for (Player player : players) {
            playerTurn.offer(player);
        }
        return playerTurn;
    }

    public void printBoardAfterEveryMove(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] != null && cells[i][j].getMove() != null) {
                    System.out.print("| " + cells[i][j].getMove().getMoveSymbol() + " ");
                } else {
                    System.out.print("| _");
                }
            }
            System.out.println("");
        }
    }


}
