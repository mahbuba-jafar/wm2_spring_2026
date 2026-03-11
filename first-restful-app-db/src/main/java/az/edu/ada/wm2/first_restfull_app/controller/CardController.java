package az.edu.ada.wm2.first_restfull_app.controller;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import az.edu.ada.wm2.first_restfull_app.service.CardService;
import az.edu.ada.wm2.first_restfull_app.service.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    //    @Autowired //Field injection
    private CardService cardService;

    @Value("${my.welcome.message}")
    private String welcomeMessage;

//    @Autowired //Constructor injection
//    public CardController(CardService cardService) {
//        this.cardService = cardService;
//    }

    @Autowired //setter injection
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping({"/", ""})
    public List<Card> getAllCards() {
        return cardService.getCards();
    }

    @PostMapping
    public Card addCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return welcomeMessage;
    }

    @GetMapping("/byOwner")
    public List<Card> getAllCardsByOwner(@RequestParam String ownerName) {
        return cardService.getCardsByOwnerName(ownerName);
    }

}
