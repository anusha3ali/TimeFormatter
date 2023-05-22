package org.utility.app;

import org.utility.timeutils.TimeFormatterUtil;

import java.util.Scanner;

public class Main {
    private static void showSimpleConvertedTime(long milliseconds) {
        System.out.println("Converted to Hours:" + TimeFormatterUtil.TO_HOURS.format(milliseconds));
        System.out.println("Converted to Minutes:" + TimeFormatterUtil.TO_MINUTES.format(milliseconds));
        System.out.println("Converted to Seconds:" + TimeFormatterUtil.TO_SECONDS.format(milliseconds));
    }

    private static void showConvertedTimeWithoutZeroUnits(long milliseconds) {
        System.out.println("Converted to Hours(without zero units):" +
                TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toString());
        System.out.println("Converted to Minutes(without zero units):" +
                TimeFormatterUtil.TO_MINUTES.format(milliseconds).removeZeroUnits().toString());
        System.out.println("Converted to Seconds(without zero units):" +
                TimeFormatterUtil.TO_SECONDS.format(milliseconds).removeZeroUnits().toString());
    }

    private static void showConvertedTimeInShortForm(long milliseconds) {
        System.out.println("Converted to Hours(short form):" +
                TimeFormatterUtil.TO_HOURS.format(milliseconds).toShortForm().toString());
        System.out.println("Converted to Minutes(short form):" +
                TimeFormatterUtil.TO_MINUTES.format(milliseconds).toShortForm().toString());
        System.out.println("Converted to Seconds(short form):" +
                TimeFormatterUtil.TO_SECONDS.format(milliseconds).toShortForm().toString());
    }

    private static void showConvertedTimeInWithoutZeroUnitsShortForm(long milliseconds) {
        System.out.println("Converted to Hours(without zero units and short form):" +
                TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toShortForm().toString());
        System.out.println("Converted to Minutes(without zero units and short form):" +
                TimeFormatterUtil.TO_MINUTES.format(milliseconds).removeZeroUnits().toShortForm().toString());
        System.out.println("Converted to Seconds(without zero units and short form):" +
                TimeFormatterUtil.TO_SECONDS.format(milliseconds).removeZeroUnits().toShortForm().toString());

    }

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter milliseconds you want to convert.");
            long milliseconds = in.nextLong();
            System.out.println("\n");
            showSimpleConvertedTime(milliseconds);
            System.out.println("\n");
            showConvertedTimeInShortForm(milliseconds);
            System.out.println("\n");
            showConvertedTimeWithoutZeroUnits(milliseconds);
            System.out.println("\n");
            showConvertedTimeInWithoutZeroUnitsShortForm(milliseconds);
            System.out.println("\n");
        }
    }

}
