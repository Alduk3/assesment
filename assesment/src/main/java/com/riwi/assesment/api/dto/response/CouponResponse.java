package com.riwi.assesment.api.dto.response;

import java.util.Date;

import com.riwi.assesment.utils.enums.StatusCoupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponse {

  private String id;

  private String code;

  private String description;

  private Date expiration_date;

  private Double discount_percentage;

  private StatusCoupon status;

}
