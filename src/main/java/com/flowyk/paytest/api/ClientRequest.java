package com.flowyk.paytest.api;

public class ClientRequest {
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayRequest{" +
                "amount=" + amount +
                '}';
    }
}
