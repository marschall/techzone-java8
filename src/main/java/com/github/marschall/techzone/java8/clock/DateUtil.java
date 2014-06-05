package com.github.marschall.techzone.java8.clock;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class DateUtil {
  
  private final Clock clock;

  public DateUtil(Clock clock) {
    this.clock = clock;
  }
  
  public LocalDate getDateTodayNoTime() {
    return LocalDate.now(this.clock);
  }
  
  public LocalDate getDateYesterdayNoTime() {
    return this.getDateTodayNoTime().minusDays(1L);
  }
  
  public LocalDate getDateTomorrowNoTime() {
    return this.getDateTodayNoTime().plusDays(1L);
  }
  
  public ZonedDateTime now() {
    return ZonedDateTime.now(this.clock);
  }
  
  public LocalDate getDateNoTime(ZonedDateTime dateTime) {
    return dateTime.toLocalDate();
  }

}
