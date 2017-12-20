package com.hpe.kevin.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.repositories.GlobalMatchRepository;

@Service
public class MasterDataServiceImpl implements MasterDataService {
	@Autowired
	GlobalMatchRepository globalMatchRepository;

	@Override
	public List<TMGlobalMatch> getAllGlobalMatch() {
		return globalMatchRepository.findAll();
	}
	
}
