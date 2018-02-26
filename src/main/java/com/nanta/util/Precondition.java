package com.nanta.util;

import com.nanta.exception.InvalidException;

public final class Precondition {
  private Precondition() {}

  public static void checkArgument(boolean condition, String errorMessage) throws Exception {
    if (condition) {
      throw new InvalidException(errorMessage);
    }
  }

}
