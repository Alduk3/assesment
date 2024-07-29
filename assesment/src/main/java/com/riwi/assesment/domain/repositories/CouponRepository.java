package com.riwi.assesment.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.assesment.domain.entities.Coupons;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, String>{
    
}
