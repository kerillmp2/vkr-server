package controllers;

public class LogController {
    private static final boolean LOGS_ON = true;

    public static void info(String info) {
        if (LOGS_ON) {
            System.out.printf("THREAD (%s) INFO: %s%n", Thread.currentThread().getName(), info);
        }
    }

    public static void serverInfo(String info) {
        if (LOGS_ON) {
            System.out.printf("SERVER INFO: %s%n", info);
        }
    }

    public static void error(String error) {
        if (LOGS_ON) {
            System.out.printf("THREAD (%s) ERROR: %s%n", Thread.currentThread().getName(), error);
        }
    }

    public static void serverError(String error) {
        if (LOGS_ON) {
            System.out.printf("SERVER ERROR: %s%n", error);
        }
    }
}
