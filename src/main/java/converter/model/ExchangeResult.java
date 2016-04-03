package converter.model;

/**
 * Created by william on 02.04.16.
 */
public class ExchangeResult {
    public Double amountFrom;
    public Double amountTo;
    public Rate exchangeRate;

    public ExchangeResult(Double amount, Rate rate) {
        this.amountFrom = amount;
        this.exchangeRate = rate;
        this.amountTo = amount * rate.getRate();
    }

    public Double getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(Double amountFrom) {
        this.amountFrom = amountFrom;
        this.amountTo = this.amountFrom * this.exchangeRate.getRate();
    }

    public Double getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(Double amountTo) {
        this.amountTo = amountTo;
    }

    public Rate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Rate exchangeRate) {
        this.exchangeRate = exchangeRate;
        this.amountTo = this.amountFrom * this.exchangeRate.getRate();
    }
}
