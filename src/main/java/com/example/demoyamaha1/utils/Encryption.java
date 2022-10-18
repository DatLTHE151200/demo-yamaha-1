package com.example.demoyamaha1.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Base64;
public class Encryption {

    @Autowired
    private Environment environment;
    private String keyseed = environment.getProperty("jwt.secret.key");

    public String getKey(){
        return Base64.getEncoder().withoutPadding().encodeToString(keyseed.getBytes());
    }

}
