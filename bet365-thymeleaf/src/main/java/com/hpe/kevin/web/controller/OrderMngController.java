package com.hpe.kevin.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpe.kevin.business.entities.BetOrder;
import com.hpe.kevin.business.entities.OrderSearchCondition;
import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCategory;
import com.hpe.kevin.business.entities.TMMatchCountry;
import com.hpe.kevin.business.entities.TMMatchTeam;
import com.hpe.kevin.business.entities.TOrderDetail;
import com.hpe.kevin.business.services.MasterDataService;

@Controller
public class OrderMngController {
	@Autowired
	MasterDataService masterDataService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderMngController.class);
	
	private static final String OPTION_PLEASE_SELECT = "请选择";
	
    /**
     * 取得所有赛事区域
     * @return
     */
    @ModelAttribute("allGlobalMatch")
    public List<TMGlobalMatch> populateGlobalMatch() {
    	List<TMGlobalMatch> result = masterDataService.getAllGlobalMatch();
    	result.add(0, new TMGlobalMatch(0, OPTION_PLEASE_SELECT));
        return result;
    }
    
    /**
     * 取得所有赛事所属国/组织
     * @return
     */
    @ModelAttribute("allMatchCountry")
    public List<TMMatchCountry> populateMatchCountry() {
    	List<TMMatchCountry> result = masterDataService.getAllMatchCountry();
    	result.add(0, new TMMatchCountry(0, OPTION_PLEASE_SELECT));
        return result;
    }
    
    /**
     * 取得所有投注对象赛事
     * @return
     */
    @ModelAttribute("allBetTargetMatch")
    public List<TMBetTgtMatch> populateBetTargetMatch() {
    	List<TMBetTgtMatch> result = masterDataService.getAllBetTgtMatch();
    	result.add(0, new TMBetTgtMatch(0, OPTION_PLEASE_SELECT));
        return result;
    }
    
    /**
     * 取得所有早期投注类型
     * @return
     */
    @ModelAttribute("allEarlyStageBetType")
    public List<TMEarlyStageBetType> populateEarlyStageBetType() {
    	List<TMEarlyStageBetType> result = masterDataService.getAllEarlyStageBetType();
    	result.add(0, new TMEarlyStageBetType(0, OPTION_PLEASE_SELECT));
        return result;
    }
    
    /**
     * 取得所有赛事类型
     * @return
     */
    @ModelAttribute("allMatchCategory")
    public List<TMMatchCategory> populateMatchCategory() {
    	List<TMMatchCategory> result = masterDataService.getAllMatchCategory();
        return result;
    }
    
    /**
     * 取得所有球队
     * @return
     */
    @ModelAttribute("allMatchTeam")
    public List<TMMatchTeam> populateMatchTeam() {
    	List<TMMatchTeam> result = masterDataService.getAllMatchTeam();
    	result.add(0, new TMMatchTeam(0, OPTION_PLEASE_SELECT));
        return result;
    }
    
    @RequestMapping({"/","/order"})
    public String orderMngInit(final BetOrder betOrder) {
        return "ordermng";
    }
    
    @RequestMapping(value="/order", params={"addRow"})
    public String addRow(final BetOrder betOrder, final BindingResult bindingResult) {
    	betOrder.getOrderDetailList().add(new TOrderDetail());
        return "ordermng";
    }
    
    @RequestMapping(value="/order", params={"removeRow"})
    public String removeRow(final BetOrder betOrder, final BindingResult bindingResult, final HttpServletRequest req) {
    	final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
    	betOrder.getOrderDetailList().remove(rowId.intValue());
        return "ordermng";
    }
	
	@RequestMapping(value="/order", params={"save"})
	public String saveOrder(final BetOrder betOrder, final BindingResult bindingResult, final ModelMap model) {
//        if (bindingResult.hasErrors()) {
//            return "ordermng";
//        }
        masterDataService.saveOrder(betOrder);
        model.clear();
		return "redirect:/order";
	}
	
	@RequestMapping(value="/orderList")
	public String orderList(final OrderSearchCondition condition, Model model) {
//		model.addAttribute("allOrders", masterDataService.searchOrder(null));
		
		return "orderlist";
	}
	
	@RequestMapping(value="/searchOrder")
	public String searchOrder(final OrderSearchCondition condition, Model model) {
		model.addAttribute("allOrders", masterDataService.searchOrder(condition));
		
		return "orderlist";
	}
}
