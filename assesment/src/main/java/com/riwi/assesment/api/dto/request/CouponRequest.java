package com.riwi.assesment.api.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {

    @Size(min = 5, max = 20, message = "The coupon code must be between 5 and 20 characters")
    private String code;

    @Size(min = 5, max = 20, message = "The coupon description must be between 5 and 20 characters")
    private String description;

    @NotNull(message = "Expiration date cannot be null")
    private Date expiration_date;

    @NotNull(message = "Discount percentage cannot be null")
    @Min(value = 0, message = "Discount percentage must be greater than or equal to 0")
    @Max(value = 100, message = "Discount percentage must be less than or equal to 100")
    private Double discount_percentage;
}