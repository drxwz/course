package com.endava.calculator.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {


    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {

        Payment p = new Payment();
        p.setAmount(100);
        p.setCardNUmber("2222-2222-2222-2222");
        p.setCurrency("RON");
        p.setCustomerName("John Ion");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(p);

        LOGGER.info("\n{}",json);

        Payment deserialized = gson.fromJson(json, Payment.class);
        LOGGER.info(p.equals(deserialized));
        LOGGER.info(deserialized.getCardNUmber());
    }

}
