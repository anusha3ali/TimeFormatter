package org.utility.timeunitbuilder;

import org.utility.stringutils.Constants;

import java.util.concurrent.TimeUnit;

/**
 * The SecondsFormatter class is responsible for formatting time in seconds.
 * It implements the UnitFormatter interface and provides a method to format user inputted milliseconds to seconds format.
 */
public class SecondsBuilder implements UnitBuilder {
    /**
     * This function uses the Java TimeUnit util class to convert milliseconds into seconds.
     *
     * @param milliseconds user inputted milliseconds that are required to be converted to the desired format
     * @return formatted time string
     * @throws IllegalArgumentException if the given milliseconds is less than 0.
     */
    @Override
    public String build(long milliseconds) {
        if (milliseconds < 0) {
            throw new IllegalArgumentException();
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        return seconds + Constants.SPACE + (seconds > 1 ? Constants.SECONDS : Constants.SECOND);
    }
}
