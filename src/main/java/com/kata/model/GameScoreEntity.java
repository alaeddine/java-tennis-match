package com.kata.model;

import com.kata.model.enums.GameScoreEnum;
import com.kata.model.enums.PlayerEnum;

import static com.kata.model.enums.PlayerEnum.NO_ONE;
import static com.kata.model.enums.PlayerEnum.PLAYER1;

/**
 * represents a game in a tennis set
 */
public class GameScoreEntity {
    /**
     * player1 game score
     */
    private GameScoreEnum pl1GameScore = GameScoreEnum.ZERO;
    private GameScoreEnum pl2GameScore = GameScoreEnum.ZERO;
    /**
     * the winner of the current game
     */
    private PlayerEnum gameWinner = NO_ONE;


    public GameScoreEnum getGameScore(PlayerEnum player) {
        return PLAYER1 == player ? pl1GameScore : pl2GameScore;
    }

    public void setGameScore(PlayerEnum player, GameScoreEnum gameScore) {
        if (PLAYER1 == player) {
            pl1GameScore = gameScore;
        } else {
            pl2GameScore = gameScore;
        }
    }

    public PlayerEnum getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(PlayerEnum gameWinner) {
        this.gameWinner = gameWinner;
    }

    public void resetGameScore() {
        pl1GameScore = GameScoreEnum.ZERO;
        pl2GameScore = GameScoreEnum.ZERO;
        gameWinner = NO_ONE;
    }
}
