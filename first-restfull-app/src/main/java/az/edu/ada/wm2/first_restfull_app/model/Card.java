package az.edu.ada.wm2.first_restfull_app.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Card {
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
                "cardNo='" + cardNo + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", expiryDate=" + expiryDate +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                '}';
    }
}
