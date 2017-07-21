package com.someprospectiveemployer.controller;

import com.someprospectiveemployer.model.User;

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
