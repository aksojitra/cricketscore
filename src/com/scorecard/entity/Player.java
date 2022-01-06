package com.scorecard.entity;

import java.util.Objects;

public class Player {
    private final String name;
    private final PlayerBattingScoreCard playerBattingScoreCard;
    private final PlayerBowlingScoreCard playerBowlingScoreCard;

    public Player(String name) {
        this.name = name;
        this.playerBowlingScoreCard = new PlayerBowlingScoreCard();
        this.playerBattingScoreCard = new PlayerBattingScoreCard();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public PlayerBattingScoreCard getPlayerBattingScoreCard() {
        return playerBattingScoreCard;
    }

    public PlayerBowlingScoreCard getPlayerBowlingScoreCard() {
        return playerBowlingScoreCard;
    }
}
