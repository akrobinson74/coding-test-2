package com.crossengage.controller;

import java.util.function.Function;

/**
 *
 */
public abstract class ContactPointVisitor {
    private static final Function<String, Boolean> NOOP = arg -> {
       return Boolean.FALSE;
    };

    public Function<String, Boolean> curryMsgArgs(String preamble) {
        return (String arg) -> {
            System.out.println(preamble + arg);
            return true;
        };
    }

    public static Function<String, Boolean> getNOOP() {
        return NOOP;
    }
}
