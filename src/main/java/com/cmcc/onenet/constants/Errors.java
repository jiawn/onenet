package com.cmcc.onenet.constants;

/**
 * 错误码（400-599 禁止使用）
 * 
 * @author wannengjia@gmail.com
 */
public enum Errors {
  // 0-200 系统级
  SUCCESS(0, "操作成功"),
  //
  SYSTEM_ERROR(1, "系统错误"),
  // 自定义错误，可以修改label
  SYSTEM_CUSTOM_ERROR(2, "自定义错误"),
  //
  SYSTEM_DATA_ERROR(3, "数据异常"),
  //
  SYSTEM_DATA_NOT_FOUND(4, "数据不存在"),
  //
  SYSTEM_NOT_LOGIN(5, "请登录"),
  //
  SYSTEM_UPDATE_ERROR(6, "数据更新失败"),
  //
  SYSTEM_NO_ACCESS(7, "无权限访问"),
  //
  SYSTEM_REQUEST_PARAM_ERROR(8, "请求参数错误"),

  // 101-200，用户模块
  USER_LOGIN_ERROR(101, "用户名或密码错误"),
  //
  USER_NOT_FOND(102, "该用户不存在"),


  ;

  public int code;
  public String label;

  private Errors(int code, String label) {
    this.code = code;
    this.label = label;
  }

  /**
   * 获取状态码描述
   * 
   * @param code 状态码
   * @return 状态码描述，如果没有返回空串
   */
  public static String getLabel(int code) {
    String result = "";
    for (Errors status : Errors.values()) {
      if (status.code == code) {
        result = status.label;
      }
    }
    return result;
  }

}
