package com.example.shoppingverse.controller;

import com.example.shoppingverse.Enum.ProductCategory;
import com.example.shoppingverse.Exception.SellerNotFoundException;
import com.example.shoppingverse.dto.request.ProductRequestDto;
import com.example.shoppingverse.dto.response.ProductResponseDto;
import com.example.shoppingverse.service.ProductService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        try {
            ProductResponseDto response = productService.addProduct(productRequestDto);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
      @GetMapping("/get_by_price")
    public ResponseEntity getProductByCategoryAndPriceGreaterThan(@RequestParam("price") int price,
                                                                  @RequestParam("category") ProductCategory category){
        List<ProductResponseDto> productResponseDtoList=productService.getProductByCategoryAndPriceGreaterThan(price,category);

        return new ResponseEntity(productResponseDtoList,HttpStatus.FOUND);
    }
}
