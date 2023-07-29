package com.example.shoppingverse.dto.request;


import com.example.shoppingverse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CardRequestDto {

    String customermobNo;

    String cardNo;

    int cvv;

    Date validTill;

    CardType cardType;

}
