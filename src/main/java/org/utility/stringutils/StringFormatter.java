package org.utility.stringutils;

import org.apache.commons.lang3.StringUtils;

public final class StringFormatter {
    /**
     * Removes zero units from a formatted time string.
     * For example, "1 hour 0 minute 30 second" will be converted to "1 hour 30 second".
     *
     * @param formattedTime formatted time string to remove zero units from
     * @return time string without zero units
     */
    public static String removeZeroUnitsFromString(String formattedTime) {
        String[] timeUnits = formattedTime.split(Constants.SPACE);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timeUnits.length; i += 2) {
            if (!timeUnits[i].equals(Constants.ZERO)) {
                sb.append(timeUnits[i]).append(Constants.SPACE).append(timeUnits[i + 1]).append(Constants.SPACE);
            }
        }
        return sb.toString().trim();
    }

    /**
     * Formats the given time string to a shorter version by removing the full unit names
     * and replacing them with single-letter abbreviations
     *
     * @param timeString a string containing a formatted time value with units
     * @return a shorter string representation of the input time string with units abbreviated to a single letter
     */
    public static String formatToShortString(String timeString) {
        String[] units = timeString.split(Constants.REGEX);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < units.length; i += 2) {
            if (StringUtils.isNumeric(units[i])) {
                sb.append(units[i]).append(units[i + 1].charAt(0)).append(Constants.SPACE);
            }
        }
        return sb.toString().trim();
    }
}
