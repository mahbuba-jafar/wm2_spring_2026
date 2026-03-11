package az.edu.ada.wm2.first_restfull_app.service;

import az.edu.ada.wm2.first_restfull_app.model.Card;

import java.util.List;

public interface CardService {

    List<Card> getCards();

    Card createCard(Card card);

    List<Card> getCardsByOwnerName(String ownerName);
}
