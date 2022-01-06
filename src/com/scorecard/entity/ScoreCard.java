package com.scorecard.entity;

public class ScoreCard {
    private Player striker;
    private Player nonStriker;
    private int wicket;
    private int run;
    private int leftBalls;
    private final int totalBalls;
    private final int totalWickets;
    private int wideBalls;
    private int noBalls;

    public ScoreCard(int totalBalls, int totalWickets) {
        this.totalWickets = totalWickets;
        this.totalBalls = totalBalls;
        this.leftBalls = totalBalls;
        this.wideBalls = 0;
        this.noBalls = 0;
        this.run = 0;
        this.wicket = 0;
        this.striker = null;
        this.nonStriker = null;
    }

    public int getWicket() {
        return wicket;
    }

    public int getRun() {
        return run;
    }

    public int getLeftBalls() {
        return leftBalls;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public int getWideBalls() {
        return wideBalls;
    }

    public int getNoBalls() {
        return noBalls;
    }

    public Player getStriker() {
        return striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void addWicket() {
        this.wicket++;
    }

    public void addRun(int run) {
        this.run += run;
    }

    public void reduceBall() {
        this.leftBalls--;
    }

    public void addWideBall() {
        this.wideBalls++;
    }

    public void addNoBall() {
        this.noBalls++;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void changeStrike() {
        Player newStriker = nonStriker;
        Player newNonStriker = striker;
        nonStriker = newNonStriker;
        striker = newStriker;
    }
}
