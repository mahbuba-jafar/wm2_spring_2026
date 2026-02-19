package az.edu.ada.wm2.first_restfull_app.repository;

import az.edu.ada.wm2.first_restfull_app.model.Card;

import java.util.List;

public interface CardRepository {

    List<Card> findAll();

    Card save(Card card);
}
