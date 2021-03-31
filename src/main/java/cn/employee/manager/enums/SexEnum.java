package cn.employee.manager.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 性别枚举
 */
@Getter
public enum SexEnum implements IEnum {
    MAN(1, "男"),
    WOMAN(0, "女"),;


    private final Integer code;
    private final String message;

    SexEnum(Integer code, String message) {
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
