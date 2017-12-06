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
  //
  SYSTEM_MAX_FILE_ERROR(9, "只能上传小于50MB的文件"),

  // 101-200，用户模块
  USER_LOGIN_ERROR(101, "用户名或密码错误"),
  //
  USER_NOT_FOND(102, "该用户不存在"),
  //
  USER_STATUS_ERROR(103, "修改用户状态不符合规则"),
  APPID_NOT_FOUND(104, "无效的应用接入"),
  TOKEN_ERROR(105, "令牌无效"),
  USER_LOGIN_AWIFI_ERROR(106, "该用户未开通数字地图"),

  // 1000-1010（短信推送管理）
  SMS_PUSH_MOBILE_NOT_NULL(1000, "手机号不能为空"),
  //
  SMS_FAILED(1001, "发送短信失败"),
  //
  //
  AUTO_REVIEW_TOKEN_INVALID(10011,"token无效"),
  AUTO_REVIEW_FAIL(10011,"记录不可更改"),

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
