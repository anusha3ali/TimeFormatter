package org.utility.timeunitbuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondsBuilderTest {
    SecondsBuilder builder = new SecondsBuilder();

    @Test
    public void testBuildSecondsFromPositiveMilliseconds() {
        String result = builder.build(3000L);
        Assertions.assertEquals("3 seconds", result);
    }

    @Test
    public void testFormatZeroMilliseconds() {
        String result = builder.build(0L);
        Assertions.assertEquals("0 second", result);
    }

    @Test
    public void testFormatNegativeMilliseconds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.build(-1000L));
    }

}