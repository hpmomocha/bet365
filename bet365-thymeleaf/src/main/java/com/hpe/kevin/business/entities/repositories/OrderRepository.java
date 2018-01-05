package com.hpe.kevin.business.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hpe.kevin.business.entities.TOrder;

public interface OrderRepository extends JpaRepository<TOrder, Integer>, JpaSpecificationExecutor<TOrder> {
}