package com.skillsup.soccer.db.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @JoinColumn(name = "team_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PlayerEntity> playerEntities;

    public TeamEntity() {
    }

    public TeamEntity(Long id, String name, String country, String city, List<PlayerEntity> playerEntities) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.playerEntities = playerEntities;
    }

    public TeamEntity(String name, String country, String city, List<PlayerEntity> playerEntities) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.playerEntities = playerEntities;
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

    public List<PlayerEntity> getPlayerEntities() {
        return playerEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPlayerEntities(List<PlayerEntity> playerEntities) {
        this.playerEntities = playerEntities;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", playerEntities=" + playerEntities + "}\n";
    }
}
