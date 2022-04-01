package com.pichincha.msastore.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private List<ProductDto> prods;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductDto {
        private Integer id;
        private String cod;
        private String name;
        private BigDecimal price;
        private Integer stock;
    }
}
