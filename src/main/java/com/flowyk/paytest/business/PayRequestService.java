package com.flowyk.paytest.business;

import com.flowyk.paytest.api.ClientRequest;
import com.flowyk.paytest.api.PayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PayRequestService {

    @Autowired
    private SignService signService;

    @Value("${setup.mid}")
    private String mid;

    @Value("${setup.eshopId}")
    private String eshopId;

    private BigInteger lastTxId = BigInteger.ZERO;

    public PayRequest generateRequest(ClientRequest clientRequest) {

        PayRequest result = new PayRequest();
        result
                .setMid(mid)
                .setEshopId(eshopId)
                .setLangCode("SK")
                .setClientId("12345")
                .setFirstName("Jožko")
                .setFamilyName("Mrkvička")
                .setEmail("jozko.mrkvicka@demo.com")
                .setCountry("SVK")
                .setMsTxnId(getTransactionId())
                .setAmount(clientRequest.getAmount())
                .setCurrAlphaCode("EUR")
                .setCurrNumCode("EUR")
                .setCurrNumAlpha("EUR")
                .setTimestamp(getTimestamp())
                .setRedirectSign("true");

        setSign(result);
        return result;
    }

    private String getTransactionId() {
        BigInteger txId = lastTxId.add(BigInteger.ONE);
        lastTxId = txId;
        return txId.toString();
    }

    private String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void setSign(PayRequest result) {
        String signedMessage = new StringBuilder()
                .append(result.getMid())
                .append(result.getAmount())
                .append(result.getCurrAlphaCode())
                .append(result.getMsTxnId())
                .append(result.getFirstName())
                .append(result.getFamilyName())
                .append(result.getTimestamp()).toString();


        result.setSign(signService.generateSignFor(signedMessage));
    }


}
