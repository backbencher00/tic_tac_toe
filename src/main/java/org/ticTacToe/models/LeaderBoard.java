package org.ticTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class LeaderBoard {
    private String id;
    private String gameId;
    private List<Player> players;
    private List<PlayerRank> ranks;
}
