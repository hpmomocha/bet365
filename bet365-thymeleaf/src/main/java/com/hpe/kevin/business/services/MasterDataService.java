package com.hpe.kevin.business.services;

import java.util.List;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMGlobalMatch;

public interface MasterDataService {
	public List<TMGlobalMatch> getAllGlobalMatch();
	
	public List<TMBetTgtMatch> getAllBetTgtMatch();
	
//	public List<TMEarlyStageBetType> getAllEarlyStageBetType();
}
