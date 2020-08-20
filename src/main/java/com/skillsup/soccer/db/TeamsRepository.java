package com.skillsup.soccer.db;

import com.skillsup.soccer.db.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamsRepository extends JpaRepository<TeamEntity, Long> {

    @Query(value = "SELECT * FROM teams t ", nativeQuery = true)
    List<TeamEntity> findAllOrdersUsingNativeQuery();

    @Query(value = "SELECT * FROM teams t WHERE t.id In (SELECT team_id FROM players GROUP BY team_id HAVING COUNT(*) >= :count)", nativeQuery = true)
    List<TeamEntity> findTeamsByCount(@Param("count") int count);

    @Query(value = "SELECT * FROM teams t JOIN players p ON t.id = p.team_id AND t.name = :name", nativeQuery = true)
    TeamEntity findByName(@Param("name") String name);

}
