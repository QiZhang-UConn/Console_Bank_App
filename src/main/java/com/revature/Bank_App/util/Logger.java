package com.revature.Bank_App.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;

public class Logger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private static Logger logger;
    private final boolean printToConsole;

    Logger(boolean printToConsole) {
        this.printToConsole = printToConsole;
    }

    public static Logger getLogger(boolean printToConsole) {
        if (logger == null) {
            logger = new Logger(printToConsole);
        }

        return logger;
    }

    public void log(String message, Object... args) {

        try (Writer logWriter = new FileWriter("/home/qi/Documents/training/211101-java-react-enterprise/qi_zhang_p0/src/main/resources/log/app.log", true)) {
            String time=new Timestamp(System.currentTimeMillis()).toString();
            String formattedMsg = String.format(message, args);
            logWriter.write(formattedMsg + time+"\n");

            if (printToConsole) {
                System.out.println(ANSI_YELLOW + formattedMsg + ANSI_RESET);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
