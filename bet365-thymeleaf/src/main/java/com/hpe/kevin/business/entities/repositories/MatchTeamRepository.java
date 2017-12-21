package com.hpe.kevin.business.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMMatchTeam;
import com.hpe.kevin.business.entities.TMMatchTeamId;

public interface MatchTeamRepository extends JpaRepository<TMMatchTeam, TMMatchTeamId> {

}
