package org.utility.timeunitbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HoursBuilderTest {
    UnitBuilder unitBuilder = new HoursBuilder(new MinutesBuilder(new SecondsBuilder()));

    @Test
    public void testAllBuild() {
        assertAll(() -> assertEquals("0 hour 15 minutes 6 seconds", unitBuilder.build(906740)),
                () -> assertEquals("0 hour 0 minute 0 second", unitBuilder.build(0)));

    }

    @Test
    public void testHoursBuild() {
        unitBuilder = new HoursBuilder(null);
        String actual = unitBuilder.build(120000L);
        String expected = "0 hour";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildWithoutMinutes() {
        unitBuilder = new HoursBuilder(new SecondsBuilder());
        String actual = unitBuilder.build(18210344);
        String expected = "5 hours 210 seconds";
        assertEquals(expected, actual);
    }
}