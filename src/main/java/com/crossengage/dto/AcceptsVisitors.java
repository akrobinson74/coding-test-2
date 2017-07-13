package com.crossengage.dto;

import java.util.function.Function;

/**
 *
 */
public interface AcceptsVisitors {
    Function<String, Boolean> accept(ContactPointVisitor contactPointVisitor, User user);

    String getData();
}
