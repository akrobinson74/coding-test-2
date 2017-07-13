package com.crossengage.controller;

import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public interface VisitsContactPoints {
    Function<String, Boolean> visit(AcceptsVisitors acceptsVisitors, User user);
}
