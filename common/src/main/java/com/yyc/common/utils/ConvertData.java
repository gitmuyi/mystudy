package com.yyc.common.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/26: 14:03
 * @Description:
 */
@Slf4j
public class ConvertData {

    public ConvertData() {
    }

    public static boolean toBoolean(String input) {
        return toBoolean(input, false);
    }

    public static boolean toBoolean(String input, boolean defaultValue) {
        if (null != input && !input.isEmpty()) {
            input = input.trim();
            if (input.compareToIgnoreCase("true") == 0 || input.compareToIgnoreCase("yes") == 0 || input.compareToIgnoreCase("1") == 0) {
                return true;
            }
        }

        return defaultValue;
    }

    public static boolean toBoolean(Object input) {
        return null != input ? toBoolean(input.toString(), false) : false;
    }

    public static boolean toBoolean(Object input, boolean defaultValue) {
        return null != input ? toBoolean(input.toString(), defaultValue) : defaultValue;
    }

    public static Date toDate(Object input) {
        return null != input ? toDate(input, new Date()) : new Date();
    }

    public static Date toDate(Object input, Date defaultValue) {
        return null != input ? toDate(input, (String) null, defaultValue) : defaultValue;
    }

    public static Date toDate(String input, String format) {
        return toDate(input, format, new Date());
    }

    public static Date toDate(Object inputObj, String format, Date defaultValue) {
        if (inputObj instanceof Date) {
            return (Date) inputObj;
        } else {
            String input = toString(inputObj);
            SimpleDateFormat df = null;
            Date outDate = null;
            if (null == format || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            df = new SimpleDateFormat(format);

            try {
                if (null != input && !input.isEmpty()) {
                    outDate = df.parse(input);
                    return outDate;
                } else {
                    return defaultValue;
                }
            } catch (Exception var7) {
                log.error(var7.getMessage());

                return defaultValue;
            }
        }
    }

    public static float toFloat(Object input) {
        return input != null ? toFloat(input.toString(), 0.0F) : 0.0F;
    }

    public static float toFloat(Object input, float defaultValue) {
        return input != null ? toFloat(input.toString(), defaultValue) : defaultValue;
    }

    public static float toFloat(String input) {
        return toFloat(input, 0.0F);
    }

    public static float toFloat(String input, float defaultValue) {
        if (null != input && !input.isEmpty()) {
            try {
                return Float.valueOf(input);
            } catch (NumberFormatException var3) {
                log.error(var3.getMessage());
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static double toDouble(String input) {
        return toDouble(input, 0.0D);
    }

    public static double toDouble(String input, double defaultValue) {
        if (null != input && !input.isEmpty()) {
            try {
                BigDecimal b = new BigDecimal(input);
                return b.doubleValue();
            } catch (NumberFormatException var4) {
                log.error(var4.getMessage());
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static double toDouble(Object input) {
        return null != input ? toDouble(input.toString(), 0.0D) : 0.0D;
    }

    public static double toDouble(Object input, int dec) {
        double f = toDouble(input);
        BigDecimal b = new BigDecimal(f);
        return b.setScale(dec, 4).doubleValue();
    }

    public static double toDouble(Object input, double defaultValue) {
        return null != input ? toDouble(input.toString(), defaultValue) : 0.0D;
    }

    public static long toLong(String input) {
        return toLong(input, 0L);
    }

    public static long toLong(String input, long defaultValue) {
        if (null != input && !input.isEmpty()) {
            try {
                return Long.valueOf(input);
            } catch (NumberFormatException var4) {
                log.error(var4.getMessage());
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static long toLong(Object input) {
        return null != input ? toLong(input.toString(), 0L) : 0L;
    }

    public static long toLong(Object input, long defaultValue) {
        return null != input ? toLong(input.toString(), defaultValue) : defaultValue;
    }

    public static int toInt(String input) {
        return toInt((String) input, 0);
    }

    public static int toInt(String input, int defaultValue) {
        if (null != input && !input.isEmpty()) {
            try {
                return Integer.valueOf(input);
            } catch (NumberFormatException var3) {
                log.error(var3.getMessage());
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static int toInt(Object input) {
        return null != input ? toInt((String) input.toString(), 0) : 0;
    }

    public static int toInt(Object input, int defaultValue) {
        return null != input ? toInt(input.toString(), defaultValue) : defaultValue;
    }

    public static String toString(Object input) {
        return toString(input, "");
    }

    public static String toString(Object input, String defaultValue) {
        if (null != input) {
            if (!(input instanceof Double) && !(input instanceof Float)) {
                defaultValue = input.toString();
            } else {
                NumberFormat nf = NumberFormat.getInstance();
                nf.setGroupingUsed(false);
                nf.setMaximumFractionDigits(16);
                defaultValue = nf.format(input);
            }
        }

        return defaultValue;
    }
}
