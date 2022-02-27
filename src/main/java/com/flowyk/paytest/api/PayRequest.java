package com.flowyk.paytest.api;

public class PayRequest {
    private String mid;
    private String eshopId;
    private String langCode;

    private String clientId;
    private String firstName;
    private String familyName;
    private String email;
    private String country;

    private String msTxnId;
    private String amount;
    private String currAlphaCode;
    private String currNumCode;
    private String currNumAlpha;
    private String sign;
    private String timestamp;
    private String redirectSign;

    public String getMid() {
        return mid;
    }

    public PayRequest setMid(String mid) {
        this.mid = mid;
        return this;
    }

    public String getEshopId() {
        return eshopId;
    }

    public PayRequest setEshopId(String eshopId) {
        this.eshopId = eshopId;
        return this;
    }

    public String getLangCode() {
        return langCode;
    }

    public PayRequest setLangCode(String langCode) {
        this.langCode = langCode;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public PayRequest setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PayRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public PayRequest setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PayRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PayRequest setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getMsTxnId() {
        return msTxnId;
    }

    public PayRequest setMsTxnId(String msTxnId) {
        this.msTxnId = msTxnId;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public PayRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrAlphaCode() {
        return currAlphaCode;
    }

    public PayRequest setCurrAlphaCode(String currAlphaCode) {
        this.currAlphaCode = currAlphaCode;
        return this;
    }

    public String getCurrNumCode() {
        return currNumCode;
    }

    public PayRequest setCurrNumCode(String currNumCode) {
        this.currNumCode = currNumCode;
        return this;
    }

    public String getCurrNumAlpha() {
        return currNumAlpha;
    }

    public PayRequest setCurrNumAlpha(String currNumAlpha) {
        this.currNumAlpha = currNumAlpha;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayRequest setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public PayRequest setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getRedirectSign() {
        return redirectSign;
    }

    public PayRequest setRedirectSign(String redirectSign) {
        this.redirectSign = redirectSign;
        return this;
    }
}
