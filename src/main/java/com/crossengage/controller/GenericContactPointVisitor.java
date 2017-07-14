package com.crossengage.controller;

import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public interface GenericContactPointVisitor<T> {
    public Function<String, Boolean> visit(T t, User user);
}
