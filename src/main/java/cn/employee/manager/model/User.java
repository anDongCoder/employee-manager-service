package cn.employee.manager.model;

import cn.employee.manager.enums.DeleteFlagEnum;
import cn.employee.manager.enums.SexEnum;
import cn.employee.manager.enums.UserTypeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liandong
 * @since 2021-03-31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *  0:员工  1:管理员
     */
    @TableField("user_type")
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
    @TableField("identity_card_number")
    private String identityCardNumber;

    /**
     * 手机号
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 职位
     */
    private String position;

    /**
     * 照片url
     */
    @TableField("image_url")
    private String imageUrl;

    private String remark;

    /**
     * 删除状态
     */
    private DeleteFlagEnum del;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
