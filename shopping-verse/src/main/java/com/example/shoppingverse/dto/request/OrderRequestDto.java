package com.example.shoppingverse.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDto {

    String customerEmail;

    int productId;

    String cardUsed;

    int cvv;

    int requiredQuantity;

}
