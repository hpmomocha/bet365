package com.hpe.kevin.business.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hpe.kevin.business.entities.BetOrder;
import com.hpe.kevin.business.entities.OrderSearchCondition;
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
import com.hpe.kevin.business.entities.repositories.OrderDetailRepository;
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
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

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
        order.setOrderDate(betOrder.getOrderDate());

		for (TOrderDetail orderDetail: betOrder.getOrderDetailList()) {
			orderDetail.setTOrder(order);
			orderDetail.setTMMatchSeason(orderDetail.getTMBetTgtMatch().getTMMatchSeason());
			orderDetail.setIsClosed(orderDetail.getIsClosedCheckbox()?"1" : "0");
			order.getOrderDetails().add(orderDetail);
		}
		
		return order;
	}
	
	public List<TMMatchCountry> getMatchCountryByGlobalMatchId(TMGlobalMatch globalMatch) {
		return matchCountryRepository.findByTMGlobalMatch(globalMatch);
	}
	
	public List<TMBetTgtMatch> getBetTgtMatchByMatchCountryId(TMMatchCountry matchCountry) {
		return betTgtMatchRepository.findByTMMatchCountry(matchCountry);
	}
	
	public List<TMMatchTeam> getMatchTeamByMatchId(TMBetTgtMatch betTgtMatch) {
		return matchTeamRepository.findByTMBetTgtMatch(betTgtMatch);
	}
	
	public List<BetOrder> searchOrder(OrderSearchCondition condition) {
		List<TOrder> orderList = orderRepository.findAll(new Specification<TOrder>() {
			
			@Override
			public Predicate toPredicate(Root<TOrder> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				
				if (condition.getBetTypeId() != null && !"0".equals(condition.getBetTypeId())) {
					
					TMEarlyStageBetType betType = new TMEarlyStageBetType();
					betType.setBetTypeId(Integer.valueOf(condition.getBetTypeId()));
					Join<TOrderDetail, TOrder> orderDetailJoin = root.join("orderDetails", JoinType.LEFT);
					list.add(criteriaBuilder.equal(orderDetailJoin.get("tMEarlyStageBetType"), betType));
				}
				
				if (!StringUtils.isEmpty(condition.getTeamName())) {
					TMMatchTeam matchTeam = new TMMatchTeam();
					matchTeam.setTeamShortName(condition.getTeamName());
					Join<TMMatchTeam, TOrder> matchTeamJoin = root.join("orderDetails", JoinType.LEFT);
					list.add(criteriaBuilder.equal(matchTeamJoin.get("tMMatchTeam").get("teamShortName"), matchTeam.getTeamShortName()));
				}
				
				Predicate[] p = new Predicate[list.size()];
				query.where(criteriaBuilder.and(list.toArray(p)));
				query.groupBy(root.get("orderId"));
				
				return null;
			}
		});

		List<BetOrder> betOrderList = new ArrayList<BetOrder>();
		for (TOrder order : orderList) {
			BetOrder betOrder = new BetOrder();
			betOrder.getOrderDetailList().addAll((order.getOrderDetails()));
			betOrder.setOrderDate(order.getOrderDate().toString());
			betOrder.setBetTgtMatches(order.getBetTgtMatches());
			betOrder.setOrderPrpl(order.getOrderPrpl());
			betOrder.setEstmBonus(order.getEstmBonus());
			betOrderList.add(betOrder);
		}
		return betOrderList;
	}
}
