package com.hpe.kevin.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMMatchCountry;

public interface BetTgtMatchRepository extends JpaRepository<TMBetTgtMatch, Integer> {
	public List<TMBetTgtMatch> findByTMMatchCountry(TMMatchCountry tMMatchCountry);
}
