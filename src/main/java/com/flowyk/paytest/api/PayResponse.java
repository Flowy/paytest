package com.flowyk.paytest.api;

public class PayResponse {

    private String msTxnId;
    private String amount;
    private String currCode;
    private String result;
    private String sign;

    public String getMsTxnId() {
        return msTxnId;
    }

    public PayResponse setMsTxnId(String msTxnId) {
        this.msTxnId = msTxnId;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public PayResponse setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrCode() {
        return currCode;
    }

    public PayResponse setCurrCode(String currCode) {
        this.currCode = currCode;
        return this;
    }

    public String getResult() {
        return result;
    }

    public PayResponse setResult(String result) {
        this.result = result;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }
}
