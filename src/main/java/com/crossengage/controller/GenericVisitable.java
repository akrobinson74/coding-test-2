package com.crossengage.controller;

import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public interface GenericVisitable<T> {
    public Function<String, Boolean> accept(
        GenericContactPointVisitor<T> visitor, User user
    );

    public String getData();
}
