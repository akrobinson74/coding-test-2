package com.crossengage;

import com.crossengage.dto.AcceptsVisitors;
import com.crossengage.dto.User;
import com.crossengage.dto.VisitsContactPoints;

import java.util.function.Function;

/**
 *
 */
public interface SMSVisitsContactPoints extends VisitsContactPoints {
   Function<String, Boolean> visit(AcceptsVisitors acceptsVisitors, User user);
}
