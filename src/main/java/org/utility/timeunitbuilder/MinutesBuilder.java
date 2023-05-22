package org.utility.timeunitbuilder;

import org.utility.stringutils.Constants;

import java.util.concurrent.TimeUnit;

public class MinutesBuilder implements UnitBuilder {
    /**
     * The next formatter to build the final formatted time string.
     */
    UnitBuilder nextFormatter;

    /**
     * Constructor to set the next formatter.
     *
     * @param nextFormatter the next formatter to build the final formatted time string.
     */
    public MinutesBuilder(UnitBuilder nextFormatter) {
        this.nextFormatter = nextFormatter;
    }

    /**
     * Method to build the formatted time string in minutes format.
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
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        long remainingTime = milliseconds - TimeUnit.MINUTES.toMillis(minutes);
        if (nextFormatter != null) {
            return formattedMinutes(minutes) + Constants.SPACE + nextFormatter.build(remainingTime);
        } else {
            return formattedMinutes(minutes);
        }
    }

    /**
     * Method to format the minutes to the desired format.
     *
     * @param minutes the time in minutes
     * @return formatted string in minutes format
     */
    private String formattedMinutes(long minutes) {
        return minutes + Constants.SPACE + (minutes > 1 ? Constants.MINUTES : Constants.MINUTE);
    }
}
