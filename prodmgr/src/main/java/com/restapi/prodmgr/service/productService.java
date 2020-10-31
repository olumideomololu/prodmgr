package com.restapi.prodmgr.service;

import java.util.List;
import java.util.Optional;

import com.restapi.prodmgr.model.product;
import com.restapi.prodmgr.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService implements Iproduct{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<product> getAllProducts() {
        // method stub
        return productRepository.findAll();
    }

    @Override
    public Optional<product> findById(int id){
        return productRepository.findById(id);
    }

    @Override
    public product save(product prd) {
        return productRepository.save(prd);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
