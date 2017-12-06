package com.cmcc.onenet.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <pre>
 * 密码工具类
 * 采用BCrypt加密模式，同一个字符串，每次encode的结果都不一样，需要使用checkPassword验证正确性.
 * </pre>
 * 
 * @author wannengjia@gmail.com
 */
public class PasswordUtil {

  public static final Integer OPENSERVICE_PASSWORD_LENGTH = 8;

  public static final Integer OPS_PASSWORD_LENGTH = 6;

  public static final Character[] PASSWORD_SCOPE = {'0', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
      'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k',
      'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

  public static final Character[] ONLY_DIGITAL_PASSWORD_SCOPE = {'0', '2', '3', '4', '5', '6', '7', '8', '9'};


  public static String encode(String rawPassword) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder.encode(rawPassword);
  }

  public static String getMD5Password(String password) {
    return DigestUtils.md5Hex(password);
  }

  public static boolean checkPassword(String password, String encodedPassword) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder.matches(password, encodedPassword);
  }

  public static boolean checkMD5Password(String password, String encodedPassword) {
    String md5Password = DigestUtils.md5Hex(password);
    return md5Password.equals(encodedPassword);
  }


  /**
   * 得到包含大小写字母，随机数字的密码
   *
   * @param length 密码长度
   * @return
   */
  public static String getRandomPassword(Integer length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int coordinate = RandomUtils.nextInt(0, ONLY_DIGITAL_PASSWORD_SCOPE.length);
      sb.append(ONLY_DIGITAL_PASSWORD_SCOPE[coordinate]);
    }
    return sb.toString();
  }

}
