package com.crossengage.controller;

import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public interface AcceptsVisitors {
    Function<String, Boolean> accept(ContactPointVisitor contactPointVisitor, User user);

    String getData();
}
