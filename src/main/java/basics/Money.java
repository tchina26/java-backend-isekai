package basics;

import basics.exception.CurrenciesNotEqualException;

final public class Money {
    private final Double amount;
    private final String currency;

    private Money (Double amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public static Money of(Double amount, String currency){
        if(amount == null || amount < 0) throw new IllegalArgumentException("Amount must be >= 0");
        if(currency == null) throw new NullPointerException("Currency cannot be null");
        return new Money(amount, currency);
    }

    public Money add(Money money) throws CurrenciesNotEqualException {
        if (!money.currency.equals(this.currency))
            throw new CurrenciesNotEqualException();
        Double amountSum = this.amount + money.amount;
        return new Money(amountSum, this.currency);
    }
    public Double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}
