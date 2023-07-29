package com.example.shoppingverse.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerResponseDto {

    String name;
    String emailId;


}
