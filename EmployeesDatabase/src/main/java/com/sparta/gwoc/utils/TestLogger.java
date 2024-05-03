package com.sparta.gwoc.utils;

import java.io.IOException;
import java.util.logging.Logger;

public class TestLogger {
    public static void main(String[] args) {
     final Logger LOGGER = Logger.getLogger(TestLogger.class.getName());

            LoggerUtil.setup(LOGGER);

        LOGGER.severe("This is a severe message.");
        LOGGER.warning("This is a warning message.");
        LOGGER.info("This is an info message.");
        LOGGER.config("This is a config message.");
        LOGGER.fine("This is a fine message.");
        LOGGER.finer("This is a finer message.");
        LOGGER.finest("This is a finest message.");
    }
}
