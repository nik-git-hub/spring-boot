package com.skillsup.soccer.dto;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private final Long id;
    private final String name;
    private final String country;
    private final String city;
    private final List<Player> players;

    public Team() {
        this.id = null;
        this.name = null;
        this.country = null;
        this.city = null;
        this.players = new ArrayList<>();
    }

    public Team(Long id, String name, String country, String city,  List<Player> players) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.players = players;
    }

    public Team(String name, String country, String city,  List<Player> players) {
        this.id = null;
        this.name = name;
        this.country = country;
        this.city = city;
        this.players = players;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", players=" + players +
                "}\n";
    }
}
