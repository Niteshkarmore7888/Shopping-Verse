package com.example.shoppingverse.service;

import com.example.shoppingverse.Exception.CustomerNotFoundException;
import com.example.shoppingverse.dto.request.CardRequestDto;
import com.example.shoppingverse.dto.response.CardResponseDto;
import com.example.shoppingverse.model.Card;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto){
        Customer customer= customerRepository.findByMobileNo(cardRequestDto.getCustomermobNo());

        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }
        //Create card enity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        Customer savedCustomer=customerRepository.save(customer);   //Save both customer and card
         List<Card> cards=savedCustomer.getCards();
         Card latestCard=cards.get(cards.size()-1);
       // Prepare response dto
        CardResponseDto cardResponseDto=CardTransformer.CardToCardResponseDto(latestCard);
        cardResponseDto.setCardNo(generateMaskedCard(latestCard.getCardNo()));
        return cardResponseDto;
    }

    public  String generateMaskedCard(String cardNo){
        int cardLength=cardNo.length();
        String maskedCard="";
        for(int i=0; i<cardLength-4;i++){
            maskedCard+='X';
        }
        maskedCard +=cardNo.substring(cardLength-4);
        return maskedCard;
    }
}
