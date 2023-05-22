package org.utility.timeformatter;

import org.utility.timeunitbuilder.SecondsBuilder;
import org.utility.timeunitbuilder.UnitBuilder;

/**
 * The SecondsFormatter class is responsible for formatting time in seconds.
 * It implements the TimeFormatter interface and provides a method to format user inputted milliseconds to seconds format.
 * It uses the SecondsBuilder class to build the formatted time string.
 */
public class SecondsFormatter implements TimeFormatter {
    @Override
    public String format(long milliseconds) {
        UnitBuilder unitBuilder = new SecondsBuilder();
        return unitBuilder.build(milliseconds);
    }
}
