package com.pichincha.msastore.service.impl;

import com.pichincha.msastore.dto.StoreDto;
import com.pichincha.msastore.exception.NotFoundStoreException;
import com.pichincha.msastore.mapper.StoreMapper;
import com.pichincha.msastore.repository.StoreRepository;
import com.pichincha.msastore.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public StoreDto saveStore(StoreDto storeDto) {
        return storeMapper.mapStoreToDto(storeRepository.save(storeMapper.mapDtoToStore(storeDto)));
    }

    @Override
    public StoreDto getStore(String name) {
        return storeRepository.findByName(name)
                .map(storeMapper::mapStoreToDto)
                .orElseThrow(NotFoundStoreException::new);
    }

    @Override
    public StoreDto updateStore(StoreDto storeDto) {
        if (storeRepository.existsById(storeDto.getId())) {
            return storeMapper.mapStoreToDto(storeRepository.save(storeMapper.mapDtoToStore(storeDto)));
        }
        throw new NotFoundStoreException();
    }

    @Override
    public StoreDto deleteStore(StoreDto storeDto) {
        return null;
    }
}
