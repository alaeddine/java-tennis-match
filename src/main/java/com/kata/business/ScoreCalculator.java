package com.kata.business;

import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.PlayerEnum;

/**
 * calculate the score for a tennis match and indicates if the is a winner.
 */
public abstract class ScoreCalculator {
    /**
     * calculate the new score when the given player win a new point.
     *
     * @param player : player that win a new point
     */
    public abstract  void calculateScore(PlayerEnum player);

    public abstract PlayerEnum getWinner();

    public abstract boolean  hasWinner();

    public abstract MatchScoreEntity getMatchScore();

    public String getWinnerName() {
        if (hasWinner()) {
            return getWinner() == PlayerEnum.PLAYER1 ?
                    getMatchScore().getPlayer1() : getMatchScore().getPlayer2();
        }
        return PlayerEnum.NO_ONE.toString();
    }
}
