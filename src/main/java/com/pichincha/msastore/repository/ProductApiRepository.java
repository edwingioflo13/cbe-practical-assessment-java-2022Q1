package com.pichincha.msastore.repository;

import com.pichincha.msastore.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductApiRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${properties.products.uri}")
    private String uri;

    public ProductResponse getProducts() {
        return restTemplate.getForEntity(uri, ProductResponse.class).getBody();
    }
}
