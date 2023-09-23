package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.springproject.entities.DeliveryPartner;

public interface DeliveryRepository extends JpaRepository<DeliveryPartner, Integer> {

}
