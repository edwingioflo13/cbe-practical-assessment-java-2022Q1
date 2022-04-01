package com.pichincha.msastore.service;

import com.pichincha.msastore.util.DataUtil;
import com.pichincha.msastore.dto.ProductResponse;
import com.pichincha.msastore.repository.ProductApiRepository;
import com.pichincha.msastore.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductApiRepository productApiRepository;

    @Autowired
    private ProductService productService;

    @Test
    void shouldReturnProductModel() {
        //given
        ProductResponse expectedResponse = DataUtil.generateProductResponse();

        //when
        when(productApiRepository.getProducts()).thenReturn(DataUtil.generateProductResponse());
        when(productRepository.saveAll(any())).thenReturn(List.of(DataUtil.generateProduct()));

        List<ProductResponse.ProductDto> response = productService.putProducts(100L);

        assertThat(response.get(0).getName(), equalTo(expectedResponse.getProds().get(0).getName()));
        assertThat(response.get(0).getId(), equalTo(expectedResponse.getProds().get(0).getId()));
        assertThat(response.get(0).getStock(), equalTo(expectedResponse.getProds().get(0).getStock()));
        assertThat(response.get(0).getCod(), equalTo(expectedResponse.getProds().get(0).getCod()));

    }

}