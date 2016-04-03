package converter.model;

import converter.util.Util;

/**
 * Created by william on 02.04.16.
 */
public class Rate {
    public String to;
    public String from;
    public Double rate;

    public Rate(RateJSON rateJson) {
        this.to = rateJson.getTo();
        this.from = rateJson.getFrom();
        this.rate = Util.stringToDouble(rateJson.getRate());
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
