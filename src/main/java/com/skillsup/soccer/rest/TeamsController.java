package com.skillsup.soccer.rest;

import com.skillsup.soccer.dto.Team;
import com.skillsup.soccer.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teams")
public class TeamsController {

    private final TeamService teamService;

    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("{id}")
    public Team findById(@PathVariable(value = "id") Long id) {
        return teamService.findTeamById(id);
    }

    @DeleteMapping("{id}")
    public void deleteTeam(@PathVariable(value = "id") Long id) {
        teamService.deleteTeam(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping
    public Team updateTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @GetMapping("count")
    public List<Team> findTeamsWherePlayersFromCount(@RequestParam(value = "count", required = false) Integer count) {
        return teamService.findTeamsByCount(count);
    }

    @GetMapping("name")
    public Team findTeamByName(@RequestParam(value = "name", required = false) String name) {
        return teamService.findTeamByName(name);
    }

}
