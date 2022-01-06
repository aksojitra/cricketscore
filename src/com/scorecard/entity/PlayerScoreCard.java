package com.scorecard.entity;

public class PlayerScoreCard {
    private PlayerBattingScoreCard playerBattingScoreCard;
    private PlayerBowlingScoreCard playerBowlingScoreCard;

    public PlayerScoreCard() {
        this.playerBattingScoreCard = new PlayerBattingScoreCard();
        this.playerBowlingScoreCard = new PlayerBowlingScoreCard();
    }

    public void updateBattingScoreCard() {

    }

    public void updateBowlingScoreCard() {

    }
}
