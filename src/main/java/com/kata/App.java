package com.kata;

import com.kata.business.ScoreCalculator;
import com.kata.business.ScoreViewer;
import com.kata.business.TennisMatch;
import com.kata.businessImpl.DefaultGameScoreCalculator;
import com.kata.businessImpl.DefaultGameScoreViewer;
import com.kata.businessImpl.TennisMatchImpl;
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

        // init app
        MatchScoreEntity matchScore = new MatchScoreEntity(player1, player2);
        ScoreCalculator scoreCalculator = new DefaultGameScoreCalculator(matchScore);
        ScoreViewer scoreViewer = new DefaultGameScoreViewer(scoreCalculator);
        TennisMatch tennisMatch = new TennisMatchImpl(scoreCalculator,scoreViewer);



        boolean exit = false;
        do {
            logger.info("Enter 1 or 2  to mark point to player1 or player 2 respectively: ");
            logger.info("Enter 3 to exit ");
            int playerNum = Integer.parseInt(scanner.nextLine());

            if(playerNum == 1 ){
                //player 1 mark a point
                tennisMatch.winPoint(PlayerEnum.PLAYER1);

            } else if(playerNum == 2 ){
                //player 1 mark a point
                tennisMatch.winPoint(PlayerEnum.PLAYER2);

            }else {
                exit = true;
            }

            if(tennisMatch.isMatchFinished()) {
                exit = true;
            }

        }while (! exit);
        logger.info("program is closed ... ");

    }
}
