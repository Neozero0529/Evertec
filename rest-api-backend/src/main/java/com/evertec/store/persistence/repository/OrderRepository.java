package com.evertec.store.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evertec.store.persistence.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
