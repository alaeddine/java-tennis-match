package com.kata.businessImpl;

import com.kata.business.ScoreCalculator;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.PlayerEnum;

/**
 * manage set score
 */
public class SetScoreCalculator extends ScoreCalculator {
    protected DeuceGameScoreCalculator gameScoreCalculator;
    protected MatchScoreEntity matchScore;

    public SetScoreCalculator(DeuceGameScoreCalculator gameScoreCalculator, MatchScoreEntity matchScore) {
        this.gameScoreCalculator = gameScoreCalculator;
        this.matchScore = matchScore;
    }

    @Override
    public void calculateScore(PlayerEnum player) {
        PlayerEnum adversary = (player == PlayerEnum.PLAYER1 ? PlayerEnum.PLAYER2 : PlayerEnum.PLAYER1);
        int playerSetScore = matchScore.getCurrentSetScore().getSetScore(player);
        int adversarySetScore = matchScore.getCurrentSetScore().getSetScore(adversary);

        //if current game is no yet finished, calculate game score
        gameScoreCalculator.calculateScore(player);
        if (gameScoreCalculator.hasWinner()) {
            matchScore.getCurrentGameScore().resetGameScore();
            switch (playerSetScore) {
                case 5:
                    if (playerSetScore + 1 - adversarySetScore >= 2) {
                        //win
                        matchScore.getCurrentSetScore().resetSetScore();
                        matchScore.getCurrentSetScore().setSetWinner(player);
                    } else {
                        matchScore.getCurrentSetScore().setSetScore(player, playerSetScore + 1);
                    }
                    break;
                case 6:
                    //win
                    matchScore.getCurrentSetScore().resetSetScore();
                    matchScore.getCurrentSetScore().setSetWinner(player);
                    break;
                default:
                    matchScore.getCurrentSetScore().setSetScore(player, playerSetScore + 1);
            }
        }
        if(hasWinner()) {
            matchScore.getCurrentSetScore().resetSetScore();
            matchScore.getCurrentSetScore().setSetWinner(player);
        }
    }

    @Override
    public PlayerEnum getWinner() {
        return matchScore.getCurrentSetScore().getGameWinner();
    }

    @Override
    public boolean hasWinner() {
        return matchScore.getCurrentSetScore().getGameWinner() != PlayerEnum.NO_ONE;
    }

    @Override
    public MatchScoreEntity getMatchScore() {
        return matchScore;
    }
}
