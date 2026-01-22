package basics;

import basics.exception.CurrenciesNotEqualException;

import java.util.Objects;


final public class Money {
    private final Double amount;
    private final String currency;

    private Money (Double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public static Money of(Double amount, String currency){
        if(amount == null || amount < 0) throw new IllegalArgumentException("Amount must be >= 0");
        if(currency == null || currency.isBlank()) throw new IllegalArgumentException("Currency cannot be null or blank");
        return new Money(amount, currency);
    }

    public Money add(Money money) throws CurrenciesNotEqualException {
        if(money == null) throw new NullPointerException("Money cant be null");
        if (!money.currency.equals(this.currency))
            throw new CurrenciesNotEqualException();
        Double amountSum = this.amount + money.amount;
        return new Money(amountSum, this.currency);
    }
    public Double getAmount() { return amount; }
    public String getCurrency() { return currency; }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if(!(object instanceof Money objectMoney)) return false;

        return amount.equals(objectMoney.amount)
                && currency.equals(objectMoney.currency);
    }
    @Override
    public int hashCode(){
        return Objects.hash(amount, currency);
    }
}
