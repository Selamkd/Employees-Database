package com.sparta.gwoc.utils;

import java.io.IOException;
import java.util.logging.Logger;

public class TestLogger {
    public static void main(String[] args) {


        try {
            LoggerUtil.setup();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
