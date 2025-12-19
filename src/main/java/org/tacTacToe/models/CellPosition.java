package org.tacTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CellPosition {
    private int x;
    private int y;
}
