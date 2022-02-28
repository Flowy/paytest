package com.flowyk.paytest.business;

import com.flowyk.paytest.api.PayResponse;
import com.flowyk.paytest.api.ProcessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PayResponseService {

    @Autowired
    private SignService signService;

    public ProcessResult processResponse(PayResponse payResponse) {
        ProcessResult result = new ProcessResult();
        result.setSignValidation(validate(payResponse));
        return result;
    }

    private String validate(PayResponse payResponse) {
        String signedMessage = new StringBuffer()
                .append(payResponse.getMsTxnId())
                .append(payResponse.getAmount())
                .append(payResponse.getCurrCode())
                .append(payResponse.getResult())
                .toString();
        return Optional.ofNullable(payResponse.getSign())
                .filter(s -> s.equals(signService.generateSignFor(signedMessage)))
                .map(s -> "OK").orElse("FAIL");
    }

}
