package com.crossengage;

import com.crossengage.dto.AcceptsVisitors;
import com.crossengage.dto.User;

import java.util.function.Function;

/**
 *
 */
public interface EmailContactPointVisitor {
   public abstract Function<String, Boolean> visit(
       AcceptsVisitors acceptsVisitors, User user
   );
}
