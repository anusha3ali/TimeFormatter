package org.utility.timeunitbuilder;

import org.utility.stringutils.Constants;

import java.util.concurrent.TimeUnit;

public class HoursBuilder implements UnitBuilder {
    /**
     * The next formatter to build the final formatted time string.
     */
    UnitBuilder nextFormatter;

    /**
     * Constructor to set the next formatter.
     *
     * @param nextFormatter the next formatter to build the final formatted time string.
     */
    public HoursBuilder(UnitBuilder nextFormatter) {
        this.nextFormatter = nextFormatter;
    }

    /**
     * Method to build the formatted time string in hours format.
     *
     * @param milliseconds user inputted milliseconds that are required to be converted to the desired format
     * @return formatted time string in minutes format
     * @throws IllegalArgumentException if the given milliseconds is less than 0.
     */
    @Override
    public String build(long milliseconds) {
        if (milliseconds < 0) {
            throw new IllegalArgumentException();
        }
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long remainingTime = milliseconds - TimeUnit.HOURS.toMillis(hours);
        if (nextFormatter != null) {
            return formattedMinutes(hours) + Constants.SPACE + nextFormatter.build(remainingTime);
        } else {
            return formattedMinutes(hours);
        }
    }

    /**
     * Method to format the minutes to the desired format.
     *
     * @param hours the time in minutes
     * @return formatted string in minutes format
     */
    private String formattedMinutes(long hours) {
        return hours + Constants.SPACE + (hours > 1 ? Constants.HOURS : Constants.HOUR);
    }
}
