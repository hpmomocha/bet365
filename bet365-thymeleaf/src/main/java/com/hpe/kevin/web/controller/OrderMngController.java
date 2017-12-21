package com.hpe.kevin.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TOrder;
import com.hpe.kevin.business.services.MasterDataService;

@Controller
public class OrderMngController {
	@Autowired
	MasterDataService masterDataService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderMngController.class);
	
    @ModelAttribute("allGlobalMatch")
    public List<TMGlobalMatch> populateGlobalMatch() {
    	List<TMGlobalMatch> result = masterDataService.getAllGlobalMatch();
        return result;
    }
    
    /**
     * 取得所有投注对象赛事
     * @return
     */
    @ModelAttribute("allBetTgtMatch")
    public List<TMBetTgtMatch> populateAllBetTgtMatch() {
    	List<TMBetTgtMatch> result = masterDataService.getAllBetTgtMatch();
        return result;
    }
    
	@RequestMapping(value = "/order")
	public String addOrderInit(Model model) {
		model.addAttribute("tOrder", new TOrder());
		return "ordermng";
	}
	
//	@RequestMapping(value="/saveOrder")
//	public String saveOrder(final TOrder tOrder, final BindingResult bindingResult, ModelMap model) {
//		return "redirect:/ordermng";
//	}
}
