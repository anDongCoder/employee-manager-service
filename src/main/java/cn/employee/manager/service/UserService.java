package cn.employee.manager.service;

import cn.employee.manager.dto.AdminUserDTO;
import cn.employee.manager.dto.UserDTO;
import cn.employee.manager.dto.UserSearchDTO;
import cn.employee.manager.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liandong
 * @since 2021-03-31
 */
public interface UserService extends IService<User> {

    /**
     * 从token解析userId
     *
     * @param token
     * @return
     */
    Integer getUserId(String token);

    /**
     * 添加用户
     *
     * @param userDTO
     * @return
     */
    boolean saveOrUpdate(UserDTO userDTO);

    /**
     * 条件查询
     *
     * @param userSearchDTO
     * @return
     */
    Page<UserDTO> searchUser(UserSearchDTO userSearchDTO);

    /**
     * 根据username查询用户信息
     *
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * 获取admin用户列表
     *
     * @return
     */
    List<AdminUserDTO> getAdminList();


    /**
     * 删除员工
     * @param userId
     * @return
     */
    boolean deleteUser(Integer userId);

    /**
     * 查询员工信息
     *
     * @param userId
     * @return
     */
    UserDTO getUser(Integer userId);

}
