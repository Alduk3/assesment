package com.riwi.assesment.infrastructure.services;

import com.riwi.assesment.api.dto.request.ProductRequest;
import com.riwi.assesment.api.dto.response.ProductBasicResponse;
import com.riwi.assesment.domain.entities.Product;
import com.riwi.assesment.domain.repositories.ProductRepository;
import com.riwi.assesment.infrastructure.abstract_services.IProductService;
import com.riwi.assesment.infrastructure.helpers.SupportServices;
import com.riwi.assesment.infrastructure.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    private final SupportServices<Product> supportServices;

    @Override
    public ProductBasicResponse create(ProductRequest productRequest) {
        return this.productMapper.entityToResponse(this.productRepository.save(this.productMapper.requestToEntity(productRequest)));
    }

    @Override
    public void delete(String id) {
        this.productRepository.delete(this.find(id));
    }

    @Override
    public Page<ProductBasicResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);


        return this.productRepository.findAll(pagination).map(this.productMapper::entityToResponse);
    }

    @Override
    public ProductBasicResponse getById(String id) {
        return this.productMapper.entityToResponse(this.find(id));
    }

    @Override
    public ProductBasicResponse update(ProductRequest productRequest, String id) {
        Product product = this.find(id);
        product = this.productMapper.requestToEntity(productRequest);
        product.setId(id);
        return this.productMapper.entityToResponse(this.productRepository.save(product));
    }

    public Product find(String id) {
        return this.supportServices.findById(productRepository, id, "Product");
    }
}
