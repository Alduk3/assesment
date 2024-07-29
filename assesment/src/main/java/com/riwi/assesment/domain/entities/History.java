package com.riwi.assesment.domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private Date redemptionDate;

  @Column(nullable = false)
  private BigDecimal endPrice;

  // Relations

  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id", 
        referencedColumnName = "id"
    )
  private User user;
    
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_id", 
        referencedColumnName = "id"
    )
  private Product product;
    
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "coupon_id", 
        referencedColumnName = "id"
    )
    private Coupons coupon;
}
