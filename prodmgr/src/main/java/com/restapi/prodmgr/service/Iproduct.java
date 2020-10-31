package com.restapi.prodmgr.service;

import java.util.List;
import java.util.Optional;

import com.restapi.prodmgr.model.product;

public interface Iproduct {
    List<product> getAllProducts();
    Optional<product> findById(int id);
    product save(product prd);
    void delete(int id);
}
