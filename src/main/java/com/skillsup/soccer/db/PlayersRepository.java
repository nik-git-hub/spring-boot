package com.skillsup.soccer.db;

import com.skillsup.soccer.db.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayersRepository extends JpaRepository<PlayerEntity, Long> {

    @Query(value = "SELECT p.* FROM teams t JOIN players p ON t.id = p.team_id AND t.name = :name AND p.position = :position", nativeQuery = true)
    List<PlayerEntity> findByTeamNameAndPosition(@Param("name") String name, @Param("position") String position);
}
