package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.request.SellerRequestDto;
import com.example.shoppingverse.dto.response.SellerResponseDto;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.SellerTrnasformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto){

        //dto->entity

        Seller seller= SellerTrnasformer.SellerRequestDtoToSeller(sellerRequestDto);

      //save the entity
        Seller savedSeller=sellerRepository.save(seller);

        //PREAPER ENTITY
        return SellerTrnasformer.SellerToResponseDto(savedSeller);

    }
}
