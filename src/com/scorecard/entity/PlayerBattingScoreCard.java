package com.scorecard.entity;

public class PlayerBattingScoreCard {
    private int run;
    private int fours;
    private int sixes;
    private int balls;
    private int singles;
    private int doubles;
    private int triples;
    private int dots;
    private double average;

    public PlayerBattingScoreCard() {
        this.run = 0;
        this.fours = 0;
        this.singles = 0;
        this.sixes = 0;
        this.balls = 0;
        this.doubles = 0;
        this.dots = 0;
        this.triples = 0;
        this.average = 0.0;
    }

    public int getFours() {
        return fours;
    }

    public void addFours() {
        run += 4;
        balls++;
        average = (double)run / balls;
        this.fours++;
    }

    public int getSixes() {
        return sixes;
    }

    public void addSixes() {
        run += 6;
        balls++;
        average = (double)run / balls;
        this.sixes++;
    }

    public int getBalls() {
        return balls;
    }

    public int getSingles() {
        return singles;
    }

    public void addSingle() {
        run += 1;
        balls++;
        average = (double)run / balls;
        this.singles++;
    }

    public int getDoubles() {
        return doubles;
    }

    public void addDouble() {
        run += 2;
        balls++;
        average = (double)run / balls;
        this.doubles++;
    }

    public int getTriples() {
        return triples;
    }

    public void addTriple() {
        run += 3;
        balls++;
        average = (double)run / balls;
        this.triples++;
    }

    public int getDots() {
        return dots;
    }

    public void addDot() {
        balls++;
        average = (double)run / balls;
        this.dots++;
    }

    public double getAverage() {
        return average;
    }

    public int getRun() {
        return run;
    }
}
