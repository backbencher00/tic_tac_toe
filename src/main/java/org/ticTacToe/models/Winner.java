package org.ticTacToe.models;

public class Winner {
    public String winnerId;
    public boolean isWin;
    public Winner(String winnerId, boolean isWin){
        this.winnerId = winnerId;
        this.isWin = isWin;
    }
}
