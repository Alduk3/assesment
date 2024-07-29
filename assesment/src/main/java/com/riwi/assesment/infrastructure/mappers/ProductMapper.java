package com.riwi.assesment.infrastructure.mappers;

import com.riwi.assesment.api.dto.request.ProductRequest;
import com.riwi.assesment.api.dto.response.ProductBasicResponse;
import com.riwi.assesment.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "histories", ignore = true)

    })
    Product requestToEntity(ProductRequest productRequest);

    ProductBasicResponse entityToResponse(Product entity);
}
