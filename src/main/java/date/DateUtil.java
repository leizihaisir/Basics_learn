package date;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author zihailei
 * @Date 2018/9/25
 * @Description
 */
public class DateUtil {


    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FORMAT_YYMMDDHHMMSS = "yyMMddHHmmss";
    public static final String FORMAT_HHMMSS = "HHmmss";
    public static final String FORMAT_HHMM = "HHmm";
    public static final String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static String date2Str(Date date) {
        return date2Str(date, FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    public static String date2Str(Date date, String format) {
        if (format == null || format.equals("")) {
            format = FORMAT_YYYY_MM_DD_HH_MM_SS;
        }

        if (null == date) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getCurrentDateStr(String format) {
        if (format == null || format.equals("")) {
            format = FORMAT_YYYY_MM_DD_HH_MM_SS;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(new Date());
    }

    /**
     * 获取当前时间，格式为 yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentTimeStr(String format) {
        format = StringUtils.isBlank(format) ? FORMAT_YYYY_MM_DD_HH_MM_SS : format;
        Date now = new Date();
        return date2Str(now, format);
    }

    public static String getTime2Str(Timestamp tm, String format) {
        if (StringUtils.isBlank(format))
            format = FORMAT_YYYY_MM_DD_HH_MM_SS;
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(tm);
    }

    public static Timestamp getCurrentTime() {
        return Timestamp.valueOf(getCurrentTimeStr(null));
    }

    /**
     * 获取当前时间的秒数
     *
     * @return
     */
    public static long getCurrentSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static String format(Date date, String pattern) {
        if (null == date) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String str = sdf.format(date);
        return str;
    }

    public static Date str2Date(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param src        字符串
     * @param srcFormat  字符串日期的格式
     * @param tranfFomat 日期要转成的格式。
     * @return 字符串
     */
    public static String translateFormatStr(String src, String srcFormat, String tranfFomat) {
        try {
            Date date = new SimpleDateFormat(srcFormat).parse(src);//yyyyMMddHHmmss
            return new SimpleDateFormat(tranfFomat).format(date);//yyyy-MM-dd HH:mm:ss
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Date translateFormatDate(String src, String srcFormat, String tranfFomat) {
        String translateFormatStr = translateFormatStr(src, srcFormat, tranfFomat);
        return str2Date(translateFormatStr, tranfFomat);
    }

    /**
     * 得到日期+i天后的日期
     *
     * @param d
     * @param i
     * @return
     */
    public static Date addDay(Date d, int i) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();// 这个时间就是日期往后推一天的结果
    }

    /**
     * desc:获取n天后或n天前的日期
     * <p>创建人：liuyuncheng</p>
     *
     * @param date
     * @param formatstr 参数date的格式，返回的格式
     * @param day       正数n天后，负数n天前
     * @return
     * @throws ParseException
     */
    public static String addDay(String date, String formatstr, int day) {
        SimpleDateFormat format = new SimpleDateFormat(formatstr);
        format.setLenient(false);
        Date paramDate;
        try {
            paramDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期" + date + "转换格式错误format=" + formatstr);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(paramDate);
        calendar.add(Calendar.DATE, day);
        return new SimpleDateFormat(formatstr).format(calendar.getTime());
    }

    /**
     * 获取前后几分钟的时间
     *
     * @param minute
     * @return
     */
    public static Date getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return calendar.getTime();

    }

    /**
     * 获取前后几小时的时间
     *
     * @param hour
     * @return
     */
    public static Date getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        return calendar.getTime();

    }

    /**
     * 获取某一时间前后几小时的时间
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date getTimeByHour(Date date, int hour) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.add(Calendar.HOUR_OF_DAY, hour);

        return calendar.getTime();

    }

    /**
     * 日期格式转换
     *
     * @param str yyyyMMdd
     * @return yyyy-MM-dd
     */
    public static String formatStr(String str) {
        if (str == null || str.length() != 8) {
            return str;
        }
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }

    /**
     * 时间比较
     *
     * @param DATE1
     * @param DATE2
     * @return DATE1>DATE2返回1，DATE1<DATE2返回-1,等于返回0
     */
    public static int compareDate(String date1, String date2, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 验证日期和格式
     *
     * @param str
     * @param format
     * @return
     */
    public static boolean isValidDate(String str, String format) {

        if (StringUtils.isBlank(str)) {
            return false;
        }

        boolean convertSuccess = true;
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            sf.setLenient(false);
            sf.parse(StringUtils.trim(str));
        } catch (ParseException e) {
            e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * 校验字符串日期格式
     *
     * @param datevalue
     * @param dateFormat
     * @return
     */
    public static boolean isValidDateString(String datevalue, String dateFormat) {
        if (StringUtils.isBlank(datevalue)) {
            return false;
        }
        try {
            SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
            java.util.Date dd = fmt.parse(datevalue);
            if (datevalue.equals(fmt.format(dd))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 计算两个日期相差月份分钟 如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static long diffMinutes(Date one, Date two) {
        Calendar calendar = Calendar.getInstance();
        // 得到第一个日期的年分和月份数
        calendar.setTime(one);
        long onel = calendar.getTimeInMillis();
        // 得到第二个日期的年份和月份
        calendar.setTime(two);
        long towl = calendar.getTimeInMillis();

        return (towl - onel) / 1000 / 60;
    }

    public static int getHour() {
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static Date getLastHour(int hour) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//date 换成已经已知的Date对象
        cal.add(Calendar.HOUR_OF_DAY, -hour);// before n hour
        return cal.getTime();
    }

    public static Date getStartOfDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.str2Date("20180120", "yyyyMMdd"));
    }
}
