package com.kata.businessImpl;

import com.kata.model.GameScoreEntity;
import com.kata.model.MatchScoreEntity;
import com.kata.model.SetScoreEntity;
import com.kata.model.enums.PlayerEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class SetScoreCalculatorTest {
    @InjectMocks
    SetScoreCalculator setScoreCalculator;

    @Mock
    DeuceGameScoreCalculator deuceGameScoreCalculator;

    @Mock
    MatchScoreEntity matchScore;

    @Test
    public void givenCurrentScoreIs15_40_And_setScoreIS_4_5_WhenPlayer2WinAPoint_Then_Player2_Win() {
        //given
        SetScoreEntity setScoreEntity = new SetScoreEntity();
        setScoreEntity.setSetScore(PlayerEnum.PLAYER1, 4);
        setScoreEntity.setSetScore(PlayerEnum.PLAYER2, 5);

        doReturn(new GameScoreEntity()).when(matchScore)
                .getCurrentGameScore();
        doReturn(setScoreEntity).when(matchScore)
                .getCurrentSetScore();

        doReturn(true).when(deuceGameScoreCalculator)
                .hasWinner();

        //when
        setScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER1))
                .isEqualTo(0);
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER2))
                .isEqualTo(0);
        assertThat(matchScore.getCurrentSetScore().getGameWinner())
                .isEqualTo(PlayerEnum.PLAYER2);
    }

    @Test
    public void givenCurrentScoreIs15_40_And_setScoreIS_3_4_WhenPlayer2WinAPoint_Then_set_become_3_5() {
        //given
        SetScoreEntity setScoreEntity = new SetScoreEntity();
        setScoreEntity.setSetScore(PlayerEnum.PLAYER1, 3);
        setScoreEntity.setSetScore(PlayerEnum.PLAYER2, 4);

        doReturn(new GameScoreEntity()).when(matchScore)
                .getCurrentGameScore();
        doReturn(setScoreEntity).when(matchScore)
                .getCurrentSetScore();

        doReturn(true).when(deuceGameScoreCalculator)
                .hasWinner();

        //when
        setScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER1))
                .isEqualTo(3);
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER2))
                .isEqualTo(5);
        assertThat(matchScore.getCurrentSetScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);
    }

    @Test
    public void givenCurrentScoreIs15_40_And_setScoreIS_6_6_WhenPlayer2WinAPoint_Then_Player2_Win() {
        //given
        SetScoreEntity setScoreEntity = new SetScoreEntity();
        setScoreEntity.setSetScore(PlayerEnum.PLAYER1, 6);
        setScoreEntity.setSetScore(PlayerEnum.PLAYER2, 6);

        doReturn(new GameScoreEntity()).when(matchScore)
                .getCurrentGameScore();
        doReturn(setScoreEntity).when(matchScore)
                .getCurrentSetScore();

        doReturn(true).when(deuceGameScoreCalculator)
                .hasWinner();

        //when
        setScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER1))
                .isEqualTo(0);
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER2))
                .isEqualTo(0);
        assertThat(matchScore.getCurrentSetScore().getGameWinner())
                .isEqualTo(PlayerEnum.PLAYER2);
    }

    @Test
    public void givenCurrentScoreIs15_40_And_setScoreIS_5_5_WhenPlayer2WinAPoint_Then_set_become_5_6() {
        //given
        SetScoreEntity setScoreEntity = new SetScoreEntity();
        setScoreEntity.setSetScore(PlayerEnum.PLAYER1, 5);
        setScoreEntity.setSetScore(PlayerEnum.PLAYER2, 5);

        doReturn(new GameScoreEntity()).when(matchScore)
                .getCurrentGameScore();
        doReturn(setScoreEntity).when(matchScore)
                .getCurrentSetScore();

        doReturn(true).when(deuceGameScoreCalculator)
                .hasWinner();

        //when
        setScoreCalculator.calculateScore(PlayerEnum.PLAYER2);

        //then
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER1))
                .isEqualTo(5);
        assertThat(matchScore.getCurrentSetScore().getSetScore(PlayerEnum.PLAYER2))
                .isEqualTo(6);
        assertThat(matchScore.getCurrentSetScore().getGameWinner())
                .isEqualTo(PlayerEnum.NO_ONE);
    }
}
