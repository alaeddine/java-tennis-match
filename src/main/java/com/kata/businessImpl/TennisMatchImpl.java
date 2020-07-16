package com.kata.businessImpl;

import com.kata.business.ScoreCalculator;
import com.kata.business.ScoreViewer;
import com.kata.business.TennisMatch;
import com.kata.exceptions.MatchWrongStateException;
import com.kata.model.enums.PlayerEnum;

public class TennisMatchImpl implements TennisMatch {

    private ScoreCalculator scoreCalculator;
    private ScoreViewer scoreViewer;

    public TennisMatchImpl(ScoreCalculator scoreCalculator, ScoreViewer scoreViewer) {
        this.scoreViewer = scoreViewer;
        this.scoreCalculator = scoreCalculator;
    }

    @Override
    public void winPoint(PlayerEnum player) throws MatchWrongStateException {
        if(isMatchFinished()) {
            throw new MatchWrongStateException(MatchWrongStateException.MatchFinishedException);
        }
        else {
            scoreCalculator.calculateScore(player);
            scoreViewer.displayScore();
        }
    }

    @Override
    public void displayScore() {
        scoreViewer.displayScore();
    }

    @Override
    public boolean isMatchFinished() {
        return scoreCalculator.hasWinner();
    }
}
