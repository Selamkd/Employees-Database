package com.sparta.gwoc.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return " [" + record.getLevel()
                + "] -> " + record.getMessage()
                + "\n";
    }
}


