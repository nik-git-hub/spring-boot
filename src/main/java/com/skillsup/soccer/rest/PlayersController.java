package com.skillsup.soccer.rest;

import com.skillsup.soccer.dto.Player;
import com.skillsup.soccer.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "players")
public class PlayersController {

    private final PlayerService playerService;

    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("{id}")
    public Player findById(@PathVariable(value = "id") Long id) {
        return playerService.findPlayerById(id);
    }

    @DeleteMapping("{id}")
    public void deletePlayer(@PathVariable(value = "id") Long id) {
        playerService.deletePlayer(id);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @GetMapping("pos")
    public List<Player> findPlayersByTeamNameAndPosition(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "pos", required = false) String position) {
        return playerService.findPlayersByTeamNameAndPosition(name, position);
    }

}
