package com.restapi.prodmgr.mapper;

import com.restapi.prodmgr.dto.productDTO;
import com.restapi.prodmgr.model.product;

public class ProductMapper {
    public static product DtoToEntity(productDTO prd){
        return new product().setName(prd.getName())
        .setPrice(prd.getPrice());
    }

    public static productDTO EntityToDto(product prd){
        return new productDTO().setName(prd.getName())
        .setPrice(prd.getPrice());
    }
}
