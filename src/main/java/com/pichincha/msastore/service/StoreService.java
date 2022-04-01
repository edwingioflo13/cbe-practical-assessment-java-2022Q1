package com.pichincha.msastore.service;

import com.pichincha.msastore.dto.StoreDto;

public interface StoreService {

    StoreDto saveStore(StoreDto storeDto);

    StoreDto getStore(String name);

    StoreDto updateStore(StoreDto storeDto);

    StoreDto deleteStore(StoreDto storeDto);
}
