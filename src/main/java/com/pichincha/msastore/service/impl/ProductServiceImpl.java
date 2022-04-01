package com.pichincha.msastore.service.impl;

import com.pichincha.msastore.dto.ProductResponse;
import com.pichincha.msastore.mapper.StoreMapper;
import com.pichincha.msastore.model.Product;
import com.pichincha.msastore.repository.ProductApiRepository;
import com.pichincha.msastore.repository.ProductRepository;
import com.pichincha.msastore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductApiRepository productApiRepository;
    private final StoreMapper storeMapper;


    @Override
    public List<ProductResponse.ProductDto> putProducts(Long id) {
        List<Product> products = new ArrayList<>();
        List<ProductResponse.ProductDto> productsDtos = new ArrayList<>();
        productApiRepository.getProducts().getProds()
                .forEach(productDto -> {
                    if(productDto.getStock()>5){
                        products.add(storeMapper.mapDtoToProduct(productDto, id));
                        productsDtos.add(productDto);
                    }
                });
        productRepository.saveAll(products);
        return productsDtos;
    }
}
