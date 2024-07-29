package com.riwi.assesment.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.assesment.api.dto.request.CouponRequest;
import com.riwi.assesment.api.dto.response.CouponResponse;
import com.riwi.assesment.domain.entities.Coupons;


@Mapper(componentModel = "spring")
public interface CouponMapper {
    @Mapping(target="id", ignore=true)
    @Mapping(target="histories", ignore=true)
    Coupons couponRequestToCoupon(CouponRequest couponRequest);

    CouponResponse couponToCouponResponse(Coupons coupon);

    @Mapping(target="id", ignore=true)
    @Mapping(target="histories", ignore=true)
    Coupons couponToUpdate(CouponRequest response, @MappingTarget Coupons coupon);
}
