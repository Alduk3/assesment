package com.riwi.assesment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.assesment.api.dto.request.CouponRequest;
import com.riwi.assesment.api.dto.response.CouponResponse;
import com.riwi.assesment.infrastructure.abstract_services.ICouponService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/coupons")
@AllArgsConstructor
public class CouponController {
    
    @Autowired
    private final ICouponService couponService;

    @GetMapping
    public ResponseEntity<Page<CouponResponse>> readAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ){
        return ResponseEntity.ok(this.couponService.getAll(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponResponse> update(
        @RequestParam String id,
        @Validated @RequestBody CouponRequest request
    ){
        return ResponseEntity.ok(this.couponService.update( request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @RequestParam String id
    ){
        this.couponService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<CouponResponse> create(
        @Validated @RequestBody CouponRequest request
    ){
        return ResponseEntity.ok(this.couponService.create(request));
    }
}
