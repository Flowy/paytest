package com.flowyk.paytest.web;

import com.flowyk.paytest.api.PayResponse;
import com.flowyk.paytest.api.ProcessResult;
import com.flowyk.paytest.business.PayResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ResponseController {
    private final Logger LOG = LoggerFactory.getLogger(ResponseController.class);

    @Autowired
    private PayResponseService payResponseService;

    @GetMapping("/rurl")
    public String payResponse(@RequestParam Map<String, String> params, Model model) {
        PayResponse payResponse = new PayResponse()
                .setAmount(params.get("Amount"))
                .setCurrCode(params.get("CurrCode"))
                .setMsTxnId(params.get("MsTxnId"))
                .setResult(params.get("Result"))
                .setSign(params.get("Sign"));

        ProcessResult processResult = payResponseService.processResponse(payResponse);

        model.addAttribute("processResult", processResult);
        model.addAttribute("payResponse", payResponse);
        return "response";
    }

}
