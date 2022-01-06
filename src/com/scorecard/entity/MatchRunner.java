package com.scorecard.entity;

import java.util.Scanner;

public class MatchRunner {

    private Scanner scanner;

    public MatchRunner() {
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        try {
            Match match = getMatchConfig();
            if (match != null) {
                match.addBattingOrder(scanner, match.getTeam1());
                match.playFirstInning(scanner);
                match.addBattingOrder(scanner, match.getTeam2());
                match.playSecondInning(scanner);
                match.printResult();
            }
            else {
                System.out.println("No match played");
            }
        }
        finally {
            scanner.close();
        }
    }

    public Match getMatchConfig() {
        try {
            int totalPlayers = 0;
            int totalOvers = 0;
            System.out.print("No. of players for each team: ");
            totalPlayers = scanner.nextInt();
            System.out.print("No. of overs: ");
            totalOvers = scanner.nextInt();
            return MatchBuilder
                    .newBuilder()
                    .setTotalOvers(totalOvers)
                    .setTotalPlayers(totalPlayers)
                    .addTeam1("team 1")
                    .addTeam2("team 2")
                    .build();
        } catch (Exception e) {
            System.out.println("Error thrown : " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            MatchRunner matchRunner = new MatchRunner();
            matchRunner.play();
        }
        catch (Exception e) {
            System.out.println("Error thrown from runner. Please try again.");
        }
    }
}
