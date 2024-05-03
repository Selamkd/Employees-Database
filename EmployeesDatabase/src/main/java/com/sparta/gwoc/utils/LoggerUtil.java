package com.sparta.gwoc.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import java.io.IOException;

public class LoggerUtil {

    public static void setup(Logger logger) {
        logger.setUseParentHandlers(false);

        logger.setLevel(Level.FINE);


        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.addHandler(consoleHandler);


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String logDirectory = "src/main/resources/";

        String logFileName = logDirectory + "log__" + currentDate.format(formatter) + "__log";
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(logFileName);
        } catch (IOException e) {
            System.out.println("FileHandler could not access log file");
        }

        SimpleFormatter formatterTxt = new SimpleFormatter();
        fileHandler.setFormatter(formatterTxt);

        logger.addHandler(fileHandler);

        fileHandler.setLevel(Level.FINE);
    }
}
