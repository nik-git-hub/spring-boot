package com.skillsup.soccer.converters;

import com.skillsup.soccer.db.entity.PlayerEntity;
import com.skillsup.soccer.dto.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerConverter {

    public static List<Player> toPlayers(List<PlayerEntity> entities) {
        return entities.stream().map(PlayerConverter::toPlayer).collect(Collectors.toList());
    }

    public static Player toPlayer(PlayerEntity entity) {
        return new Player(entity.getId(), entity.getName(), entity.getPosition());
    }

    public static List<PlayerEntity> toPlayerEntities(List<Player> players) {
        return players.stream().map(PlayerConverter::toPlayerEntity).collect(Collectors.toList());
    }

    public static PlayerEntity toPlayerEntity(Player player) {
        return new PlayerEntity(player.getId(), player.getName(), player.getPosition());
    }

}
