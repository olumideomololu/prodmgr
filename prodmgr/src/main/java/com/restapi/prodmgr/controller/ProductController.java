package com.restapi.prodmgr.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.restapi.prodmgr.dto.productDTO;
import com.restapi.prodmgr.exception.ProductNotFoundException;
import com.restapi.prodmgr.mapper.ProductMapper;
import com.restapi.prodmgr.model.product;
import com.restapi.prodmgr.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private productService productService;

    @GetMapping(value = "/products")
    List<product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/{id}")
    ResponseEntity<product> getById(@PathVariable("id") @Min(1) int id) {
        product prd = productService.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No Product with ID : " + id));
        return ResponseEntity.ok().body(prd);
    }

    @PostMapping(value = "/products")
    ResponseEntity<?> createProduct(@Valid @RequestBody productDTO inprod) {
        product prd = ProductMapper.DtoToEntity(inprod);
        product addedprd = productService.save(prd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedprd.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/products/{id}")
    ResponseEntity<product> updateProduct(@PathVariable("id") @Min(1) int id, @Valid @RequestBody productDTO inprod) {
        product prd = productService.findById(id)
                                    .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        
        product newprd = ProductMapper.DtoToEntity(inprod);
        newprd.setId(prd.getId());
        productService.save(newprd);
        return ResponseEntity.ok().body(newprd);    
    }

    @DeleteMapping(value = "/products/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable("id") @Min(1) int id) {
        product prd = productService.findById(id)
                                    .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        productService.delete(prd.getId());
        return ResponseEntity.ok().body("Product with ID : "+id+" deleted with success!");  
    }
}
