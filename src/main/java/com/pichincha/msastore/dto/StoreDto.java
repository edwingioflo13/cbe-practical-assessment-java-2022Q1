package com.pichincha.msastore.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String category;

    @NotNull
    private String ownerId;
}
