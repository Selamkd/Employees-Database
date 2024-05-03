package com.sparta.gwoc.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import java.io.IOException;

public class LoggerUtil {

    private static final Logger CONSOLE_LOGGER = Logger.getLogger("ConsoleLogger");
    private static final Logger FILE_LOGGER = Logger.getLogger("FileLogger");
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE = "\u001B[97m";
    private static final String ANSI_BLUE = "\u001B[94m";
    private static final String ANSI_PURPLE = "\u001B[95m";
    private static final String ANSI_BLACK = "\u001B[90m";
    private static final String ANSI_RED = "\u001B[91m";
    private static final String ANSI_CYAN = "\u001B[96m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";


    public static void setup() throws IOException {

        CONSOLE_LOGGER.setUseParentHandlers(false);
        CONSOLE_LOGGER.addHandler(getConsoleHandler());
        CONSOLE_LOGGER.setLevel(Level.ALL);

        FILE_LOGGER.setUseParentHandlers(false);
        FILE_LOGGER.addHandler(getFileHandler());
        FILE_LOGGER.setLevel(Level.ALL);
        System.setProperty("java.util.logging.ConsoleHandler.formatter", CustomFormatter.class.getName());
    }

    private static ConsoleHandler getConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new CustomFormatter());

        return consoleHandler;
    }
    private static FileHandler getFileHandler() throws IOException {
        String logDirectory = "src/main/resources/";
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String logFileName = logDirectory + "log__" + currentDate.format(formatter) + "__log";
        FileHandler fileHandler = new FileHandler(logFileName);

        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new CustomFormatter());

        return fileHandler;
    }
    public static void warning(String logging) {
        CONSOLE_LOGGER.warning(ANSI_RED +  logging + ANSI_RESET);
        FILE_LOGGER.warning(logging);
    }

    public static void info(String logging) {
        CONSOLE_LOGGER.info(ANSI_CYAN + logging + ANSI_RESET);
        FILE_LOGGER.info(logging);
    }

    public static void config(String logging) {
        CONSOLE_LOGGER.config(ANSI_GREEN + logging + ANSI_RESET);
        FILE_LOGGER.config(logging);
    }


}
