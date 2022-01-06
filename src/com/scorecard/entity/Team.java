package com.scorecard.entity;

import java.util.*;

public class Team {
    private String name;
    private List<Player> players;
    private int nextPlayer;
    private ScoreCard scoreCard;

    public Team(String name) {
        this.name = name;
        this.nextPlayer = 2;
        this.players = new ArrayList<>();
    }

    public void initScoreCard(int totalOvers, int totalWickets) {
        if (this.players.size() < 2) throw new RuntimeException("Match can't be played");
        this.scoreCard = new ScoreCard(totalOvers * 6, totalWickets);
        this.scoreCard.setStriker(this.players.get(0));
        this.scoreCard.setNonStriker(this.players.get(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    public Player getNextPlayer() {
        if (nextPlayer < players.size()) {
            return this.players.get(nextPlayer++);
        }
        return null;
    }

    public ScoreCard getScoreCard() {
        return scoreCard;
    }
}
