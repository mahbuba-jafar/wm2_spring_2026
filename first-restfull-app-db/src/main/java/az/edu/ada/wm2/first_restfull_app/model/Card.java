package az.edu.ada.wm2.first_restfull_app.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNo;
    private String ownerName;
    private LocalDate expiryDate;
    private LocalDate createdAt;
    private BigDecimal balance;

    public Card() {

    }

    public Card(String cardNo, String ownerName, LocalDate expiryDate, BigDecimal balance) {
        this.cardNo = cardNo;
        this.ownerName = ownerName;
        this.expiryDate = expiryDate;
        this.balance = balance;
    }

    public Card(Long id, String cardNo, String ownerName, LocalDate expiryDate, LocalDate createdAt, BigDecimal balance) {
        this.id = id;
        this.cardNo = cardNo;
        this.ownerName = ownerName;
        this.expiryDate = expiryDate;
        this.createdAt = createdAt;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                "cardNo='" + cardNo + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", expiryDate=" + expiryDate +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                '}';
    }
}
