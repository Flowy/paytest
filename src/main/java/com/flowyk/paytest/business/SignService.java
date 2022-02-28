package com.flowyk.paytest.business;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
public class SignService {

    @Value("${sign.key}")
    private String key;

    @Value("${sign.iv}")
    private String iv;

    private MessageDigest messageDigest;
    private Cipher cipher;

    @PostConstruct
    public void init() {
        String cipherAlgorithm = "AES/CBC/PKCS5Padding";

        SecretKey cipherKey = new SecretKeySpec(HexUtils.fromHexString(key), "AES");
        IvParameterSpec cipherIV = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));

        try {
            cipher = Cipher.getInstance(cipherAlgorithm);
            cipher.init(Cipher.ENCRYPT_MODE, cipherKey, cipherIV);
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException |
                InvalidAlgorithmParameterException |
                NoSuchPaddingException |
                InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateSignFor(String input) {
        return createSign(sha1Digest(input));
    }

    byte[] sha1Digest(String message) {
        return messageDigest.digest(message.getBytes(StandardCharsets.UTF_8));
    }

    String createSign(byte[] payload) {
        byte[] cipherBytes;
        try {
            cipherBytes = cipher.doFinal(payload);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
        byte[] signBytes = Arrays.copyOfRange(cipherBytes, 0, 16);
        return HexUtils.toHexString(signBytes).toUpperCase();
    }
}
