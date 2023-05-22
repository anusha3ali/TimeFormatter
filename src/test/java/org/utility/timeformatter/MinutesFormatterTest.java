package org.utility.timeformatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinutesFormatterTest {
    @Test
    void formatMillisToMinutes() {
        MinutesFormatter minutesFormatter = new MinutesFormatter();
        String formattedTime = minutesFormatter.format(3650000L);
        Assertions.assertEquals("60 minutes 50 seconds", formattedTime);
    }

}
