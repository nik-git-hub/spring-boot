package com.skillsup.soccer.converters;

import com.skillsup.soccer.db.entity.TeamEntity;
import com.skillsup.soccer.dto.Team;

import java.util.List;
import java.util.stream.Collectors;

import static com.skillsup.soccer.converters.PlayerConverter.toPlayerEntities;
import static com.skillsup.soccer.converters.PlayerConverter.toPlayers;

public class TeamConverter {
    public static List<Team> toTeams(List<TeamEntity> entities) {
        return entities.stream().map(TeamConverter::toTeam).collect(Collectors.toList());
    }

    public static Team toTeam(TeamEntity entity) {
        return new Team(
                entity.getId(),
                entity.getName(),
                entity.getCountry(),
                entity.getCity(),
                toPlayers(entity.getPlayerEntities())
        );
    }

    public static TeamEntity toTeamEntity(Team team) {
        return new TeamEntity(team.getName(),
                team.getCountry(),
                team.getCity(),
                toPlayerEntities(team.getPlayers()));
    }

}
