package java8;

import java.math.BigDecimal;

public class Transactions {

    private Double amount;
    private String category;

    public Transactions(Double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public Transactions() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                '}';
    }
}
