package com.pichincha.msastore.mapper;

import com.pichincha.msastore.dto.ProductResponse;
import com.pichincha.msastore.dto.StoreDto;
import com.pichincha.msastore.model.Product;
import com.pichincha.msastore.model.Store;
import com.pichincha.msastore.model.User;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public Store mapDtoToStore(StoreDto storeDto) {
        return Store.builder()
                .name(storeDto.getName())
                .category(storeDto.getCategory())
                .ownerUser(User.builder().id(storeDto.getOwnerId()).build())
                .build();
    }

    public StoreDto mapStoreToDto(Store store) {
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .category(store.getCategory())
                .ownerId(store.getOwnerUser().getId())
                .build();
    }

    public Product mapDtoToProduct(ProductResponse.ProductDto productDto, Long id) {
        return Product.builder()
                .cod(productDto.getCod())
                .id(productDto.getId())
                .stock(productDto.getStock())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .store(Store.builder().id(id).build())
                .build();
    }
}
