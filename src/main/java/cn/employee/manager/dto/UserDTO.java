package cn.employee.manager.dto;

import cn.employee.manager.enums.SexEnum;
import cn.employee.manager.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UserTypeEnum userType;

    private String username;

    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0:女 1:男
     */
    private SexEnum sex;

    /**
     * 身份证号
     */

    private String identityCardNumber;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 职位
     */
    private String position;

    /**
     * 照片url
     */
    private String imageUrl;

    private String remark;

}
