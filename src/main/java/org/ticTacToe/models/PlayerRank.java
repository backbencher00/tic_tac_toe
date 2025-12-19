package org.ticTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlayerRank {
    private String playerId;
    private String playerName;
    private String playerRank;
}
