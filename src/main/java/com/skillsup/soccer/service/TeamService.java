package com.skillsup.soccer.service;

import com.skillsup.soccer.dto.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team findTeamById(Long id);

    void deleteTeam(Long id);

    Team createTeam(Team team);

    Team updateTeam(Team team);

    List<Team> findTeamsByCount(Integer playersCount);

    Team findTeamByName(String name);

}