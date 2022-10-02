package com.zkb.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @author KingPrimes
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    private static final String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
    public static String YYYY = "yyyy";
    public static String YYYY_MM = "yyyy-MM";
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 取当前时间的   年份
     */
    public static long getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 取当前时间的   月份
     */
    public static long getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * 取当前时间的   天数
     */
    public static long getDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 取当前时间的   小时
     */
    public static long getHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取当前时间的   分钟
     */
    public static long getMin() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    /**
     * 取当前时间的   秒数
     */
    public static long getSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    /**
     * 取当前时间的   周几
     */
    public static long getWeek() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 计算两个时间差 dd-hh-mm
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 计算两个时间差 dd-hh-mm-ss
     */
    public static String getDatePoorS(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return day + "天 " + hour + "小时 " + min + "分钟 " + sec + "秒";
    }

    /**
     * 计算两个时间差 到hh-mm-ss
     */
    public static String getDatePoorH(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return hour + "小时 " + min + "分钟 " + sec + "秒";
    }

    /**
     * 计算两个时间差 到mm-ss
     */
    public static String getDatePoorm(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return min + "分钟 " + sec + "秒";
    }

    /**
     * 计算两个时间差 到mm-ss
     */
    public static String getDate(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        if (day != 0) {
            return day + "天 " + hour + "小时 " + min + "分钟 " + sec + "秒";
        } else if (hour != 0) {
            return hour + "小时 " + min + "分钟 " + sec + "秒";
        } else if (min != 0) {
            return min + "分钟 " + sec + "秒";
        } else {
            return sec + "秒";
        }
    }

    /**
     * 取两个时间相差的分钟
     *
     * @param endDate 结束时间
     * @param nowDate 现在的时间
     * @return 相差的分钟
     */
    public static long getDateMin(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少分钟
        return diff % nd % nh / nm;
    }

    /**
     * 计算两个时间相差的小时
     *
     * @param endDate 结束时间
     * @param nowDate 现在的时间
     * @return 相差的小时
     */
    public static long getDateHour(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少分钟
        return diff % nd / nh;
    }

    /**
     * 计算两个时间差 到mm-ss
     */
    public static String getDateSize(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        if (day != 0) {
            return day + "天";
        } else if (hour != 0) {
            return hour + "时";
        } else if (min != 0) {
            return min + "分";
        } else {
            return sec + "秒";
        }
    }

    /**
     * 增加时间
     *
     * @param old    过去的时间
     * @param now    当前时间
     * @param field  要增加的类型 如 天 时 分 秒
     * @param amount 要增加的时间
     * @return
     */
    public static String getDateWeek(Date old, Date now, int field, int amount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(old);
        calendar.add(field, amount);
        old = calendar.getTime();
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long diff = old.getTime() - now.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        if (day != 0) {
            return day + "天 " + hour + "小时 " + min + "分钟 " + sec + "秒";
        } else if (hour != 0) {
            return hour + "小时 " + min + "分钟 " + sec + "秒";
        } else if (min != 0) {
            return min + "分钟 " + sec + "秒";
        } else {
            return sec + "秒";
        }
    }

    /**
     * 增加时间
     *
     * @param old    过去的时间
     * @param now    当前时间
     * @param field  要增加的类型 如 天 时 分 秒
     * @param amount 要增加的时间
     * @return
     */
    public static long getDateWeekT(Date old, Date now, int field, int amount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(old);
        calendar.add(field, amount);
        old = calendar.getTime();
        return old.getTime() - now.getTime();
    }

    /**
     * 增加时间
     *
     * @param now    当前时间
     * @param field  要增加的类型 如 天 时 分 秒
     * @param amount 要增加的时间
     * @return
     */
    public static Date addDateTime(Date now, int field, int amount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(field, amount);
        now = calendar.getTime();
        return now;
    }

    public static Date stringToDate(String str) throws ParseException {
        return DateFormat.getDateInstance().parse(str);
    }

}
