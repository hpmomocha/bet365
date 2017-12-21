package com.hpe.kevin.business.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hpe.kevin.business.entities.TOrderDetail;
import com.hpe.kevin.business.entities.TOrderDetailId;

public interface OrderDetailRepository extends JpaRepository<TOrderDetail, TOrderDetailId> {

}
