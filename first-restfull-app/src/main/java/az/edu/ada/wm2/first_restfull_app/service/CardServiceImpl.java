package az.edu.ada.wm2.first_restfull_app.service;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import az.edu.ada.wm2.first_restfull_app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepo;

    @Autowired
    public CardServiceImpl(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    @Override
    public List<Card> getCards() {
        return cardRepo.findAll();
    }

    @Override
    public Card createCard(Card card) {
        return cardRepo.save(card);
    }
}
