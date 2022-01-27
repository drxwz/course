package com.endava.calculator.jackson;

import com.endava.calculator.google.GsonExample;
import com.endava.calculator.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment p = new Payment();
        p.setAmount(100);
        p.setCardNUmber("2222-2222-2222-2222");
        p.setCurrency("EUR");
        p.setCustomerName("LEWIS HAMILTON");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(p);
        LOGGER.info("\n{}",json);

        Payment deserializer = objectMapper.readValue(json, Payment.class);
        LOGGER.info(deserializer.equals(p));
    }
}
