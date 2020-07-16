package com.kata.businessImpl;

import com.kata.business.ScoreCalculator;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.GameScoreEnum;
import com.kata.model.enums.PlayerEnum;

public class DeuceGameScoreCalculator implements ScoreCalculator {
    private MatchScoreEntity matchScore;

    public DeuceGameScoreCalculator(MatchScoreEntity matchScore) {
        this.matchScore = matchScore;
    }

    @Override
    public void calculateScore(PlayerEnum player) {
        switch (matchScore.getCurrentGameScore().getGameScore(player)) {
            case ZERO:
                matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.FIFTEEN);
                break;
            case FIFTEEN:
                matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.THIRTY);
                break;
            case THIRTY:
                matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.FORTY);
                break;
            case FORTY:
                matchScore.getCurrentGameScore().resetGameScore();
                matchScore.getCurrentGameScore().setGameWinner(player);
        }
    }

    @Override
    public PlayerEnum getWinner() {
        return null;
    }

    @Override
    public boolean hasWinner() {
        return false;
    }

    @Override
    public MatchScoreEntity getMatchScore() {
        return null;
    }

    @Override
    public String getWinnerName() {
        return null;
    }
}
