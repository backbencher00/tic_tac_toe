package org.tacTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cell {
    String id;
    String boardId;
    CellPosition cellCordinate;
    PlayerMove move;
}
