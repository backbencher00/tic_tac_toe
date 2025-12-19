package org.tacTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlayerMove {
    private String moveId;
    private String moveSymbol;
    private String playerId;
}
