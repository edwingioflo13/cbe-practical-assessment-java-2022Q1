package com.pichincha.msastore.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String category;

    @ManyToOne
    private User ownerUser;

    @OneToMany
    private List<Product> products;


}
