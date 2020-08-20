package com.skillsup.soccer.dto;

public class Player {

    private final Long id;
    private final String name;
    private final String position;

    public Player() {
        this.id = null;
        this.name = null;
        this.position = null;
    }

    public Player(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Player(String name, String position) {
        this.id = null;
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                "}\n";
    }
}
