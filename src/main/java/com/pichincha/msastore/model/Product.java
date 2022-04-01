package com.pichincha.msastore.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Integer id;
    private String cod;
    private String name;
    private BigDecimal price;
    private Integer stock;

    @ManyToOne
    private Store store;
}
