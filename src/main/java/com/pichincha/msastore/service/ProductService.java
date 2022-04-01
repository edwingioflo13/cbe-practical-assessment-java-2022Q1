package com.pichincha.msastore.service;

import com.pichincha.msastore.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse.ProductDto> putProducts(Long id);

}
