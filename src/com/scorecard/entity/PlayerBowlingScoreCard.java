package com.scorecard.entity;

public class PlayerBowlingScoreCard {
    private int wickets;
    private int balls;
    private int runs;
    private int economy;

    public PlayerBowlingScoreCard() {
        this.balls = 0;
        this.wickets = 0;
        this.runs = 0;
        this.economy = 0;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }
}
