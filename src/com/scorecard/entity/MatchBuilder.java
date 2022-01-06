package com.scorecard.entity;

public class MatchBuilder {
    private Match match;

    private MatchBuilder() {
        this.match = new Match();
    }

    public static MatchBuilder newBuilder() {
        return new MatchBuilder();
    }

    public MatchBuilder setTotalPlayers(int totalPlayers) {
        this.match.setTotalPlayers(totalPlayers);
        return this;
    }

    public MatchBuilder setTotalOvers(int totalOvers) {
        this.match.setTotalOvers(totalOvers);
        return this;
    }

    public MatchBuilder addTeam1(String name) {
        this.match.setTeam1(new Team(name));
        return this;
    }

    public MatchBuilder addTeam2(String name) {
        this.match.setTeam2(new Team(name));
        return this;
    }

    public Match build() {
        return this.match;
    }
}
