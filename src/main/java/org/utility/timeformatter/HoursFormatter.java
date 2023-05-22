package org.utility.timeformatter;

import org.utility.timeunitbuilder.HoursBuilder;
import org.utility.timeunitbuilder.MinutesBuilder;
import org.utility.timeunitbuilder.SecondsBuilder;
import org.utility.timeunitbuilder.UnitBuilder;

/**
 * The HoursFormatter class is responsible for formatting time in hours, minutes, and seconds.
 * This class's only function uses the HoursBuilder class with MinutesBuilder and SecondsBuilder as dependencies
 * to build the formatted time string.
 * It implements the TimeFormatter interface and provides a method to format user inputted milliseconds to hours format.
 * It uses the MinutesBuilder and SecondsBuilder classes to build the formatted time string.
 */
public class HoursFormatter implements TimeFormatter {
    @Override
    public String format(long milliseconds) {
        UnitBuilder unitBuilder = new HoursBuilder(new MinutesBuilder(new SecondsBuilder()));
        return unitBuilder.build(milliseconds);
    }
}
