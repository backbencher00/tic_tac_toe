package org.tacTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Board {
    private String id;
    private int size;
    private Cell [][] cell;
    private List<Player> players;
}
