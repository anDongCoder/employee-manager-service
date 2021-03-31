package cn.employee.manager.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 用户类型枚举
 */
@Getter
public enum UserTypeEnum implements IEnum {

    ADMIN(1, "管理员"),
    EMPLOYEE(0, "员工");


    private final Integer code;
    private final String message;

    UserTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Serializable getValue() {
        return null;
    }
}
