package com.hpe.kevin.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMGlobalMatch;


public interface GlobalMatchRepository extends JpaRepository<TMGlobalMatch, Integer> {
	List<TMGlobalMatch> findAll();
}
