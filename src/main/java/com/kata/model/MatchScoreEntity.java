package com.kata.model;

import com.kata.model.enums.MatchStatusEnum;
import com.kata.model.enums.PlayerEnum;

public class MatchScoreEntity {
    /**
     * the winner of the total match
     */
    private PlayerEnum matchWinner;
    private MatchStatusEnum matchStatus = MatchStatusEnum.STARTED;
    private GameScoreEntity currentGameScore = new GameScoreEntity();
    private SetScoreEntity currentSetScore = new SetScoreEntity();
    private String player1;
    private String player2;

    public MatchScoreEntity(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public PlayerEnum getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(PlayerEnum matchWinner) {
        this.matchWinner = matchWinner;
    }

    public MatchStatusEnum getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatusEnum matchStatus) {
        this.matchStatus = matchStatus;
    }

    public GameScoreEntity getCurrentGameScore() {
        return currentGameScore;
    }

    public void setCurrentGameScore(GameScoreEntity currentGameScore) {
        this.currentGameScore = currentGameScore;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public SetScoreEntity getCurrentSetScore() {
        return currentSetScore;
    }

    public void setCurrentSetScore(SetScoreEntity currentSetScore) {
        this.currentSetScore = currentSetScore;
    }
}
