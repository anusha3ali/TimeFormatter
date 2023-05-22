package org.utility.timeformatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondsFormatterTest {

    @Test
    public void formatMillisToSeconds() {
        long milliseconds = 123456789;
        String expected = "123456 seconds";
        SecondsFormatter formatter = new SecondsFormatter();
        String actual = formatter.format(milliseconds);
        Assertions.assertEquals(expected, actual);
    }

}