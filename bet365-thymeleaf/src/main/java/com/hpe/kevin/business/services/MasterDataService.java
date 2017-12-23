package com.hpe.kevin.business.services;

import java.util.List;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCategory;
import com.hpe.kevin.business.entities.TMMatchCountry;

public interface MasterDataService {
	public List<TMGlobalMatch> getAllGlobalMatch();
	
	public List<TMBetTgtMatch> getAllBetTgtMatch();
	
	public List<TMEarlyStageBetType> getAllEarlyStageBetType();
	
	public List<TMMatchCountry> getAllMatchCountry();
	
	public List<TMMatchCategory> getAllMatchCategory();
}
