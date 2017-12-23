package com.hpe.kevin.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCategory;
import com.hpe.kevin.business.entities.TMMatchCountry;
import com.hpe.kevin.business.entities.repositories.BetTgtMatchRepository;
import com.hpe.kevin.business.entities.repositories.EarlyStageBetTypeRepository;
import com.hpe.kevin.business.entities.repositories.GlobalMatchRepository;
import com.hpe.kevin.business.entities.repositories.MatchCategoryRepository;
import com.hpe.kevin.business.entities.repositories.MatchCountryRepository;

@Service
public class MasterDataServiceImpl implements MasterDataService {
	@Autowired
	GlobalMatchRepository globalMatchRepository;
	
	@Autowired
	MatchCountryRepository matchCountryRepository;
	
	@Autowired
	BetTgtMatchRepository betTgtMatchRepository;
	
	@Autowired
	EarlyStageBetTypeRepository betTypeRepository;
	
	@Autowired
	MatchCategoryRepository matchCategoryRepository;

	@Override
	public List<TMGlobalMatch> getAllGlobalMatch() {
		return globalMatchRepository.findAll();
	}

	@Override
	public List<TMBetTgtMatch> getAllBetTgtMatch() {
		return betTgtMatchRepository.findAll();
	}

	@Override
	public List<TMEarlyStageBetType> getAllEarlyStageBetType() {
		return betTypeRepository.findAll();
	}
	
	@Override
	public List<TMMatchCountry> getAllMatchCountry() {
		return matchCountryRepository.findAll();
	}

	@Override
	public List<TMMatchCategory> getAllMatchCategory() {
		return matchCategoryRepository.findAll();
	}
}
