package az.edu.ada.wm2.first_restfull_app.repository;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("!prod")
public class CardRepositoryImpl implements CardRepository {
    private final List<Card> cards = new ArrayList<Card>(List.of(
            new Card("C0001","Islam",
                    LocalDate.of(2026,10, 11),
                    BigDecimal.valueOf(1000000.50)),
            new Card("C0002","Ulkar",
                    LocalDate.of(2026,9, 11),
                    BigDecimal.valueOf(500000.70))
    ));

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
