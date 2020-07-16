package com.kata.business;

import com.kata.exceptions.MatchWrongStateException;
import com.kata.model.enums.PlayerEnum;

/**
 * Business interface for the tennis match
 **/
public interface TennisMatch {
    /**
     * used to mark a goal by a given player
     **/
    void winPoint(PlayerEnum player) throws MatchWrongStateException;

    void displayScore();

    boolean isMatchFinished();
}
