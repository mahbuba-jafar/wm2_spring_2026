package az.edu.ada.wm2.first_restfull_app.repository;

import az.edu.ada.wm2.first_restfull_app.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByOwnerNameContaining(String ownerName);

}
