package com.pichincha.msastore.controller;

import com.pichincha.msastore.dto.ProductResponse;
import com.pichincha.msastore.dto.StoreDto;
import com.pichincha.msastore.service.ProductService;
import com.pichincha.msastore.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${properties.base-path}")
public class StoreController {

    private final StoreService storeService;
    private final ProductService productService;

    @PostMapping("/stores")
    @ResponseStatus(HttpStatus.CREATED)
    public StoreDto saveStore(@Valid @RequestBody StoreDto storeDto) {
        return storeService.saveStore(storeDto);
    }

    @GetMapping("/stores/{name}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDto getStore(@PathVariable String name) {
        return storeService.getStore(name);
    }

    @PutMapping("/stores")
    @ResponseStatus(HttpStatus.OK)
    public StoreDto updateStore(@Valid @RequestBody StoreDto storeDto) {
        return storeService.updateStore(storeDto);
    }

    @DeleteMapping("/stores")
    @ResponseStatus(HttpStatus.OK)
    public StoreDto deleteStore(@Valid @RequestBody StoreDto storeDto) {
        return storeService.deleteStore(storeDto);
    }

    @GetMapping("/stores/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse.ProductDto> uploadProducts(@PathVariable Long id) {
        return productService.putProducts(id);
    }
}
