package com.cmcc.onenet.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 * 
 * @author wannengjia@gmail.com
 */
public class DateUtil {

  private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

  public static final String yyyyMMdd = "yyyyMMdd";
  private static final String yyyyMMddHH = "yyyyMMddHH";
  public static final String yyyy_MM_dd = "yyyy-MM-dd";
  public static final String ZH_yyyy_MM_dd = "yyyy年MM月dd日";
  public static final String MM_dd = "MM月dd日";

  public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
  private static final String DEFAULT_PATTERN1 = "yyyy/MM/dd HH:mm:ss";
  private static SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat(DEFAULT_PATTERN);
  private static SimpleDateFormat YYYYMMDD_FORMAT = new SimpleDateFormat(yyyyMMdd);
  private static SimpleDateFormat YYYY_MM_DD_FORMAT = new SimpleDateFormat(yyyy_MM_dd);
  private static SimpleDateFormat yyyyMMddHH_FORMAT = new SimpleDateFormat(yyyyMMddHH);
  private static SimpleDateFormat ZH_YYYY_MM_DD_FORMAT = new SimpleDateFormat(ZH_yyyy_MM_dd);
  private static SimpleDateFormat DEFAULT_FORMAT1 = new SimpleDateFormat(DEFAULT_PATTERN1);
  public static final DateFormat DATE_FORMAT_TIME = new SimpleDateFormat("yyyyMMddHHmmssSSS");

  public static Date getCurrentTime() {
    return new Date();
  }

  /**
   * 转成默认格式yyyy-MM-dd HH:mm:ss
   * 
   * @param date
   * @return
   */
  public static String format(Date date) {
    if (date == null) {
      return null;
    }
    return DEFAULT_FORMAT.format(date);
  }

  /**
   * 默认格式yyyy-MM-dd HH:mm:ss，转成日期
   * 
   * @param source
   * @return
   */
  public static Date parse(String source) {
    try {
      return DEFAULT_FORMAT.parse(source);
    } catch (ParseException e) {
      logger.info("转成日期出错", e);
    }
    return null;
  }

  /**
   * 将Date类型的日期转换为参数定义的格式的字符串。
   * 
   * @param date
   * @param pattern
   * @return
   */
  public static String format(Date date, String pattern) {
    if (date == null || pattern == null) {
      return null;
    }
    if (pattern.equalsIgnoreCase(yyyyMMdd)) {
      return YYYYMMDD_FORMAT.format(date);
    }
    if (pattern.equalsIgnoreCase(yyyy_MM_dd)) {
      return YYYY_MM_DD_FORMAT.format(date);
    }
    if (pattern.equalsIgnoreCase(yyyyMMddHH)) {
      return yyyyMMddHH_FORMAT.format(date);
    }if(pattern.equalsIgnoreCase(ZH_yyyy_MM_dd)){
      return ZH_YYYY_MM_DD_FORMAT.format(date);
    }if(pattern.equalsIgnoreCase(DEFAULT_PATTERN1)){
      return DEFAULT_FORMAT1.format(date);
    }if(pattern.equalsIgnoreCase(DEFAULT_PATTERN)){
      return DEFAULT_FORMAT.format(date);
    }
    SimpleDateFormat dateFromat = new SimpleDateFormat(pattern);
    return dateFromat.format(date);
  }

  /**
   * 返回日期格式：yyyyMMddHHmmssSSS
   * 
   * @param date
   * @return
   */
  public static String getDateMillisecondString(Date date) {
    return DATE_FORMAT_TIME.format(date);
  }

  /**
   * 获取一天的开始时间，即 设置参数date的时分秒为0
   * 
   * @param date
   * @return
   */
  public static Date getStartDayTime(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    return c.getTime();
  }

  /**
   * 获取一天的开始时间，即 设置参数date的时分秒为23:59:59
   * 
   * @param date
   * @return
   */
  public static Date getEndDayTime(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    return c.getTime();
  }
  
}
