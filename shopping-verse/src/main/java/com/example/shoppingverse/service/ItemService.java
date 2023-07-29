package com.example.shoppingverse.service;

import com.example.shoppingverse.Exception.CustomerNotFoundException;
import com.example.shoppingverse.Exception.InsufficientQuantityException;
import com.example.shoppingverse.Exception.ProductNotFoundException;
import com.example.shoppingverse.dto.request.ItemRequestDto;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.model.Item;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

     @Autowired
    CustomerRepository customerRepository;

     @Autowired
    ProductRepository productRepository;

    public Item createItem(ItemRequestDto itemRequestDto) {
        Customer customer=customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exists");
        }
        Optional<Product> productOptional=productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exists");
        }
        Product product=productOptional.get();

        //check for queantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("sorry! Required Quantity Is Not available");
        }

        //create Item
        Item item= ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
       // item.setProduct(product);
        return item;

    }
}
