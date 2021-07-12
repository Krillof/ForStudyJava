package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jjj")
public class JustBean {
    @Value("${jbean.value}")
    public String value;
}
