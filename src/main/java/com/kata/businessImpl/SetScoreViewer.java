package com.kata.businessImpl;

import com.kata.business.ScoreCalculator;
import com.kata.business.ScoreViewer;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.PlayerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetScoreViewer implements ScoreViewer {
    private static final Logger logger = LoggerFactory.getLogger(SetScoreViewer.class);
    protected ScoreCalculator scoreCalculator;
    protected MatchScoreEntity matchScore;

    public SetScoreViewer(ScoreCalculator scoreCalculator, MatchScoreEntity matchScore) {
        this.scoreCalculator = scoreCalculator;
        this.matchScore = matchScore;
    }

    @Override
    public void displayScore() {
        if (scoreCalculator.hasWinner()) {
            logger.info(">>>>>>>>>>>>>> current score: {} win\n", scoreCalculator.getWinnerName());
        } else {
            logger.info(">>>>>>>>>>>>>> current score: {} vs {} -> set {}/{} ## game {}/{}\n",
                    matchScore.getPlayer1(),
                    matchScore.getPlayer2(),
                    matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER1),
                    matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER2),
                    matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1).getValue(),
                    matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2).getValue());


        }
    }
}
