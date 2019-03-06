/**
 * @java COMMON
 * @date 2010/04/20
 */
package com.example.shixing.cwx.cardiy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期共通
 *
 * @version 1.0
 * @date 2008/03/31
 */
public final class DateUtils {

    /**
     * yyyy-MM-dd.
     */
    public static final String DATE_FORMAT_ONE = "yyyy-MM-dd";

    /**
     * yyyy/MM/dd.
     */
    public static final String DATE_FORMAT_TWO = "yyyy/MM/dd";

    /**
     * yyyyMMdd.
     */
    public static final String DATE_FORMAT_THREE = "yyyyMMdd";

    /**
     * yyyyMM.
     */
    public static final String DATE_FORMAT_FOUR = "yyyyMM";

    /**
     * yyyy-MM-dd HH:mm:ss.
     */
    public static final String DATE_FORMAT_FIVE = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm:ss.
     */
    public static final String DATE_FORMAT_UPDATE = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * yyyy.
     */
    public static final String DATE_FORMAT_SIX = "yyyy";

    /**
     * MM.
     */
    public static final String DATE_FORMAT_SEVEN = "MM";

    /**
     * dd.
     */
    public static final String DATE_FORMAT_DD = "dd";

    /**
     * yyyy/MM/dd HH:mm:ss.
     */
    public static final String DATE_FORMAT_EIGHT = "yyyy/MM/dd HH:mm:ss";

    /**
     * HH:mm:ss.
     */
    public static final String DATE_FORMAT_NINE = "HH:mm:ss";

    /**
     * yy/MM/dd.
     */
    public static final String DATE_FORMAT_TEN = "yy/MM/dd";

    /**
     * yyyy/M/d.
     */
    public static final String DATE_FORMAT_ELEVEN = "yyyy/M/d";

    /**
     * yyyy/MM.
     */
    public static final String DATE_FORMAT_TWELEVE = "yyyy/MM";

    /**
     * yyyyMMddHHmmssSSS.
     */
    public static final String DATE_FORMAT_THIRTEEN = "yyyyMMddHHmmssSSS";

    /**
     * yyMMdd.
     */
    public static final String DATE_FORMAT_FOURTEEN = "yyMMdd";

    /**
     * yyyy.MM.dd.
     */
    public static final String DATE_FORMAT_SIXTEEN = "yyyy.MM.dd";

    /**
     * yyyyMMddHHmmss.
     */
    public static final String DATE_FORMAT_SEVENTEEN = "yyyyMMddHHmmss";

    /**
     * yyyy年MM月dd日
     */
    public static final String DATE_FORMAT_EIGHTEEN = "yyyy年MM月dd日";

    /**
     * HH:mm.
     */
    public static final String DATE_FORMAT_NINETEEN = "HH:mm";

    /**
     * HHmm.
     */
    public static final String DATE_FORMAT_TWENTY = "HHmm";

    /**
     * yyyy-MM
     */
    public static final String DATE_FORMAT_TWENTY_ONE = "yyyy-MM";

    /**
     * yyyy.MM
     */
    public static final String DATE_FORMAT_TWENTY_TWO = "yyyy.MM";

    /**
     * yyyy年MM月dd日HH:mm
     */
    public static final String DATE_FORMAT_FIFTEEN = "yyyy年MM月dd日 HH:mm";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_MMDDHHMM = "MM.dd HH:mm";

    /**
     * MM-dd
     */
    public static final String DATE_FORMAT_MMDD = "MM-dd";

    /**
     * MMM d'th', yyyy EEE'.'
     */
    public static final String DATE_FORMAT_THIRTY = "EEE', 'MMM d'th', yyyy'.'";

    /**
     * yyyy'年'MM'月'dd日， EEE
     */
    public static final String DATE_FORMAT_FORTY = "yyyy'年'MM'月'dd'日 'EEE";

    /**
     * yyyy'年'MM'月'
     */
    public static final String DATE_FORMAT_ZH_YM = "yyyy'年'MM'月'";

    /**
     * yyyy-MM-dd
     */
    public static final String DATE_FORMAT_SIMPLE = "yyyy-MM-dd";

    /**
     * MM月dd日
     */
    public static final String DATE_FORMAT_MD = "MM月dd日";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_FIFTY = "yyyy-MM-dd HH:mm";

    /**
     * dd号 HH:mm
     */
    public static final String DATE_FORMAT_DD_HH_MM = "dd号 HH:mm";

    /**
     * INT_4.
     */
    private static final int INT_4 = 4;

    /**
     * INT_6.
     */
    private static final int INT_6 = 6;

    /**
     * INT_8.
     */
    private static final int INT_8 = 8;

    /**
     * .
     */
    public static final String YEAR_FORMAT = "[12][0-9]{3}";

    /**
     * 年.
     */
    public static final int YEAR = 1;

    /**
     * 月.
     */
    public static final int MONTH = 2;

    /**
     * 日.
     */
    public static final int DAY = 3;

    /**
     * 一天的毫秒数
     */
    public static final long DAY_MILLISECONDS = 24 * 60 * 60 * 1000;

    /**
     * 取得系统当前日期
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 取得系统当前时间
     */
    public static long getTime() {
        return getDate().getTime();
    }

    /**
     * 取得系统当前日期
     */
    public static String getNowDate() {
        return dateToString(new Date(), DATE_FORMAT_ONE);
    }

    /**
     * 取得系统具体时间
     */
    public static String getDetailDate() {
        return dateToString(new Date(), DATE_FORMAT_FIFTEEN);
    }

    /**
     * 取得系统当前时间
     */
    public static String getNowTime() {
        return dateToString(new Date(), DATE_FORMAT_NINETEEN);
    }

    /**
     * 取得当前年份
     */
    public static String getThisYear() {
        return dateToString(new Date(), DATE_FORMAT_SIX);
    }

    /**
     * 获取当前的日期所在的星期
     *
     * @param date 日期
     * @return 数字星期
     */
    public static Integer getCurrDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek = 7;
        } else {
            dayOfWeek = dayOfWeek - 1;
        }
        return dayOfWeek;
    }

    /**
     * 按指定格式转化字符串为Date
     *
     * @param strDate   String
     * @param strFormat String
     * @return FormatDate
     * @throws ParseException ParseException
     */
    public static Date getFormatDate(String strDate, String strFormat) throws ParseException {
        if (StringUtils.isEmpty(strDate) || StringUtils.isEmpty(strFormat)) {
            return null;
        }

        SimpleDateFormat df = new SimpleDateFormat(strFormat);
        df.setLenient(false);
        return df.parse(strDate);
    }

    /**
     * 按指定格式转化Date为字符串
     *
     * @param date     Date
     * @param toFormat String
     * @return FormatDate String
     */
    public static String dateToString(Date date, String toFormat) {

        if (date == null) {
            return "";
        }

        SimpleDateFormat df = new SimpleDateFormat(toFormat);
        df.setLenient(false);
        return df.format(date);
    }

    /**
     * 按指定格式转化Date为字符串
     *
     * @param date     Date
     * @param toFormat String
     * @return FormatDate String
     */
    public static Date formatDate(Date date, String strFormat) {
        if (date == null) {
            return null;
        }
        Date reDate = null;
        try {
            reDate = getFormatDate(dateToString(date, strFormat), strFormat);
        } catch (ParseException e) {
            date = null;
        }
        return reDate;
    }

    /**
     * <PRE>
     * <p/>
     * 比较两个日期
     * <p/>
     * </PRE>
     *
     * @param day1 String
     * @param day2 String
     * @return int day1>day2返回1，day1<day2返回-1，day1=day2返回0
     */
    public static int compareDate(String day1, String day2) {

        int isEarly = -1;

        if (day1 == null || day1.trim().equals("") || day2 == null || day2.trim

                ().equals("")) {
            isEarly = -1;
        } else {

            day1 = day1.replaceAll("-", "");
            day2 = day2.replaceAll("-", "");

            int year1 = Integer.parseInt(day1.substring(0, INT_4));
            int month1 = Integer.parseInt(day1.substring(INT_4, INT_6)) - 1;
            int day = Integer.parseInt(day1.substring(INT_6, INT_8));
            Calendar cal1 = Calendar.getInstance();
            cal1.set(year1, month1, day);

            int year2 = Integer.parseInt(day2.substring(0, INT_4));
            int month2 = Integer.parseInt(day2.substring(INT_4, INT_6)) - 1;
            int day22 = Integer.parseInt(day2.substring(INT_6, INT_8));
            Calendar cal2 = Calendar.getInstance();
            cal2.set(year2, month2, day22);

            if (cal1.getTime().compareTo(cal2.getTime()) > 0) {
                isEarly = 1;
            } else if (cal1.getTime().compareTo(cal2.getTime()) == 0) {
                isEarly = 0;
            }
        }
        return isEarly;
    }

    /**
     * <PRE>
     * <p/>
     * 比较两个日期
     * <p/>
     * </PRE>
     *
     * @param day1      String
     * @param day2      String
     * @param strFormat String
     * @return int day1>day2返回1，day1<day2返回-1，day1=day2返回0
     * @throws ParseException 异常
     */
    public static int compareDate(String day1, String day2, String strFormat) throws ParseException {
        Date date1 = getFormatDate(day1, DATE_FORMAT_THREE);
        Date date2 = getFormatDate(day2, DATE_FORMAT_THREE);
        return date1.compareTo(date2);
    }

    /**
     * 比较两个日期的大小
     *
     * @param date1
     * @param date2
     * @return int date1>date2返回1，date1<date2返回-1，date1=date2返回0
     */
    public static int compareDate(Date date1, Date date2) {
        return date1.compareTo(date2);
    }

    /**
     * 日期追加的计算
     *
     * @param strDate 原日期(YYYYMMDD)
     * @param nAddNum 追加的年月日的大小
     * @param nType   追加的类型
     * @return 追加后的新日期(YYYYMMDD)
     */
    public static String addDate(String strDate, int nAddNum, int nType) {
        int nYear = Integer.parseInt(strDate.substring(0, 4));
        int nMonth = Integer.parseInt(strDate.substring(4, 6)) - 1;
        int nDay = Integer.parseInt(strDate.substring(6));

        GregorianCalendar objCal = new GregorianCalendar();
        objCal.set(nYear, nMonth, nDay);

        switch (nType) {
            case 1: {
                objCal.add(GregorianCalendar.YEAR, nAddNum);
                break;
            }
            case 2: {
                objCal.add(GregorianCalendar.MONTH, nAddNum);
                break;
            }
            case 3: {
                objCal.add(GregorianCalendar.DATE, nAddNum);
                break;
            }
            case 4: {
                objCal.add(GregorianCalendar.HOUR, nAddNum);
                break;
            }
            case 5: {
                objCal.add(GregorianCalendar.MINUTE, nAddNum);
                break;
            }
            default: {
                break;
            }
        }

        return dateToString(objCal.getTime(), DATE_FORMAT_THREE);
    }

    /**
     * 日期追加的计算
     *
     * @param date    原日期
     * @param nAddNum 追加的年月日的大小
     * @param nType   追加的类型
     * @return 追加后的新日期
     */
    public static Date addDate(Date date, int nAddNum, int nType) {

        GregorianCalendar objCal = new GregorianCalendar();
        objCal.setTime(date);

        switch (nType) {
            case 1: {
                objCal.add(GregorianCalendar.YEAR, nAddNum);
                break;
            }
            case 2: {
                objCal.add(GregorianCalendar.MONTH, nAddNum);
                break;
            }
            case 3: {
                objCal.add(GregorianCalendar.DATE, nAddNum);
                break;
            }
            case 4: {
                objCal.add(GregorianCalendar.HOUR, nAddNum);
                break;
            }
            case 5: {
                objCal.add(GregorianCalendar.MINUTE, nAddNum);
                break;
            }
        }

        return objCal.getTime();
    }

    /**
     * 返回日期比较的中文格式
     *
     * @param date1 日期一
     * @param date2 日期二
     * @return ××年××月××天
     */
    public static String toChineseDiffDate(String date1, String date2) {

        int diffMonth = 0;

        int diffDay = 0;

        int year = Integer.parseInt(date1.substring(0, 4));
        int year1 = Integer.parseInt(date2.substring(0, 4));

        int month = Integer.parseInt(date1.substring(4, 6)) - 1;
        int month1 = Integer.parseInt(date2.substring(4, 6)) - 1;

        int day = Integer.parseInt(date1.substring(6, 8));
        int day1 = Integer.parseInt(date2.substring(6, 8));

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(year, month, day, 0, 0, 0);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(year1, month1, day1, 0, 0, 0);

        Date enddate = endCalendar.getTime();
        Date startdate = startCalendar.getTime();
        int monthDays = startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        while (startdate.before(enddate)) {
            diffDay++;
            startCalendar.add(Calendar.DATE, 1);
            startdate = startCalendar.getTime();
            if (diffDay == monthDays) {
                diffMonth++;
                diffDay = 0;
                monthDays = startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
        }
        String strdate = "";
        if (diffMonth / 12 > 0) {
            strdate = strdate + diffMonth / 12 + "年";
        }
        if (diffMonth % 12 > 0) {
            strdate = strdate + diffMonth % 12 + "月";
        }
        if (strdate.equals("") || diffDay > 0) {
            strdate = strdate + diffDay + "日";
        }
        return strdate;
    }

    /**
     * @param date        日期
     * @param strLangFlag 语言标志
     * @return 中文化的星期X
     */
    public static String getCnEnDayOfWeek(Date date, String strLangFlag) {
        String strDayOfWeek = "星期";
        String strEnDayOfWeek = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 2) {
            strDayOfWeek += "一";
            strEnDayOfWeek += "Monday";
        } else if (dayOfWeek == 3) {
            strDayOfWeek += "二";
            strEnDayOfWeek += "Tuesday";
        } else if (dayOfWeek == 4) {
            strDayOfWeek += "三";
            strEnDayOfWeek += "Wednesday";
        } else if (dayOfWeek == 5) {
            strDayOfWeek += "四";
            strEnDayOfWeek += "Thursday";
        } else if (dayOfWeek == 6) {
            strDayOfWeek += "五";
            strEnDayOfWeek += "Friday";
        } else if (dayOfWeek == 7) {
            strDayOfWeek += "六";
            strEnDayOfWeek += "Saturday";
        } else {
            strDayOfWeek += "日";
            strEnDayOfWeek += "Sunday";
        }
        if (StringUtils.isEmpty(strLangFlag)) {
            return strDayOfWeek;
        }
        return strEnDayOfWeek;

    }

    /**
     * @param date        日期
     * @param strLangFlag 语言标志
     * @return 中文化的星期X
     * @throws ParseException
     */
    public static String getCnEnDayOfWeek(String date) throws ParseException {
        String strDayOfWeek = "周";
        String strEnDayOfWeek = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate(date, DATE_FORMAT_FIVE));
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 2) {
            strDayOfWeek += "一";
            strEnDayOfWeek += "Monday";
        } else if (dayOfWeek == 3) {
            strDayOfWeek += "二";
            strEnDayOfWeek += "Tuesday";
        } else if (dayOfWeek == 4) {
            strDayOfWeek += "三";
            strEnDayOfWeek += "Wednesday";
        } else if (dayOfWeek == 5) {
            strDayOfWeek += "四";
            strEnDayOfWeek += "Thursday";
        } else if (dayOfWeek == 6) {
            strDayOfWeek += "五";
            strEnDayOfWeek += "Friday";
        } else if (dayOfWeek == 7) {
            strDayOfWeek += "六";
            strEnDayOfWeek += "Saturday";
        } else {
            strDayOfWeek += "日";
            strEnDayOfWeek += "Sunday";
        }

        return strDayOfWeek;

    }

    /**
     * @param date        日期
     * @param strLangFlag 日期
     * @return 英文日期
     */
    public static String getCurrentDayOfWeek(Date date, String strLangFlag) {
        SimpleDateFormat sdf = null;

        if (StringUtils.isEmpty(strLangFlag)) {
            sdf = new SimpleDateFormat(DATE_FORMAT_FORTY, Locale.CHINESE);
        } else {
            sdf = new SimpleDateFormat(DATE_FORMAT_THIRTY, Locale.ENGLISH);
        }
        String strDate = sdf.format(Calendar.getInstance().getTime());
        return strDate;

    }

    /**
     * @param date 日期
     * @return 今年最后一天 yyyy-MM-dd
     * @throws ParseException 异常
     */
    public static Date getNowYearLastDay(Date date) throws ParseException {
        String lastDay = new SimpleDateFormat(DATE_FORMAT_SIX).format(date) + "-12-31";
        return new SimpleDateFormat(DATE_FORMAT_ONE).parse(lastDay);
    }

    /**
     * @param date 日期
     * @return 今年的第一天 yyyy-MM-dd
     * @throws ParseException 异常
     */
    public static Date getNowYearFirstDay(Date date) throws ParseException {
        String firstDay = new SimpleDateFormat(DATE_FORMAT_SIX).format(date) + "-01-01";
        return new SimpleDateFormat(DATE_FORMAT_ONE).parse(firstDay);
    }

    /**
     * @param sd1 日期
     * @param ed2 日期
     * @return 日期相隔天数
     */
    public static int diffDay(Date sd1, Date ed2) {
        if (null == sd1 || null == ed2) {
            return -1;
        }
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.setFirstDayOfWeek(Calendar.SUNDAY);
        d2.setFirstDayOfWeek(Calendar.SUNDAY);
        d1.setTime(sd1);
        d2.setTime(ed2);
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
            Calendar swap;
            swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * @param date  日期
     * @param date1 日期
     * @param n     倍数
     * @return 两个日期之间间隔天数是否是n的倍数
     */
    public static boolean isDayMultN(Date date, Date date1, int n) {
        return (diffDay(date, date1) % n) == 0;
    }

    /**
     * @param date  日期
     * @param date1 日期
     * @return 日期相隔周数
     */
    public static int diffWeek(Date date, Date date1) {
        return (int) ((getNextMonday(date).getTime() - getNextMonday(date1).getTime()) / (1000 * 60 * 60 * 3600 * 7));
    }

    /**
     * @param date  日期
     * @param date1 日期
     * @param n     倍数
     * @return 两个日期之间间隔周数是否是n的倍数
     */
    public static boolean isWeekMultN(Date date, Date date1, int n) {
        return (diffWeek(date, date1) % n) == 0;
    }

    /**
     * @param date 日期
     * @return 获得周一的日期
     */
    public static Date getMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    /**
     * @param date 日期
     * @return 获得周六的日期
     */
    public static Date getSaturday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return c.getTime();
    }

    /**
     * @param date 日期
     * @return 获得某日为该周第几天
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @param date 日期
     * @return 获得当月第一天
     */
    public static Date getFirstDayOfCurrMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, 1 - dayOfMonth);
        return calendar.getTime();
    }

    /**
     * 取得某天是一年中的多少周
     *
     * @param date date
     * @return 某天是一年中的多少周
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int currMonth = c.get(Calendar.MONTH);
        if (currMonth == 11 && c.get(Calendar.WEEK_OF_YEAR) == 1) {
            // 取上周周一
            c.add(Calendar.DATE, -7);
            return c.get(Calendar.WEEK_OF_YEAR) + 1;

        } else {
            return c.get(Calendar.WEEK_OF_YEAR);
        }
    }

    /**
     * 得到某一年周的总数
     *
     * @param year year
     * @return 某一年周的总数
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    /**
     * @param date 日期
     * @return 该月第几周
     */
    public static int getWeekOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获得日期的下一个星期一的日期
     *
     * @param day day
     * @return 日期的下一个星期一的日期
     */
    public static Date getNextMonday(Date day) {
        Calendar date = Calendar.getInstance();
        date.setFirstDayOfWeek(Calendar.SUNDAY);
        date.setTime(day);
        Calendar result = null;
        result = date;
        do {
            result = (Calendar) result.clone();
            result.add(Calendar.DATE, 1);
        } while (result.get(Calendar.DAY_OF_WEEK) != 2);

        return result.getTime();
    }

    /**
     * 获得本周第一天的日期(星期天为第一天)
     *
     * @param day day
     * @return 本周第一天的日期(星期天为第一天)
     */
    public static Date getFirstDayOfWeek(Date day) {
        Calendar date = Calendar.getInstance();
        date.setFirstDayOfWeek(Calendar.SUNDAY);
        date.setTime(day);
        date.set(Calendar.DAY_OF_WEEK, date.getFirstDayOfWeek());
        return date.getTime();
    }

    /**
     * 获得日期包含月份的最大日期
     *
     * @param dateString   日期字符串 "2000-01-01"
     * @param applyPattern 日期的模式 "yyyy-MM-dd"
     * @return 最大日期
     * @throws ParseException 异常
     */
    public static int getMaxDayOfMonth(String dateString, String applyPattern) throws ParseException {
        int d = 0;

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        c.setTime(sdf.parse(dateString));
        d = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        return d;
    }

    /**
     * 获取指定日期月份的第一天
     *
     * @param date 日期
     * @return 字符串日期
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(c.getTime());
        return dateStr;
    }

    /**
     * 获取指定日期月份的第一天
     *
     * @param date 日期
     * @return 字符串日期
     */
    public static Date getFirstDayOfMonth2(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return formatDate(c.getTime(), DATE_FORMAT_ONE);
    }

    /**
     * 获取指定日期月份的最后一天
     *
     * @param date 日期
     * @return 字符串日期
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return formatDate(c.getTime(), DATE_FORMAT_ONE);
    }

    /**
     * 在当前日期上追加N天
     *
     * @param date 当前日期
     * @param num  添加天数
     * @return 日期字符串形式
     */
    public static String addDay(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(c.getTime());
        return dateStr;
    }

    /**
     * 在当前日期上追加N天
     *
     * @param date 当前日期
     * @param num  添加天数
     * @return 日期字符串形式
     * @throws ParseException
     */
    public static Date addDay(String date, int num) throws ParseException {
        Date temDate = string2Date(date, null);
        Calendar c = Calendar.getInstance();
        c.setTime(temDate);
        c.add(Calendar.DAY_OF_MONTH, num);
        return c.getTime();
    }

    /**
     * 在当前日期上追加N月
     *
     * @param date 当前日期
     * @param num  添加月数
     * @return Date
     * @throws ParseException
     */
    public static Date addMonth(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    /**
     * 在当前日期上追加N天
     *
     * @param date 当前日期
     * @param num  添加天数
     * @return 日期字符串形式
     */
    public static Date addDay2(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, num);
        return c.getTime();
    }

    /**
     * 在当前日期上追加N周
     *
     * @param date 当前日期
     * @param num  添加周数
     * @return 日期字符串形式
     */
    public static Date addWeek(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_YEAR, num);
        return c.getTime();
    }

    /**
     * 在当前日期上追加N年
     *
     * @param date 当前日期
     * @param num  添加年数
     * @return 日期字符串形式
     */
    public static Date addYear(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, num);
        return c.getTime();
    }

    /**
     * 根据指定的格式转换字符串为日期，格式为空默认使用“yyyy-MM-dd”
     *
     * @param date   日期字符串
     * @param format 格式
     * @return Date
     * @throws ParseException
     */
    public static Date string2Date(String date, String format) throws ParseException {
        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT_ONE;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /**
     * 根据指定的格式转换字符串为日期，格式为空默认使用“yyyy-MM-dd”
     *
     * @param date   日期字符串
     * @param format 格式
     * @return Date
     * @throws ParseException
     */
    public static Date stringToDate(String date, String format) throws ParseException {
        if (StringUtils.isEmpty(format)) {
            format = DATE_FORMAT_ONE;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /**
     * 获取当前时间指定星期名所在的日期
     *
     * @param weekDayName 星期名称，值为Calendar.DAY_OF_WEEK
     */
    public static Date getDayWeek(int weekDayName) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        Date dayWeek = c.getTime();
        return dayWeek;
    }

    /**
     * 获取当前时间所在月份第一天
     */
    public static Date getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 获取当前时间所在月份
     */
    public static Integer getCurrMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前时间所在年份
     */
    public static Integer getCurrYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取当前时间所在月份
     */
    public static Integer getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前时间所在年份
     */
    public static Integer getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取当前时间所在日
     */
    public static Integer getDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DATE);
    }

    /**
     * 获得本周周一
     *
     * @param Date day
     * @return 本周周一
     */
    public static Date getMondayOfWeek(Date day) {
        Calendar date = Calendar.getInstance();
        date.setFirstDayOfWeek(Calendar.MONDAY);
        date.setTime(day);
        date.set(Calendar.DAY_OF_WEEK, date.getFirstDayOfWeek());
        return date.getTime();
    }

    /**
     * 获取当前时间字符串表示的小时数
     *
     * @param date   时间字符串
     * @param parent 时间格式
     * @return Integer 当前时间小时数
     */
    public static Integer getMinute(Date date) {
        Integer minute = null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            minute = c.get(Calendar.MINUTE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return minute;
    }

    /**
     * 在当前日期上追加N小时
     *
     * @param date 当前日期
     * @param num  添加小时数
     * @return 日期字符串形式
     */
    public static Date addHour(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, num);
        return c.getTime();
    }

    /**
     * 指定的时间戳获取日期对象
     *
     * @param milliseconds 时间戳
     * @return Date
     */
    public static Date getDate(Long milliseconds) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(milliseconds);
        return c.getTime();
    }

    /**
     * 计算两个日期之间相隔的天数，如果d2在d1之后返回正数，d2在d1之前返回负数，返回0表示相等
     *
     * @param d1
     * @param d2
     */
    public static long compareDiffDay(Date d1, Date d2) {
        long days = 0;
        if (d1 != null && d2 != null) {
            long diffMillisecounds = d2.getTime() - d1.getTime();
            days = diffMillisecounds / DAY_MILLISECONDS;
            long moreNum = diffMillisecounds % DAY_MILLISECONDS;
            if (moreNum > 0) {
                days = days + 1;
            } else if (moreNum < 0) {
                days = days - 1;
            }
        }
        return days;
    }

    /**
     * 获取当前时间字符串表示的小时数
     *
     * @param date   时间字符串
     * @param parent 时间格式
     * @return Integer 当前时间小时数
     */
    public static Integer getHour(String date, String parent) {
        Integer hour = null;
        Date tempDate;
        try {
            tempDate = stringToDate(date, parent);
            Calendar c = Calendar.getInstance();
            c.setTime(tempDate);
            hour = c.get(Calendar.HOUR_OF_DAY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hour;
    }

    /**
     * 获取当前时间字符串表示的小时数
     *
     * @param date   时间字符串
     * @param parent 时间格式
     * @return Integer 当前时间小时数
     */
    public static Integer getHour(Date date) {
        Integer hour = null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            hour = c.get(Calendar.HOUR_OF_DAY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hour;
    }

    /**
     * 获取当前时间字符串表示的分钟数
     *
     * @param String 时间字符串
     * @param parent 时间格式
     * @return Integer 当前时间分钟数
     */
    public static String getMinute(String day) {
        String str = "";

        day = day.replaceAll("-", "");

        int min = Integer.parseInt(day.substring(12, 14));

        if (min <= 9) {
            str = "0" + String.valueOf(min);
        } else {
            str = String.valueOf(min);
        }

        return str;
    }

    /**
     * 获取当前时间字符串表示的小时数
     *
     * @param String 时间字符串
     * @param parent 时间格式
     * @return Integer 当前时间小时数
     */
    public static int getHour(String day) {

        day = day.replaceAll("-", "");

        int hour = Integer.parseInt(day.substring(9, 11));

        return hour;
    }

    /**
     * 获取在当月中的天数
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 以友好的方式显示时间
     *
     * @param sdate
     * @return
     */
    public static String friendlyTime(Date datetime) {
        if (datetime == null) {
            return "";
        }
        String ftime = "";
        long currTime = DateUtils.getTime();
        long paramTime = datetime.getTime();
        // 判断是否是同一天
        String curDate = DateUtils.dateToString(new Date(), DateUtils.DATE_FORMAT_ONE);
        String paramDate = DateUtils.dateToString(datetime, DateUtils.DATE_FORMAT_ONE);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((currTime - paramTime) / 3600000);
            if (hour == 0) {
                ftime = Math.max((currTime - paramTime) / 60000, 1) + "分钟前";
            } else {
                ftime = hour + "小时前";
            }
            return ftime;
        }
        long lt = paramTime / 86400000;
        long ct = currTime / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((paramTime - currTime) / 3600000);
            if (hour == 0) {
                ftime = Math.max((paramTime - currTime) / 60000, 1) + "分钟前";
            } else {
                ftime = hour + "小时前";
            }
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2 && days <= 10) {
            ftime = days + "天前";
        } else if (days > 10) {
            ftime = DateUtils.dateToString(datetime, DateUtils.DATE_FORMAT_ONE);
        }
        return ftime;
    }

    public static String toTime(int paramInt) {
        paramInt /= 1000;
        int i = paramInt / 60;
        int j = 0;
        if (i >= 60) {
            j = i / 60;
            i %= 60;
        }
        int k = paramInt % 60;
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(k)});
    }

}
