package com.kata.business;

import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.PlayerEnum;

/**
 * calculate the score for a tennis match and indicates if the is a winner.
 */
public interface ScoreCalculator {
    /**
     * calculate the new score when the given player win a new point.
     *
     * @param player : player that win a new point
     */
    void calculateScore(PlayerEnum player);

    PlayerEnum getWinner();

    boolean hasWinner();

    MatchScoreEntity getMatchScore();

    String getWinnerName();
}
