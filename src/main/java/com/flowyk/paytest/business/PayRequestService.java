package com.flowyk.paytest.business;

import com.flowyk.paytest.api.ClientRequest;
import com.flowyk.paytest.api.PayRequest;
import org.springframework.stereotype.Component;

@Component
public class PayRequestService {

    public PayRequest generateRequest(ClientRequest clientRequest) {

        PayRequest result = new PayRequest();
        result.setMid("demoOMED")
                .setEshopId("11111111")
                .setLangCode("SK")
                .setClientId("12345")
                .setFirstName("Jožko")
                .setFamilyName("Mrkvička")
                .setEmail("jozko.mrkvicka@demo.com")
                .setCountry("SVK")
                .setMsTxnId("1234567890")
                .setAmount(clientRequest.getAmount())
                .setCurrAlphaCode("EUR")
                .setCurrNumCode("EUR")
                .setCurrNumAlpha("EUR")
                .setTimestamp("2022-02-27 16:21:38")
                .setRedirectSign("true");
        result.setSign(generateSignFor(result));
        return result;
    }

    private String generateSignFor(PayRequest request) {
        return "6AD3E242024BBA1ADC3E251BB1D7B96C";

    }
}
