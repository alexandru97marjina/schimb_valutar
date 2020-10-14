package com.marjina.schimb_valutar.common.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Parse date to string
     *
     * @param date   Date object
     * @param format Desired format
     * @return String date
     */
    public static String parseDateToString(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }

    /**
     * Parse String to Date
     *
     * @param date   Date object
     * @param format String format of date
     * @return Date object
     * @throws ParseException in case of parse exception
     */
    public static Date parseStringToDate(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * Get currentDate of object
     *
     * @return Date object
     */
    public static Date getCurrentDate() {
        return DateTime.now().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate();
    }

}
