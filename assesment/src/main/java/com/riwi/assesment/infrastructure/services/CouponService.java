package com.riwi.assesment.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.assesment.api.dto.request.CouponRequest;
import com.riwi.assesment.api.dto.response.CouponResponse;
import com.riwi.assesment.domain.entities.Coupons;
import com.riwi.assesment.domain.repositories.CouponRepository;
import com.riwi.assesment.infrastructure.abstract_services.ICouponService;
import com.riwi.assesment.infrastructure.mappers.CouponMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class CouponService implements ICouponService {

    @Autowired
    private final CouponRepository couponRepository;

    private CouponMapper couponMapper;

    @Override
    public CouponResponse create(CouponRequest request) {
        Coupons coupons = couponMapper.couponRequestToCoupon(request);
        return couponMapper.couponToCouponResponse(this.couponRepository.save(coupons));
    }


    @Override
    public void delete(String id) {
        this.couponRepository.deleteById(id);
    }

    @Override
    public Page<CouponResponse> getAll(int page, int size) {

        PageRequest pageable = PageRequest.of(page, size);
        
        if (page != 0) pageable = PageRequest.of(page - 1, size);
        
        return couponRepository.findAll(pageable).map(couponMapper::couponToCouponResponse);
    }
    
    @Override
    public CouponResponse update(CouponRequest request, String id) {
        Coupons coupons = this.find(id);
        if(coupons.getHistories().isEmpty()){
            couponMapper.couponToUpdate(request, coupons);
            return couponMapper.couponToCouponResponse(this.couponRepository.save(coupons));
        }else{
            throw new IllegalArgumentException("The coupon has been used");
        }
        // only if the coupons has no uses in the table history
    }
    
    public Coupons find(String id) {
        return couponRepository.findById(id).orElseThrow();
    }
}
