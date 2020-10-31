package com.restapi.prodmgr.repository;

import com.restapi.prodmgr.model.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<product, Integer> {
    
}
