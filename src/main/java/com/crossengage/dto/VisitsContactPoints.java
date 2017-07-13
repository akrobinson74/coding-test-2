package com.crossengage.dto;

import java.util.function.Function;

/**
 *
 */
public interface VisitsContactPoints {
    Function<String, Boolean> visit(AcceptsVisitors acceptsVisitors, User user);
}
