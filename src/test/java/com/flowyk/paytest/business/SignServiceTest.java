package com.flowyk.paytest.business;

import org.apache.tomcat.util.buf.HexUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignServiceTest {

    @Autowired
    private SignService signService;

    @Test
    public void sha1() {
        String input = "demoOMED14.14EUR1234567890JožkoMrkvička2022-02-27 16:21:38";
        String output = "c0d94d8ff11c55642e88daae779874fceca12e9f";

        String actual = HexUtils.toHexString(signService.sha1Digest(input));
        Assertions.assertEquals(output, actual);
    }

    @Test
    public void aes() {
        String input = "demoOMED14.14EUR1234567890JožkoMrkvička2022-02-27 16:21:38";
        String output = "6AD3E242024BBA1ADC3E251BB1D7B96C";

        Assertions.assertEquals(output, signService.createSign(signService.sha1Digest(input)));
    }
}
