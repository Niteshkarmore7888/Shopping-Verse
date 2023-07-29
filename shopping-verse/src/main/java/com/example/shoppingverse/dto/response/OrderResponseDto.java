package com.example.shoppingverse.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {
    String orderId;

    String cardUsed;

    Date orderDate;

    int orderTotal;

    String customerName;

    List<ItemResponseDto> item;
}
