package cn.employee.manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误编码枚举类
 *
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    /**
     * 系统类错误码
     */
    OK(0, "操作成功"),
    FAIL(101, "操作失败"),
    BIZ_FAIL(102, "业务处理失败"),
    BIZ_PARAM_ERR(103, "请求参数错误"),
    FORBIDDEN(403, "没有权限"),
    SERVER_ERR(500, "内部服务器错误");


    private int code;
    private String msg;
}
