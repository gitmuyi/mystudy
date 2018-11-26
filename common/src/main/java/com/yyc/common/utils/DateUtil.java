package com.yyc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/26: 14:02
 * @Description:
 */
public class DateUtil {
    public static int getLastDay(int year, int month) {
        if (ConvertData.toInt(year) > 0 && ConvertData.toInt(month) >= 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, year);
            calendar.set(2, month);
            int end = calendar.getActualMaximum(5);
            return end;
        } else {
            return 0;
        }
    }

    public static int getDateSpan(Date startDt, Date endDt) {
        return endDt.before(startDt) ? (new Long((startDt.getTime() - endDt.getTime()) / 86400000L)).intValue() + 1 : (new Long((endDt.getTime() - startDt.getTime()) / 86400000L)).intValue() + 1;
    }

    public static long getDateSpanSecond(Date startDt, Date endDt) {
        return _getDateSpan(startDt, endDt, 1000);
    }

    public static long getDateSpanMinute(Date startDt, Date endDt) {
        return _getDateSpan(startDt, endDt, 60000);
    }

    public static long getDateSpanHour(Date startDt, Date endDt) {
        return _getDateSpan(startDt, endDt, 3600000);
    }

    private static long _getDateSpan(Date startDt, Date endDt, int conversion) {
        long diff = 0L;
        if (endDt.before(startDt)) {
            diff = startDt.getTime() - endDt.getTime();
        } else {
            diff = endDt.getTime() - startDt.getTime();
        }

        return new Long(diff / (long) conversion);
    }

    public static String getDateFormat(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date getDateAdd(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date getDateAddMilliSecond(Date date, int ms) {
        return getDateAdd(date, 14, ms);
    }

    public static Date getDateAddSecond(Date date, int second) {
        return getDateAdd(date, 13, second);
    }

    public static Date getDateAddMinute(Date date, int minute) {
        return getDateAdd(date, 12, minute);
    }

    public static Date getDateAddHour(Date date, int hour) {
        return getDateAdd(date, 11, hour);
    }

    public static Date getDateAddDay(Date date, int day) {
        return getDateAdd(date, 5, day);
    }

    public static Date getDateAddMonth(Date date, int amount) {
        return getDateAdd(date, 2, amount);
    }

    public static Date getDate(int year, int month, int day) {
        if (year > 0 && month >= 0 && day > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, year);
            calendar.set(2, month);
            calendar.set(5, day);
            return calendar.getTime();
        } else {
            return null;
        }
    }

    public static int getDateElement(Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    public static int getYear(Date date) {
        return getDateElement(date, 1);
    }

    public static int getMonth(Date date) {
        return getDateElement(date, 2);
    }

    public static int getDay(Date date) {
        return getDateElement(date, 5);
    }

    public static int getHour(Date date) {
        return getDateElement(date, 10);
    }

    public static int getMinute(Date date) {
        return getDateElement(date, 12);
    }

    public static int getSecond(Date date) {
        return getDateElement(date, 13);
    }

    public static int getDayOfWeek(Date date) {
        return getDateElement(date, 7);
    }
}


