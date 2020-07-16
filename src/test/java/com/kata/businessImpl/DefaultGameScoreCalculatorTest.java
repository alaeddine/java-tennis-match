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
public class DefaultGameScoreCalculatorTest {

    @InjectMocks
    DefaultGameScoreCalculator defaultGameScoreCalculator;

    @Mock
    MatchScoreEntity matchScore;


    @Test
    public void givenCurrentScoreIs0_0_WhenPlayer1WinAPoint_Then15_0() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        defaultGameScoreCalculator.calculateScore(PlayerEnum.PLAYER1);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.FIFTEEN);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.ZERO);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);

    }

    @Test
    public void givenCurrentScoreIs40_40_WhenPlayer2WinAPoint_ThenPlayer2Win() {
        //given
        GameScoreEntity gameScore = new GameScoreEntity();
        gameScore.setGameScore(PlayerEnum.PLAYER1, GameScoreEnum.FORTY);
        gameScore.setGameScore(PlayerEnum.PLAYER2, GameScoreEnum.FORTY);
        doReturn(gameScore).when(matchScore)
                .getCurrentGameScore();

        //when
        defaultGameScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER1))
                .isEqualTo(GameScoreEnum.ZERO);
        assertThat(matchScore.getCurrentGameScore().getGameScore(PlayerEnum.PLAYER2))
                .isEqualTo(GameScoreEnum.ZERO);
        assertThat(matchScore.getCurrentGameScore().getGameWinner())
                .isEqualTo(PlayerEnum.PLAYER2);
    }
}
