package com.riwi.assesment.domain.repositories;

import com.riwi.assesment.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
