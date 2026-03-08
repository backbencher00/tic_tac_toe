package org.ticTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cell {
    String id;
    String boardId;
    CellPosition cellCoordinate;
    PlayerMove move;
}
