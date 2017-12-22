package com.hpe.kevin.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCountry;
import com.hpe.kevin.business.entities.TOrder;
import com.hpe.kevin.business.entities.TUser;
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
    
    @ModelAttribute("allMatchCountry")
    public List<TMMatchCountry> populateMatchCountry() {
    	List<TMMatchCountry> result = masterDataService.getAllMatchCountry();
        return result;
    }
    
    @ModelAttribute("allBetTargetMatch")
    public List<TMBetTgtMatch> populateBetTargetMatch() {
    	List<TMBetTgtMatch> result = masterDataService.getAllBetTgtMatch();
        return result;
    }
    
    @ModelAttribute("allEarlyStageBetType")
    public List<TMEarlyStageBetType> populateEarlyStageBetType() {
    	List<TMEarlyStageBetType> result = masterDataService.getAllEarlyStageBetType();
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
    
    @RequestMapping({"/","/order"})
    public String orderMngInit(final TOrder order) {
    	order.setUser(new TUser(1, "hpmomocha"));
//    	model.addAttribute("order", order);
        return "ordermng";
    }
	
//    @RequestMapping(value="/order", params={"addRow"})
//    public String addRow(final TOrder order, final BindingResult bindingResult) {
//    	order.getOrderDetailList().add(new TOrderDetail());
//        return "ordermng";
//    }
//	
//	@RequestMapping(value="/order", params={"save"})
//	public String saveOrder(final TOrder order, final BindingResult bindingResult, ModelMap model) {
//		return "redirect:/ordermng";
//	}
}
