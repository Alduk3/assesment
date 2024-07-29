package com.riwi.assesment.infrastructure.abstract_services;

import com.riwi.assesment.api.dto.request.CouponRequest;
import com.riwi.assesment.api.dto.response.CouponResponse;

public interface ICouponService extends Create<CouponRequest, CouponResponse>, 
                                        Update<CouponResponse, CouponRequest, String>,
                                        Delete<String>,
                                        FindAll<CouponResponse> {
    
}
