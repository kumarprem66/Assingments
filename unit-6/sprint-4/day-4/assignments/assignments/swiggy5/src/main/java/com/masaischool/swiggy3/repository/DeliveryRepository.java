package com.masaischool.swiggy3.repository;

import com.masaischool.swiggy3.entity.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryPartner,Integer> {
}
