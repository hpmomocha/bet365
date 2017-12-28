package com.hpe.kevin.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCountry;

public interface MatchCountryRepository extends JpaRepository<TMMatchCountry, Integer> {
	public List<TMMatchCountry> findByTMGlobalMatch(TMGlobalMatch tMGlobalMatch);
}
