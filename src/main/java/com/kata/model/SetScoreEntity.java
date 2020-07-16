package com.kata.model;

import com.kata.model.enums.PlayerEnum;

import static com.kata.model.enums.PlayerEnum.NO_ONE;
import static com.kata.model.enums.PlayerEnum.PLAYER1;

/**
 * represents a set score in a tennis match
 */
public class SetScoreEntity {
    /**
     * player1 set score
     */
    private int pl1SetScore ;
    private int pl2SetScore ;
    /**
     * the winner of the current set
     */
    private PlayerEnum gameWinner = NO_ONE;


    public int getSetScore(PlayerEnum player) {
        return PLAYER1 == player ? pl1SetScore : pl2SetScore;
    }

    public void setSetScore(PlayerEnum player, int setScore) {
        if (PLAYER1 == player) {
            pl1SetScore = setScore;
        } else {
            pl2SetScore = setScore;
        }
    }

    public PlayerEnum getGameWinner() {
        return gameWinner;
    }

    public void setSetWinner(PlayerEnum gameWinner) {
        this.gameWinner = gameWinner;
    }

    public void resetSetScore() {
        pl1SetScore = 0;
        pl2SetScore = 0;
        gameWinner = NO_ONE;
    }
}
