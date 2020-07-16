package com.kata.exceptions;

/**
 * raised when trying to perform a wrong operation that is not allowed in the current match state. for example marking goal
 * when the match is finished.
 */
public class MatchWrongStateException extends RuntimeException {

    public static String MatchFinishedException = "Match is already  finished !";
    public static String MatchNotFinishedException = "Match not yet finished !";

    public MatchWrongStateException(String message) {
        super(message);
    }
}
