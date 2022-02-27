package com.flowyk.paytest.web;

import com.flowyk.paytest.api.ClientRequest;
import com.flowyk.paytest.api.PayRequest;
import com.flowyk.paytest.business.PayRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestController {
    private final Logger LOG = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private PayRequestService payRequestService;

    @GetMapping("/request")
    public String index(Model model) {
        model.addAttribute("clientRequest", new ClientRequest());
        return "request";
    }

    @PostMapping("/request")
    public String redirect(@ModelAttribute ClientRequest clientRequest, Model model) {
        LOG.debug("request with parameter: " + clientRequest);
        PayRequest payRequest = payRequestService.generateRequest(clientRequest);
        model.addAttribute(payRequest);
        model.addAttribute("returnURL", "http://127.0.0.1:8024/rurl");
        return "redirect";
    }
}
