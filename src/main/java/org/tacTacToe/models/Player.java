package org.tacTacToe.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.tacTacToe.enums.PlayerType;
@Getter
@Setter
@Builder
public class Player {
    private String id;
    private String name;
    private PlayerType type;
}
