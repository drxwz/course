package com.endava.calculator.extensions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.jupiter.api.extension.Extension;

public class CustomTestExecutionListener implements TestExecutionListener, Extension {

    private static final Logger LOGGER = LogManager.getLogger(CustomTestExecutionListener.class);

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        LOGGER.info("test started {}", testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        LOGGER.info("test finished {}/{}", testIdentifier.getDisplayName(),testExecutionResult.getStatus());

    }
}
