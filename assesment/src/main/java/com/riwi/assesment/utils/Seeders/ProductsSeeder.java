package com.riwi.assesment.utils.Seeders;

import com.riwi.assesment.domain.entities.Product;
import com.riwi.assesment.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Slf4j
public class ProductsSeeder implements CommandLineRunner {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (this.productRepository.count() > 0) return;

        Product product = Product.builder().name("Chicken").description("").price(new BigDecimal("9.9")).build();
        Product product2 = Product.builder().name("Pineapple").description("").price(new BigDecimal("4.9")).build();
        Product product3 = Product.builder().name("Orange juice").description("").price(new BigDecimal("5.9")).build();
        Product product4 = Product.builder().name("Apple").description("").price(new BigDecimal("2.9")).build();
        Product product5 = Product.builder().name("Banana").description("").price(new BigDecimal("1.9")).build();
        Product product6 = Product.builder().name("Pig").description("").price(new BigDecimal("12.9")).build();
        Product product7 = Product.builder().name("Rice").description("").price(new BigDecimal("7.9")).build();
        Product product8 = Product.builder().name("Pen").description("").price(new BigDecimal("3.9")).build();
        Product product9 = Product.builder().name("Tomato").description("").price(new BigDecimal("1.9")).build();
        Product product10 = Product.builder().name("Potatoes").description("").price(new BigDecimal("6.9")).build();


        this.productRepository.save(product);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.save(product4);
        this.productRepository.save(product5);
        this.productRepository.save(product6);
        this.productRepository.save(product7);
        this.productRepository.save(product8);
        this.productRepository.save(product9);
        this.productRepository.save(product10);
        log.info("Database seed product successfully created");

    }
}
