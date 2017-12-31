package com.hpe.kevin.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCountry;
import com.hpe.kevin.business.entities.TMMatchTeam;
import com.hpe.kevin.business.services.MasterDataService;


@RestController
@RequestMapping("/order")
public class OrderMngRestController {
	@Autowired
	MasterDataService masterDataService;

	private static final Logger logger = LoggerFactory.getLogger(OrderMngRestController.class);

	@PostMapping(value = "/getMatchCountry")
	@ResponseBody
	public List<TMMatchCountry> getMatchCountryByGlobalMatchId(@RequestBody TMGlobalMatch globalMatch) {
		List<TMMatchCountry> result = masterDataService.getMatchCountryByGlobalMatchId(globalMatch);
		
		return result;
	}
	
	@PostMapping(value = "/getBetTgtMatch")
	@ResponseBody
	public List<TMBetTgtMatch> getBetTgtMatchByMatchCountryId(@RequestBody TMMatchCountry matchCountry) {
		List<TMBetTgtMatch> result = masterDataService.getBetTgtMatchByMatchCountryId(matchCountry);
		
		return result;
	}
	
	@PostMapping(value = "/getMatchTeam")
	@ResponseBody
	public List<TMMatchTeam> getMatchTeamByMatchId(@RequestBody TMBetTgtMatch betTgtMatch) {
		List<TMMatchTeam> result = masterDataService.getMatchTeamByMatchId(betTgtMatch);
		
		return result;
	}
}
