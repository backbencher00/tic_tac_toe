package org.ticTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.ticTacToe.enums.GameDifficulty;

import java.util.List;
import java.util.Queue;

@Getter
@Setter
@Builder
public class Game {
    private String id;
    private Board board;
    private List<Player> players;
    private GameDifficulty difficulty;
    private Queue<PlayerMove> playerMoves;
}
