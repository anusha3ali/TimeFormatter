package org.utility.timeutils;

import org.utility.stringutils.StringFormatter;
import org.utility.timeformatter.HoursFormatter;
import org.utility.timeformatter.MinutesFormatter;
import org.utility.timeformatter.SecondsFormatter;
import org.utility.timeformatter.TimeFormatter;

/**
 * This enum provides a set of time formatting options for converting time in milliseconds to a specific unit of time.
 */
public enum TimeFormatterUtil {
    TO_SECONDS(new SecondsFormatter()),
    TO_MINUTES(new MinutesFormatter()),
    TO_HOURS(new HoursFormatter());
    private final TimeFormatter timeConverter;

    TimeFormatterUtil(TimeFormatter timeConverter) {
        this.timeConverter = timeConverter;
    }

    /**
     * Returns a formatted string of time in the desired unit of time.
     *
     * @param milliseconds time in milliseconds to be converted
     * @return formatted string in the desired unit of time
     */
    public String formatTime(long milliseconds) {

        return timeConverter.format(milliseconds);
    }

    /**
     * Returns a FormattedTime object that contains the formatted string of time in the desired unit of time.
     *
     * @param milliseconds time in milliseconds to be converted
     * @return a FormattedTime object containing formatted string in the desired unit of time
     */
    public FormattedTime format(long milliseconds) {
        return new FormattedTime(timeConverter.format(milliseconds));
    }

    public static class FormattedTime {
        private final String formattedString;

        public FormattedTime(String formattedString) {
            this.formattedString = formattedString;
        }

        public String toString() {
            return formattedString;
        }

        /**
         * @return a new FormattedTime object with zero units removed from the formatted string
         */
        public FormattedTime removeZeroUnits() {
            return new FormattedTime(StringFormatter.removeZeroUnitsFromString(formattedString));
        }

        /**
         * @return a new FormattedTime object with short form of h, m, s for hours, minutes and seconds.
         */
        public FormattedTime toShortForm() {
            return new FormattedTime(StringFormatter.formatToShortString(formattedString));
        }

    }

}
