package com.hpe.kevin.business.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TMEarlyStageBetType;
import com.hpe.kevin.business.entities.TMMatchTeam;
import com.hpe.kevin.business.entities.TOrderDetail;

public interface OrderDetailRepository extends JpaRepository<TOrderDetail, Integer> {
	public List<TOrderDetail> findByTMEarlyStageBetTypeAndTMMatchTeam(TMEarlyStageBetType tMEarlyStageBetType, TMMatchTeam tMMatchTeam);
}