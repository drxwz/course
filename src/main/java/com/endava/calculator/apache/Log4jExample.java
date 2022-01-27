package com.endava.calculator.apache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {

    private static final Logger LOGGER = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        Log4jExample e = new Log4jExample();
        e.doSomething("Eminescu");
    }

    public void doSomething(String s) {
        LOGGER.info("Doing something with {}", s);
    }
}
