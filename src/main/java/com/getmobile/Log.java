package com.getmobile;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;


public final class Log {


    public static <T> void pass(T message) {
        if (message == null) return;
        Allure.step(message.toString(), Status.PASSED);
        System.out.println(message);
    }

    //Warn Level Logs


    public static <T> void warning(T message) {
        if (message == null) return;
        Allure.step(message.toString(), Status.BROKEN);
        System.out.println(message);
    }

    public static <T> void fail(T message) {
        fail(message, null);
    }

    public static <T> void fail(T message, Throwable e) {
        if (message == null) return;
        Allure.step(message.toString(), Status.FAILED);
        System.out.println(message);
        // throws AssertionError
        var assertionError = new AssertionError(message);
        assertionError.initCause(e);
        throw assertionError;
    }

    public static <T> void fail(T expected, T actual, String message) {
        fail(expected, actual, message, null);
    }

    public static <T> void pass(T expected, T actual, String message) {
        pass("Expected :" + expected);
        pass("Actual :" + actual);
        pass(message);
    }

    public static <T> void fail(T expected, T actual, String message, Throwable e) {
        warning("Expected: " + expected);
        warning("Actual: " + actual);
        fail("""
                Expected: %s
                Actual: %s
                Message: %s
                Exception: %s
                """.formatted(expected, actual, message, e == null ? "" : e.getMessage()), e);
    }
}
