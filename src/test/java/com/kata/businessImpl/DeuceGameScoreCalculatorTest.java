package com.kata.businessImpl;

import com.kata.model.GameScoreEntity;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.GameScoreEnum;
import com.kata.model.enums.PlayerEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class DeuceGameScoreCalculatorTest {

    @InjectMocks
    DeuceGameScoreCalculator deuceGameScoreCalculator;

    @Mock
    MatchScoreEntity matchScore;

    @Test
    public void givenCurrentScoreIs40_40_WhenPlayer2WinAPoint_Then_FORTY_ADV() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        gameScore.setGameScore(PlayerEnum.PLAYER1, GameScoreEnum.FORTY);
        gameScore.setGameScore(PlayerEnum.PLAYER2, GameScoreEnum.FORTY);
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        deuceGameScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.FORTY);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.ADV);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);
    }

    @Test
    public void givenCurrentScoreIs40_ADV_WhenPlayer1WinAPoint_Then_DEUCE_DEUCE() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        gameScore.setGameScore(PlayerEnum.PLAYER1, GameScoreEnum.FORTY);
        gameScore.setGameScore(PlayerEnum.PLAYER2, GameScoreEnum.ADV);
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        deuceGameScoreCalculator.calculateScore(PlayerEnum.PLAYER1);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.DEUCE);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.DEUCE);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);
    }

    @Test
    public void givenCurrentScoreIsDEUCE_DEUCE_WhenPlayer1WinAPoint_ThenADV_40() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        gameScore.setGameScore(PlayerEnum.PLAYER1, GameScoreEnum.DEUCE);
        gameScore.setGameScore(PlayerEnum.PLAYER2, GameScoreEnum.DEUCE);
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        deuceGameScoreCalculator.calculateScore(PlayerEnum.PLAYER1);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.ADV);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.FORTY);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);
    }

    @Test
    public void givenCurrentScoreIsADV_40_WhenPlayer1WinAPoint_ThenPlayer1_win() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        gameScore.setGameScore(PlayerEnum.PLAYER1, GameScoreEnum.ADV);
        gameScore.setGameScore(PlayerEnum.PLAYER2, GameScoreEnum.FORTY);
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        deuceGameScoreCalculator.calculateScore(PlayerEnum.PLAYER1);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.ZERO);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.ZERO);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.PLAYER1);
    }


}
