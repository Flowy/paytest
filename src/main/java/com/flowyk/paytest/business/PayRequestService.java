package com.flowyk.paytest.business;

import com.flowyk.paytest.api.ClientRequest;
import com.flowyk.paytest.api.PayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PayRequestService {


    @Autowired
    private SignService signService;

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
                .setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .setRedirectSign("true");

        String signedMessage = new StringBuilder()
                .append(result.getMid())
                .append(result.getAmount())
                .append(result.getCurrAlphaCode())
                .append(result.getMsTxnId())
                .append(result.getFirstName())
                .append(result.getFamilyName())
                .append(result.getTimestamp()).toString();


        result.setSign(signService.generateSignFor(signedMessage));
        return result;
    }

}
