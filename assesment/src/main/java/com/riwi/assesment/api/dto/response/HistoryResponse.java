package com.riwi.assesment.api.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {

  private String id;
  private Date redemptionDate;
  private BigDecimal endPrice;
  private String userId;
  private String userName;
  private String productId;
  private String productName;
  private String couponId;
  private String couponCode;

}
