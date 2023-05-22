package org.utility.timeformatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HoursFormatterTest {
    @Test
    void formatMillisToHours() {
        HoursFormatter hoursFormatter = new HoursFormatter();
        String formattedTime = hoursFormatter.format(3721000L);
        Assertions.assertEquals("1 hour 2 minutes 1 second", formattedTime);
    }

}
