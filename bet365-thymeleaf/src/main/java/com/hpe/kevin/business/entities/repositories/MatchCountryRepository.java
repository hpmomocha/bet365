package com.hpe.kevin.business.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMMatchCountry;

public interface MatchCountryRepository extends JpaRepository<TMMatchCountry, Integer> {

}
