package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.response.CartResponseDto;
import com.example.shoppingverse.dto.response.ItemResponseDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


public class CartTransformer {
    public static CartResponseDto CartToCartResponseDto(Cart cart){

        List<ItemResponseDto>itemResponseDtoList=new ArrayList<>();
        for(Item item:cart.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }
        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}