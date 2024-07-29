package com.riwi.assesment.api.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasicResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
