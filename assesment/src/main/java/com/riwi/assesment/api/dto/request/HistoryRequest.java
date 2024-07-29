package com.riwi.assesment.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRequest {

  @NotNull(message = "El id del usuario es obligatorio")
  private String userId;

  @NotNull(message = "El id del producto es obligatorio")
  private String productId;

  @NotNull(message = "El id del cupon es obligatorio")
  private String couponId;

  @NotNull(message = "El precio es requerido")
  @DecimalMin( value = "0.01", 
  message="El valor del servicio debese ser mayor a 0")
  private BigDecimal endPrice;

}
