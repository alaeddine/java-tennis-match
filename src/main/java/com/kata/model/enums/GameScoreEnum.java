package com.kata.model.enums;

public enum GameScoreEnum {
    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADV("ADV"), DEUCE("DEUCE");
    String score;

    GameScoreEnum(String score) {
        this.score = score;
    }

    public String getValue() {
        return score;
    }
}
