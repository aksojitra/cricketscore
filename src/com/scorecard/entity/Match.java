package com.scorecard.entity;

import java.util.*;

public class Match {
    private int totalOvers;
    private int totalPlayers;
    private Team team1;
    private Team team2;

    public Match() {
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTotalOvers() {
        return totalOvers;
    }

    public void setTotalOvers(int totalOvers) {
        this.totalOvers = totalOvers;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public void addBattingOrder(Scanner scanner, Team team) {
        System.out.println("Batting Order for team : " + team.getName());
        try {
            for (int playerCount = 0; playerCount < totalPlayers; playerCount++) {
                String name = scanner.next();
                team.addPlayer(new Player(name));
            }
            team.initScoreCard(totalOvers, totalPlayers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void playFirstInning(Scanner scanner) {
        try {
            ScoreCard scoreCard = team1.getScoreCard();
            for (int overCount = 0; overCount < totalOvers; overCount++) {
                if (this.shouldStopFirstInning(scoreCard)) {
                    break;
                }
                System.out.println("Over : " + (overCount + 1));
                int ballCount = 0;
                while (ballCount < 6) {
                    if (this.shouldStopFirstInning(scoreCard)) {
                        break;
                    }
                    String ballStr = scanner.next();
                    Ball ball = createBall(ballStr);
                    ball.updateScoreCard(team1);
                    if (ball.shouldCount()) ballCount++;
                }
                printTeamBattingScoreCard(team1);
                printTotalScoreCard(scoreCard);
                scoreCard.changeStrike();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private boolean shouldStopFirstInning(ScoreCard scoreCard) {
        if (scoreCard.getWicket() >= totalPlayers - 1) return true;
        return scoreCard.getLeftBalls() <= 0;
    }

    public void playSecondInning(Scanner scanner) {
        try {
            ScoreCard team1ScoreCard = team1.getScoreCard();
            ScoreCard team2ScoreCard = team2.getScoreCard();
            for (int overCount = 0; overCount < totalOvers; overCount++) {
                if (this.shouldStopSecondInning(team1ScoreCard, team2ScoreCard)) {
                    break;
                }
                System.out.println("Over : " + (overCount + 1));
                int ballCount = 0;
                while (ballCount < 6) {
                    if (this.shouldStopSecondInning(team1ScoreCard, team2ScoreCard)) {
                        break;
                    }
                    String ballStr = scanner.next();
                    Ball ball = createBall(ballStr);
                    ball.updateScoreCard(team2);
                    if (ball.shouldCount()) ballCount++;
                }
                printTeamBattingScoreCard(team2);
                printTotalScoreCard(team2ScoreCard);
                team2ScoreCard.changeStrike();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private boolean shouldStopSecondInning(
            ScoreCard team1ScoreCard,
            ScoreCard team2ScoreCard
    ) {
        if (team2ScoreCard.getRun() > team1ScoreCard.getRun()) return true;
        if (team2ScoreCard.getWicket() >= totalPlayers - 1) return true;
        return team2ScoreCard.getLeftBalls() <= 0;
    }

    private Ball createBall(String ball) {
        if (ball.equalsIgnoreCase("W")) {
            return new NormalBall(0, true);
        }
        if (ball.equalsIgnoreCase("Wd")) {
            return new WideBall(0);
        }
        if (ball.equalsIgnoreCase("N")) {
            return new NoBall(0, false);
        }
        try {
            int run = Integer.parseInt(ball);
            return new NormalBall(run, false);
        }
        catch (Exception e) {
            throw new RuntimeException("Please enter valid score for ball.");
        }
    }

    public void printResult() {
        ScoreCard team1ScoreCard = team1.getScoreCard();
        ScoreCard team2ScoreCard = team2.getScoreCard();
        if (team2ScoreCard.getRun() > team1ScoreCard.getRun()) {
            System.out.println("Team 2 won the match by " + team2ScoreCard.getWicket() + " wickets");
        }
        else {
            int runsLeft = team1ScoreCard.getRun() - team2ScoreCard.getRun();
            System.out.println("Team 1 won the match by " + runsLeft + " runs");
        }
    }

    private void printTeamBattingScoreCard(Team team) {
        System.out.println("Scorecard for Team " + team.getName());
        System.out.println("Player Name\t\tScore\t\t4s\t\t6s\t\tBalls");
        ScoreCard scoreCard = team.getScoreCard();
        for (Player player : team.getPlayers()) {
            PlayerBattingScoreCard playerBattingScoreCard = player.getPlayerBattingScoreCard();
            String playerName = player.getName();
            if (player.equals(scoreCard.getStriker()) || player.equals(scoreCard.getNonStriker())) {
                playerName += "*";
            }
            System.out.println(
                    playerName
                            + "\t\t"
                            + playerBattingScoreCard.getRun()
                            + "\t\t"
                            + playerBattingScoreCard.getFours()
                            + "\t\t"
                            + playerBattingScoreCard.getSixes()
                            + "\t\t"
                            + playerBattingScoreCard.getBalls()
            );
        }
    }

    private void printTotalScoreCard(ScoreCard scoreCard) {
        System.out.println("Total: " + scoreCard.getRun() + "/" + scoreCard.getWicket());
        int totalBallsCompleted = (scoreCard.getTotalBalls() - scoreCard.getLeftBalls());
        int overs = totalBallsCompleted / 6;
        int ballInCurrentOver = totalBallsCompleted % 6;
        String totalOvers = overs + "." + ballInCurrentOver;
        System.out.println("Overs: " + totalOvers);
    }

    private void printBowlingScores() {}
}
