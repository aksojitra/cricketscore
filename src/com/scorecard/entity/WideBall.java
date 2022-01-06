package com.scorecard.entity;

public class WideBall implements Ball {
    private final int run;

    public WideBall(int run) {
        this.run = 1 + run;
    }

    @Override
    public void updateScoreCard(Team team) {
        ScoreCard scoreCard = team.getScoreCard();
        scoreCard.addRun(run);
        scoreCard.addWideBall();
    }

    @Override
    public boolean shouldCount() {
        return false;
    }
}
