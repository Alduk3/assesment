package com.riwi.assesment.api.controllers;

import com.riwi.assesment.api.dto.request.ProductRequest;
import com.riwi.assesment.api.dto.response.ProductBasicResponse;
import com.riwi.assesment.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
@Tag(name =  "Products")
public class ProductController {

    @Autowired
    private  final IProductService productService;

    @Operation(summary = "Retrieve all products", description = "Fetch a paginated list of products.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of products",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductBasicResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request parameters",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))

    @GetMapping
    public ResponseEntity<Page<ProductBasicResponse>> findAll(@RequestParam(defaultValue = "1") int page,
                                                              @RequestParam (defaultValue = "10") int size) {
        return ResponseEntity.ok(this.productService.getAll(page -1, size));
    }

    @Operation(summary = "Retrieve a product by ID", description = "Fetch a single product by its ID.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the product",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductBasicResponse.class)))
    @ApiResponse(responseCode = "404", description = "Product not found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductBasicResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.productService.getById(id));
    }

//    @Operation(summary = "Create a new product", description = "Add a new product to the inventory.")
//    @ApiResponse(responseCode = "201", description = "Product successfully created",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductBasicResponse.class)))
//    @ApiResponse(responseCode = "400", description = "Invalid request data",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
//
//    @PostMapping
//    public ResponseEntity<ProductBasicResponse> create(@Validated @RequestBody ProductRequest productRequest) {
//        return ResponseEntity.ok(productService.create(productRequest));
//    }

//    @Operation(summary = "Delete a product", description = "Remove a product from the inventory by its ID.")
//    @ApiResponse(responseCode = "204", description = "Product successfully deleted")
//    @ApiResponse(responseCode = "404", description = "Product not found",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
//
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        this.productService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

//    @Operation(summary = "Update a product", description = "Modify an existing product's details.")
//    @ApiResponse(responseCode = "200", description = "Product successfully updated",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductBasicResponse.class)))
//    @ApiResponse(responseCode = "400", description = "Invalid request data",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
//    @ApiResponse(responseCode = "404", description = "Product not found",
//            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
//
//    @PutMapping(path = "/{id}")
//    public ResponseEntity<ProductBasicResponse> update(@PathVariable String id,@Validated @RequestBody ProductRequest productRequest) {
//        return ResponseEntity.ok(this.productService.update(productRequest, id));
//    }
}
