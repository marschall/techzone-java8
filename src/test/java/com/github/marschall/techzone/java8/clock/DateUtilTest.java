package com.github.marschall.techzone.java8.clock;

import static org.junit.Assert.assertEquals;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
  
  private DateUtil dateUtil;

  @Before
  public void setUp() {
    Instant instant = Instant.ofEpochMilli(1398325776542L);
    ZoneId zoneId = ZoneId.of("Europe/Zurich");
    Clock clock = Clock.fixed(instant, zoneId);
    dateUtil = new DateUtil(clock);
  }
  
  @Test
  public void now() {
    ZonedDateTime now = this.dateUtil.now();
    ZoneId zoneId = ZoneId.of("Europe/Zurich");
    assertEquals(ZonedDateTime.of(2014, 4, 24, 9, 49, 36, 542000000, zoneId), now);
  }

  @Test
  public void getDateTodayNoTime() {
    LocalDate dateTodayNoTime = this.dateUtil.getDateTodayNoTime();
    assertEquals(LocalDate.of(2014, Month.APRIL, 24), dateTodayNoTime);
  }
  
  @Test
  public void getDateYesterdayTime() {
    LocalDate dateYesterdayNoTime = this.dateUtil.getDateYesterdayTime();
    assertEquals(LocalDate.of(2014, Month.APRIL, 23), dateYesterdayNoTime);
  }
  
  @Test
  public void getDateTomorrowNoTime() {
    LocalDate dateTomorrowNoTime = this.dateUtil.getDateTomorrowNoTime();
    assertEquals(LocalDate.of(2014, Month.APRIL, 25), dateTomorrowNoTime);
  }
  
  @Test
  public void getDateNoTime() {
    ZoneId zoneId = ZoneId.of("Europe/Zurich");
    ZonedDateTime dateTime = ZonedDateTime.of(2014, 4, 24, 9, 49, 36, 542000000, zoneId);
    LocalDate dateNoTime = this.dateUtil.getDateNoTime(dateTime);
    assertEquals(LocalDate.of(2014, Month.APRIL, 24), dateNoTime);
  }

}
