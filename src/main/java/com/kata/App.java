package com.kata;

import com.kata.business.ScoreCalculator;
import com.kata.business.ScoreViewer;
import com.kata.business.TennisMatch;
import com.kata.businessImpl.*;
import com.kata.model.MatchScoreEntity;
import com.kata.model.enums.PlayerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Enter player1 name: ");
        Scanner scanner = new Scanner(System.in);
        String player1 = scanner.nextLine();

        logger.info("Enter player2 name: ");
        String player2 = scanner.nextLine();

        //
        logger.info("Enter 1 to execute sprint1_uc1 \n  and 2 to execute sprint1_uc2 \n");
        int appVersion = Integer.parseInt(scanner.nextLine());
        // init app
        TennisMatch tennisMatch = buildApp(appVersion, player1, player2);


        boolean exit = false;
        do {
            logger.info("Enter 1 or 2  to mark point to player1 or player 2 respectively: ");
            logger.info("Enter 3 to exit ");
            int playerNum = Integer.parseInt(scanner.nextLine());

            if (playerNum == 1) {
                //player 1 mark a point
                tennisMatch.winPoint(PlayerEnum.PLAYER1);

            } else if (playerNum == 2) {
                //player 1 mark a point
                tennisMatch.winPoint(PlayerEnum.PLAYER2);

            } else {
                exit = true;
            }

            if (tennisMatch.isMatchFinished()) {
                exit = true;
            }

        } while (!exit);
        logger.info("program is closed ... ");

    }

    public static TennisMatch buildApp(int appVersion, String player1, String player2) {
        MatchScoreEntity matchScore = new MatchScoreEntity(player1, player2);
        ScoreCalculator scoreCalculator = null;
        ScoreViewer scoreViewer = null;

        switch (appVersion) {
            case 1:
                scoreCalculator = new DefaultGameScoreCalculator(matchScore);
                scoreViewer = new DefaultGameScoreViewer(scoreCalculator);
                break;
            case 2:
                scoreCalculator = new DeuceGameScoreCalculator(matchScore);
                scoreViewer = new DeuceGameScoreViewer(scoreCalculator);
        }

        return new TennisMatchImpl(scoreCalculator, scoreViewer);
    }
}
