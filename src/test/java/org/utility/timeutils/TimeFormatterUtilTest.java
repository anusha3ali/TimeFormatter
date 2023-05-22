package org.utility.timeutils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeFormatterUtilTest {
    @Test
    void formatTimeToSeconds() {
        long milliseconds = 1234567;
        String expected = "1234 seconds";
        String actual = TimeFormatterUtil.TO_SECONDS.formatTime(milliseconds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void formatTimeToMinutes() {
        long milliseconds = 125000;
        String expected = "2 minutes 5 seconds";
        String actual = TimeFormatterUtil.TO_MINUTES.formatTime(milliseconds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void formatTimeToHours() {
        long milliseconds = 3660000;
        String expected = "1 hour 1 minute 0 second";
        String actual = TimeFormatterUtil.TO_HOURS.formatTime(milliseconds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void formatTimeWithoutZeroUnits() {
        long milliseconds = 3660000;
        String expected = "1 hour 1 minute";
        String actual = TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void formatTimeToShortForm() {
        long milliseconds = 3660000;
        String expected = "1h 1m 0s";
        String actual = TimeFormatterUtil.TO_HOURS.format(milliseconds).toShortForm().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void formatTimeWithoutZeroUnitsAndShortForm() {
        long milliseconds = 3660000;
        String expected = "1h 1m";
        String actual = TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toShortForm().toString();
        Assertions.assertEquals(expected, actual);
    }
}