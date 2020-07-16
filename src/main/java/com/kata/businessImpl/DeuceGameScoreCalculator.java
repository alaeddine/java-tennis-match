package com.kata.businessImpl;

import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.GameScoreEnum;
import com.kata.model.enums.PlayerEnum;

public class DeuceGameScoreCalculator extends DefaultGameScoreCalculator {
    public DeuceGameScoreCalculator(MatchScoreEntity matchScore) {
        super(matchScore);
    }

    @Override
    public void calculateScore(PlayerEnum player) {
        PlayerEnum adversary = (player == PlayerEnum.PLAYER1 ? PlayerEnum.PLAYER2 : PlayerEnum.PLAYER1);
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
                manageFortyState(matchScore, player, adversary);
                break;
            case DEUCE:
                manageDeuceState(matchScore, player, adversary);
                break;
            case ADV:
                matchScore.getCurrentGameScore().resetGameScore();
                matchScore.getCurrentGameScore().setGameWinner(player);

        }
    }

    private void manageFortyState(MatchScoreEntity matchScore, PlayerEnum player, PlayerEnum adversary) {
        GameScoreEnum selectedPlayerScore = matchScore.getCurrentGameScore().getGameScore(player);
        GameScoreEnum adversaryPlayerScore = matchScore.getCurrentGameScore().getGameScore(adversary);

        if (adversaryPlayerScore == GameScoreEnum.ADV) {
            matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.DEUCE);
            matchScore.getCurrentGameScore().setGameScore(adversary, GameScoreEnum.DEUCE);
        } else if (adversaryPlayerScore == GameScoreEnum.FORTY) {
            matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.ADV);
        } else {// cases 0,15,30 => i'am a winner
            matchScore.getCurrentGameScore().resetGameScore();
            matchScore.getCurrentGameScore().setGameWinner(player);
        }
    }

    private void manageDeuceState(MatchScoreEntity matchScore, PlayerEnum player, PlayerEnum adversary) {
        matchScore.getCurrentGameScore().setGameScore(player, GameScoreEnum.ADV);
        matchScore.getCurrentGameScore().setGameScore(adversary, GameScoreEnum.FORTY);
    }
}
