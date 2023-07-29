package com.example.shoppingverse.service;

import com.example.shoppingverse.Enum.ProductCategory;
import com.example.shoppingverse.Exception.SellerNotFoundException;
import com.example.shoppingverse.dto.request.ProductRequestDto;
import com.example.shoppingverse.dto.response.ProductResponseDto;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.ProductTrnasformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto){

        Seller seller =sellerRepository.findByEmailId(productRequestDto.getSellerEmail());
        if(seller ==null){
           throw new SellerNotFoundException("Seller doesn't found ");
        }
        //DTO->ENTITY
        Product product= ProductTrnasformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        //save
        Seller savedSeller=sellerRepository.save(seller);
        List<Product> productList=savedSeller.getProducts();
        Product latestProduct=productList.get(productList.size()-1);

        //prepare dtO
      return  ProductTrnasformer.ProductToProductResponseDto(latestProduct);

    }
    public List<ProductResponseDto> getProductByCategoryAndPriceGreaterThan(int price, ProductCategory category) {

        List<Product>products= productRepository.getProductByCategoryAndPriceGreaterThan(price,category);

        //prepare list of response dto
        List<ProductResponseDto>productResponseDtos=new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductTrnasformer.ProductToProductResponseDto(product));
        }
        return productResponseDtos;
    }
}
