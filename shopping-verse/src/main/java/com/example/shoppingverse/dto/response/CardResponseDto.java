package com.example.shoppingverse.dto.response;


import com.example.shoppingverse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponseDto {


    String customerName;

    String cardNo;

    Date validTill;

    CardType cardType;

}
