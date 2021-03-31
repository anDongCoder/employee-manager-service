package cn.employee.manager.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;


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
public class DailyReports extends Model<DailyReports> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    /**
     * 主题
     */
    private String theme;

    /**
     * 完成工作
     */
    @TableField("finish_work")
    private String finishWork;

    /**
     * 未完成工作
     */
    @TableField("un_finish_work")
    private String unFinishWork;

    /**
     * 明日计划
     */
    @TableField("tomorrow_work_plan")
    private String tomorrowWorkPlan;

    /**
     * 1：已删除 0:未删除
     */
    private String del;

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
