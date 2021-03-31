package cn.employee.manager.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 用户类型枚举
 */
@Getter
public enum DeleteFlagEnum implements IEnum<Integer> {
    DELETE(1, "已删除"),
    NO_DELETE(0, "未删除");


    private final Integer code;
    private final String message;

    DeleteFlagEnum(Integer code, String message) {
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
    public Integer getValue() {
        return null;
    }
}
