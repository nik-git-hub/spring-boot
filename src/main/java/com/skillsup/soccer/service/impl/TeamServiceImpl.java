package com.skillsup.soccer.service.impl;

import com.skillsup.soccer.converters.TeamConverter;
import com.skillsup.soccer.db.TeamsRepository;
import com.skillsup.soccer.db.entity.TeamEntity;
import com.skillsup.soccer.dto.Team;
import com.skillsup.soccer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.skillsup.soccer.converters.TeamConverter.*;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private final TeamsRepository teamsRepository;

    public TeamServiceImpl(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @Override
    public List<Team> findAll() {
        return toTeams(teamsRepository.findAll());
    }

    @Override
    public Team findTeamById(Long id) {
        Optional<TeamEntity> optionalTeam = teamsRepository.findById(id);
        return optionalTeam.map(TeamConverter::toTeam).orElse(null);
    }

    @Override
    public void deleteTeam(Long id) {
        teamsRepository.deleteById(id);
    }

    @Override
    public Team createTeam(Team team) {
        TeamEntity teamEntity = toTeamEntity(team);
        TeamEntity savedTeam = teamsRepository.save(teamEntity);
        return toTeam(savedTeam);
    }

    @Override
    public Team updateTeam(Team team) {
        TeamEntity teamEntity = toTeamEntity(team);
        TeamEntity savedTeam = teamsRepository.saveAndFlush(teamEntity);
        return toTeam(savedTeam);
    }

    @Override
    public List<Team> findTeamsByCount(Integer playersCount) {
        return toTeams(teamsRepository.findTeamsByCount(playersCount));
    }

    @Override
    public Team findTeamByName(String name) {
        return toTeam(teamsRepository.findByName(name));
    }

}
