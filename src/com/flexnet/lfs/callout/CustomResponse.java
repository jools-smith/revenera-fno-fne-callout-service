package com.flexnet.lfs.callout;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * This class defines the actions to be performed upon return from the capability request call-out
 */
public class CustomResponse<T> {
  private static Instant startTime;

  @JsonIgnore
  public static void start() {
    startTime = Instant.now();
  }

  public final String timestamp = Instant.now().truncatedTo(ChronoUnit.SECONDS).toString();
  public final String start_at = startTime.truncatedTo(ChronoUnit.SECONDS).toString();
  public final String up_for = Duration.between(startTime, Instant.now()).toString();

  public T payload;
}
