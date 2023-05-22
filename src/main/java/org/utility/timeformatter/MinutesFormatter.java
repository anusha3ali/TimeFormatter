package org.utility.timeformatter;

import org.utility.timeunitbuilder.MinutesBuilder;
import org.utility.timeunitbuilder.SecondsBuilder;
import org.utility.timeunitbuilder.UnitBuilder;

/**
 * The MinutesFormatter class is responsible for formatting time in minutes and seconds.
 * This class's only function uses the MinutesBuilder class with SecondsBuilder as a dependency
 * to build the formatted time string.
 * It implements the TimeFormatter interface and provides a method to format user inputted milliseconds to seconds format.
 * It uses the SecondsBuilder class to build the formatted time string.
 */
public class MinutesFormatter implements TimeFormatter {
    @Override
    public String format(long milliseconds) {
        UnitBuilder unitBuilder = new MinutesBuilder(new SecondsBuilder());
        return unitBuilder.build(milliseconds);
    }
}
