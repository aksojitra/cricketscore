package com.scorecard.entity;

public class NormalBall implements Ball {
    private final int run;
    private final boolean isWicket;

    public NormalBall(int run, boolean isWicket) {
        this.run = run;
        this.isWicket = isWicket;
    }

    @Override
    public void updateScoreCard(Team team) {
        ScoreCard scoreCard = team.getScoreCard();
        scoreCard.addRun(run);
        scoreCard.reduceBall();
        if (isWicket) scoreCard.addWicket();
        Player striker = scoreCard.getStriker();
        PlayerBattingScoreCard playerBattingScoreCard = striker.getPlayerBattingScoreCard();
        if (isWicket) {
            scoreCard.setStriker(team.getNextPlayer());
        }
        switch (run) {
            case 0 :
                playerBattingScoreCard.addDot();
                break;
            case 1:
                playerBattingScoreCard.addSingle();
                scoreCard.changeStrike();
                break;
            case 2:
                playerBattingScoreCard.addDouble();
                break;
            case 3:
                playerBattingScoreCard.addTriple();
                scoreCard.changeStrike();
                break;
            case 4:
                playerBattingScoreCard.addFours();
                break;
            case 6:
                playerBattingScoreCard.addSixes();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean shouldCount() {
        return true;
    }
}
