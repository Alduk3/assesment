package com.riwi.assesment.infrastructure.abstract_services;

import com.riwi.assesment.api.dto.request.ProductRequest;
import com.riwi.assesment.api.dto.response.ProductBasicResponse;

public interface IProductService extends Create<ProductRequest, ProductBasicResponse>, Delete<String>, Update<ProductBasicResponse, ProductRequest, String>, FindAll<ProductBasicResponse>, FindById<ProductBasicResponse, String>{
}
