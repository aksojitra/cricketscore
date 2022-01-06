package com.scorecard.entity;

public class NoBall implements Ball {
    private final int run;
    private final boolean isWicket;

    public NoBall(int run, boolean isWicket) {
        this.run =  1 + run;
        this.isWicket = isWicket;
    }

    @Override
    public void updateScoreCard(Team team) {
        ScoreCard scoreCard = team.getScoreCard();
        scoreCard.addRun(run);
        scoreCard.addNoBall();
        if (isWicket) scoreCard.addWicket();
    }

    @Override
    public boolean shouldCount() {
        return false;
    }
}
