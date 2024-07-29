package com.riwi.assesment.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.riwi.assesment.api.dto.request.HistoryRequest;
import com.riwi.assesment.api.dto.response.HistoryResponse;
import com.riwi.assesment.domain.entities.History;

@Mapper(componentModel = "spring")
public interface HistoryMapper {

  HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "user.name", target = "userName")
  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "product.name", target = "productName")
  @Mapping(source = "coupon.id", target = "couponId")
  @Mapping(source = "coupon.code", target = "couponCode")
  HistoryResponse toHistoryResponse(History history);

  @Mapping(source = "userId", target = "user.id")
  @Mapping(source = "productId", target = "product.id")
  @Mapping(source = "couponId", target = "coupon.id")
  History toHistory(HistoryRequest request);

  void updateHistoryFromRequest(HistoryRequest request, @MappingTarget History history);

}
