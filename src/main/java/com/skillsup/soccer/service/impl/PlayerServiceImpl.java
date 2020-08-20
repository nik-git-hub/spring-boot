package com.skillsup.soccer.service.impl;

import com.skillsup.soccer.converters.PlayerConverter;
import com.skillsup.soccer.db.PlayersRepository;
import com.skillsup.soccer.db.entity.PlayerEntity;
import com.skillsup.soccer.dto.Player;
import com.skillsup.soccer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.skillsup.soccer.converters.PlayerConverter.*;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private final PlayersRepository playersRepository;

    public PlayerServiceImpl(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    @Override
    public Player findPlayerById(Long id) {
        Optional<PlayerEntity> optionalTeam = playersRepository.findById(id);
        return optionalTeam.map(PlayerConverter::toPlayer).orElse(null);
    }

    @Override
    public void deletePlayer(Long id) {
        playersRepository.deleteById(id);
    }

    @Override
    public Player createPlayer(Player player) {
        PlayerEntity playerEntity = toPlayerEntity(player);
        PlayerEntity savedPlayer = playersRepository.save(playerEntity);
        return toPlayer(savedPlayer);
    }

    @Override
    public Player updatePlayer(Player player) {
        PlayerEntity playerEntity = toPlayerEntity(player);
        PlayerEntity savedPlayer = playersRepository.saveAndFlush(playerEntity);
        return toPlayer(savedPlayer);
    }

    @Override
    public List<Player> findPlayersByTeamNameAndPosition(String name, String position) {
        return toPlayers(playersRepository.findByTeamNameAndPosition(name, position));
    }

}
