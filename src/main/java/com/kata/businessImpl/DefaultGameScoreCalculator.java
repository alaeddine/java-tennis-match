package com.kata.businessImpl;


import com.kata.business.ScoreCalculator;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.GameScoreEnum;
import com.kata.model.enums.PlayerEnum;


public class DefaultGameScoreCalculator implements ScoreCalculator {

    protected MatchScoreEntity matchScore;

    public DefaultGameScoreCalculator(MatchScoreEntity matchScore) {
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
        return matchScore.getCurrentGameScore().getGameWinner();
    }

    @Override
    public boolean hasWinner() {
        return matchScore.getCurrentGameScore().getGameWinner() != PlayerEnum.NO_ONE;
    }

    @Override
    public MatchScoreEntity getMatchScore() {
        return matchScore;
    }

    @Override
    public String getWinnerName() {
        if (hasWinner()) {
            return getWinner() == PlayerEnum.PLAYER1 ?
                    matchScore.getPlayer1() : matchScore.getPlayer2();
        }
        return PlayerEnum.NO_ONE.toString();
    }

}
