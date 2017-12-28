package com.hpe.kevin.business.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.kevin.business.entities.BetOrder;
import com.hpe.kevin.business.entities.TMBetTgtMatch;
import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMGlobalMatch;
import com.hpe.kevin.business.entities.TMMatchCategory;
import com.hpe.kevin.business.entities.TMMatchCountry;
import com.hpe.kevin.business.entities.TMMatchTeam;
import com.hpe.kevin.business.entities.TOrder;
import com.hpe.kevin.business.entities.TOrderDetail;
import com.hpe.kevin.business.entities.TUser;
import com.hpe.kevin.business.entities.repositories.BetTgtMatchRepository;
import com.hpe.kevin.business.entities.repositories.EarlyStageBetTypeRepository;
import com.hpe.kevin.business.entities.repositories.GlobalMatchRepository;
import com.hpe.kevin.business.entities.repositories.MatchCategoryRepository;
import com.hpe.kevin.business.entities.repositories.MatchCountryRepository;
import com.hpe.kevin.business.entities.repositories.MatchTeamRepository;
import com.hpe.kevin.business.entities.repositories.OrderRepository;

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
	
	@Autowired
	MatchTeamRepository matchTeamRepository;
	
	@Autowired
	OrderRepository orderRepository;

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
	
	@Override
	public List<TMMatchTeam> getAllMatchTeam() {
		return matchTeamRepository.findAll();
	}

	@Override
	public void saveOrder(BetOrder betOrder) {
		orderRepository.save(copyOrderInfo(betOrder));
	}
	
	@Override
	public Optional<TMBetTgtMatch> findBetTgtMatchById(int matchId) {
		return betTgtMatchRepository.findById(matchId);
	}
	
	private TOrder copyOrderInfo(BetOrder betOrder) {
		TOrder order = new TOrder();
		
		// 投注本金
		order.setOrderPrpl(betOrder.getOrderPrpl());
		// 过关方式 (X串Y)
		order.setBetTgtMatches(betOrder.getBetTgtMatches());
		// 预计返奖
		order.setEstmBonus(betOrder.getEstmBonus());
		// 中奖
		order.setIsWin(betOrder.getIsWin()?"1":"0");
		// 结算济
		order.setIsClosed(betOrder.getIsClosed()?"1":"0");
		// 手动结算济
		order.setIsClosedManually(betOrder.getIsClosedManually()?"1":"0");
		// 用户ID
		order.setTUser(new TUser(1, "hpmomocha"));
		// 投注日期
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.parse(betOrder.getOrderDate(), formatter);
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        order.setOrderDate(Date.from(zdt.toInstant()));

		for (TOrderDetail orderDetail: betOrder.getOrderDetailList()) {
			orderDetail.setTOrder(order);
			orderDetail.setTMMatchSeason(orderDetail.getTMBetTgtMatch().getTMMatchSeason());
			order.getOrderDetails().add(orderDetail);
		}
		
		return order;
	}
	
	public List<TMMatchCountry> getMatchCountryByGlobalMatchId(TMGlobalMatch globalMatch) {
		return matchCountryRepository.findByTMGlobalMatch(globalMatch);
	}
}
