package az.edu.ada.wm2.first_restfull_app.repository;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("prod")
public class CardRepositoryProdImpl implements CardRepository {
    private final List<Card> cards = new ArrayList<Card>();

    @Override
    public List<Card> findAll() {
        return cards;
    }

    @Override
    public Card save(Card card) {
        if(card ==null ) return null;
        card.setCreatedAt(LocalDate.now());
        cards.add(card);
        return card;
    }
}
