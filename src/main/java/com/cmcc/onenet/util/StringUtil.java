package com.cmcc.onenet.util;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.ArrayUtils;


/**
 * @author wannengjia@gmail.com
 */
public class StringUtil {

  /**
   * <pre>
   * 判断是否为空，为空则返回true
   * 为空的条件：null、""、"null"
   * </pre>
   * 
   * @param obj
   * @return
   */
  public static boolean isBlank(Object obj) {
    if (obj == null) {
      return true;
    }
    String str = obj.toString().trim();
    str = str.replace("null", "");
    if ("".equals(str)) {
      return true;
    }
    return false;
  }

  public static boolean isAllBlank(CharSequence... css) {
    if (ArrayUtils.isEmpty(css)) {
      return true;
    }
    for (final CharSequence cs : css) {
      if (isNotBlank(cs)) {
        return false;
      }
    }
    return true;
  }

  /**
   * <pre>
   * 判断是否不为空，不为空则返回true
   * 为空的条件：null、""、"null"
   * </pre>
   * 
   * @param obj
   * @return
   */
  public static boolean isNotBlank(Object obj) {
    return !isBlank(obj);
  }

  /**
   * <pre>
   * 获取换行符
   * </pre>
   * 
   * @return
   */
  public static String getNewLine() {
    return System.getProperty("line.separator");
  }

  /**
   * 获取uuid字符串
   */
  public static String uuid() {
    return UUID.randomUUID().toString();
  }

  /**
   * 获取uuid字符串，无横杠
   */
  public static String uuidNotLine() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  /**
   * 去除前后空格，若obj为null返回""空字串
   * 
   * @param obj
   * @return
   */
  public static String trim(Object obj) {
    if (obj == null) {
      return "";
    }
    return obj.toString().trim();
  }

  /**
   * <p>
   * 生成随机码
   *
   * <p>
   * 若指定的长度为0，则返回空白字符串
   *
   * @param codeLength
   *          随机码长度
   * @return
   */
  public static String randomCode(int codeLength) {
    if (codeLength <= 0) {
      return "";
    }

    long powResult = 1L;
    for (int i = 0; i < codeLength / 2; i++) {
      powResult *= 10;
    }
    if ((codeLength & 0x1) == 0) {
      powResult *= powResult;
    } else {
      powResult *= powResult * 10;
    }
    long randomResult = RandomUtils.nextLong(new Random(System.currentTimeMillis()));
    if (randomResult < 0) {
      randomResult += Long.MAX_VALUE;
    }
    StringBuilder code = new StringBuilder(Long.toString(randomResult));
    if (code.length() > codeLength) {
      code.setLength(codeLength);
    } else {
      int[] source = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int sourceHash = source.hashCode();
      int index = code.length();
      while ((index < codeLength)) {
        code.append(sourceHash % 10);
        sourceHash /= 10;
        index++;
      }
    }
    return String.valueOf(code);
  }

  public static String listToString(List<?> stringList) {
    if (stringList == null) {
      return null;
    }
    StringBuilder result = new StringBuilder();
    boolean flag = false;
    for (Object string : stringList) {
      if (flag) {
        result.append(",");
      } else {
        flag = true;
      }
      result.append(string);
    }
    return result.toString();
  }

  /**
   * list转字符串 任意字符分隔
   * 
   * @param list
   * @param separator
   * @return
   */
  public static String listToString(List<String> list, char separator) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)).append(separator);
    }
    return sb.toString().substring(0, sb.toString().length() - 1);
  }
  
  /**
   * 生成redis中的key
   * 
   * @param request
   * @return
   */
  public static String generateKey(HttpServletRequest request) {
    return request.getSession().getId() + StringUtil.uuidNotLine();
  }
  

  
}
