package com.marjina.schimb_valutar.common.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Get date will return current date in specific format
     *
     * @param str Format of date
     * @return String date
     */
    public static String getCurrDate(String str) {
        DateFormat dateFormat = new SimpleDateFormat(str);

        return dateFormat.format(new Date());
    }

    public static String parseDateToString(Date date, String format){
        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }

    public static Date getCurrentDate(){
        return DateTime.now().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toDate();
    }
}
