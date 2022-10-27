package com.shopee.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productmap) {
        this.productMap = productmap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            Integer currenValue = productMap.get(productDto);
            productMap.replace(productDto,currenValue + 1);
        }
        else {
            productMap.put(productDto,1);
        }
    }


}
