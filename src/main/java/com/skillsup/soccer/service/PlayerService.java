package com.skillsup.soccer.service;

import com.skillsup.soccer.dto.Player;

import java.util.List;

public interface PlayerService {

    Player findPlayerById(Long id);

    void deletePlayer(Long id);

    Player createPlayer(Player player);

    Player updatePlayer(Player player);

    List<Player> findPlayersByTeamNameAndPosition(String name, String position);
}
