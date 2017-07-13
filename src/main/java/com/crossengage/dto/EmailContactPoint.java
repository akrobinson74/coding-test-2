package com.crossengage.dto;

import com.crossengage.EmailContactPointVisitor;

import java.util.function.Function;

/**
 *
 */
public interface EmailContactPoint extends AcceptsVisitors {
    Function<String, Boolean> accept(
        EmailContactPointVisitor emailContactPointVisitor, User user
    );
}
