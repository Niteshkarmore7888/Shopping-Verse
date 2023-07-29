package com.example.shoppingverse.transformer;


import com.example.shoppingverse.dto.request.CustomerRequestDto;
import com.example.shoppingverse.dto.response.CustomerResponseDto;
import com.example.shoppingverse.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .emailId(customerRequestDto.getEmailId())
                .mobileNo(customerRequestDto.getMobileNo())
                .build();

    }

    public static  CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .mobileNo(customer.getMobileNo())
                .gender(customer.getGender())
                .build();
    }
}
