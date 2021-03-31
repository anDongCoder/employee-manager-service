package cn.employee.manager.service;

import cn.employee.manager.dto.UserDTO;
import cn.employee.manager.dto.UserSearchDTO;
import cn.employee.manager.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 添加用户
     *
     * @param userDTO
     * @return
     */
    boolean addUser(UserDTO userDTO);

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

}
