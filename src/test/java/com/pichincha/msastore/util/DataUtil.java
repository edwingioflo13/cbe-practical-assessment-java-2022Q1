package com.pichincha.msastore.util;

import com.pichincha.msastore.dto.ProductResponse;
import com.pichincha.msastore.dto.StoreDto;
import com.pichincha.msastore.model.Product;
import com.pichincha.msastore.model.Store;
import com.pichincha.msastore.model.User;

import java.math.BigDecimal;
import java.util.List;

public class DataUtil {

    public static ProductResponse generateProductResponse(){
        return ProductResponse.builder()
                .prods(List.of(ProductResponse.ProductDto.builder()
                                .id(1)
                                .name("prod-name-1")
                                .cod("prod-1")
                                .price(BigDecimal.ONE)
                                .stock(10)
                        .build()))
                .build();
    }

    public static Product generateProduct(){
        return Product.builder()
                .id(1)
                .name("prod-name-1")
                .cod("prod-1")
                .price(BigDecimal.ONE)
                .stock(10)
                .build();
    }

    public static Store generateStore(){
        return Store.builder()
                .id(100L)
                .category("Alimentos")
                .name("Super")
                .ownerUser(User.builder().id("1").build())
                .build();
    }

    public static StoreDto generateStoreDto(){
        return StoreDto.builder()
                .id(100L)
                .category("Alimentos")
                .name("Super")
                .ownerId("1")
                .build();
    }
}
