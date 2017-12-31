package com.hpe.kevin.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMMatchTeam;

public interface MatchTeamRepository extends JpaRepository<TMMatchTeam, Integer> {
	public List<TMMatchTeam> findByTMBetTgtMatch(TMBetTgtMatch tMBetTgtMatch);
}
