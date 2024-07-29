package com.riwi.assesment.domain.entities;

import java.util.Date;
import java.util.List;

import com.riwi.assesment.utils.enums.StatusCoupon;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity( name = "coupons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupons {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(length = 20)
  private String code;

  @Lob
  private String description;

  @Column(nullable = false)
  private Date expiration_date;

  @Column(nullable = false)
  private Double discount_percentage;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private StatusCoupon status;

  // Relations

  @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        mappedBy = "coupon",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<History> histories; 
}
