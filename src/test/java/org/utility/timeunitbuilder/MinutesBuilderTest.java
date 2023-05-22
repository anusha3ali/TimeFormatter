package org.utility.timeunitbuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinutesBuilderTest {
    UnitBuilder unitBuilder = new MinutesBuilder(new SecondsBuilder());

    @Test
    public void testBuild() {
        String actual = unitBuilder.build(3661000L);
        String expected = "61 minutes 1 second";
        Assertions.assertEquals(expected, actual);
        unitBuilder = new MinutesBuilder(null);
        actual = unitBuilder.build(120000L);
        expected = "2 minutes";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBuildWithNegativeMilliseconds() {
        UnitBuilder unitBuilder = new MinutesBuilder(new SecondsBuilder());
        Assertions.assertThrows(IllegalArgumentException.class, () -> unitBuilder.build(-1L));
    }
}