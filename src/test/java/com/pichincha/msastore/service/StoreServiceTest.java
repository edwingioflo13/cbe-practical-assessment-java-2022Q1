package com.pichincha.msastore.service;

import com.pichincha.msastore.dto.StoreDto;
import com.pichincha.msastore.model.Store;
import com.pichincha.msastore.repository.StoreRepository;
import com.pichincha.msastore.util.DataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class StoreServiceTest {

    @MockBean
    private StoreRepository storeRepository;

    @Autowired
    private StoreService storeService;



    @Test
    void getStore() {
        //given
        StoreDto storeExpected = DataUtil.generateStoreDto();

        //when
        when(storeRepository.findByName(any())).thenReturn(Optional.of(DataUtil.generateStore()));

        //then
        StoreDto response = storeService.getStore("Super");

        assertThat(response.getName(), equalTo(storeExpected.getName()));
        assertThat(response.getId(), equalTo(storeExpected.getId()));
        assertThat(response.getCategory(), equalTo(storeExpected.getCategory()));
        assertThat(response.getOwnerId(), equalTo(storeExpected.getOwnerId()));

    }



}