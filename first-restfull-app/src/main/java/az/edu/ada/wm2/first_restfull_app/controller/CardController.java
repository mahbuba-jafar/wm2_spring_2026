package az.edu.ada.wm2.first_restfull_app.controller;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import az.edu.ada.wm2.first_restfull_app.service.CardService;
import az.edu.ada.wm2.first_restfull_app.service.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

//    @Autowired //Field injection
    private CardService cardService;

//    @Autowired //Constructor injection
//    public CardController(CardService cardService) {
//        this.cardService = cardService;
//    }

    @Autowired //setter injection
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping({"/", ""})
    public List<Card> getAllCards(){
        return cardService.getCards();
    }

}
