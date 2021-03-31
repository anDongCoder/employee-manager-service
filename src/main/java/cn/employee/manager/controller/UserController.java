package cn.employee.manager.controller;


import cn.employee.manager.config.Resp;
import cn.employee.manager.dto.LoginDTO;
import cn.employee.manager.dto.UserDTO;
import cn.employee.manager.dto.UserSearchDTO;
import cn.employee.manager.model.User;
import cn.employee.manager.service.UserService;
import cn.employee.manager.utils.JwtUtils;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.util.Objects;

/**
 * 用户相关
 *
 * @author liandong
 */
@RestController
@RequestMapping("/user")
@Api(value = "user controller", tags = {"用户操作"})
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    @Value("${jwt.expire-time}")
    private String jwtExpireTime;



    @Bean
    public JwtUtils jwtUtils() {
        return new JwtUtils(jwtSecretKey, Long.parseLong(jwtExpireTime));
    }

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 新增员工
     *
     * @param userDTO
     * @return
     */
    @PostMapping("add")
    Resp addUser(@RequestBody UserDTO userDTO) {
        String password = userDTO.getPassword();
        String newPassword = SecureUtil.md5(password);
        userDTO.setPassword(newPassword);
        return Resp.okOrFail(userService.addUser(userDTO));
    }

    /**
     * 条件查询员工列表
     *
     * @param userSearchDTO
     * @return
     */
    @PostMapping("search")
    Resp searchUser(@RequestBody UserSearchDTO userSearchDTO) {
        return Resp.ok(userService.searchUser(userSearchDTO));
    }

    @PostMapping("login")
    Resp login(@RequestBody LoginDTO loginDTO) {
        User user = userService.getUser(loginDTO.getUserName());
        if (Objects.isNull(user)) {
            return Resp.paramErr("用不不存在");
        }
        String password = SecureUtil.md5(loginDTO.getPassword());
        if (!password.equals(user.getPassword())) {
            return Resp.paramErr("密码错误");
        }
        String token = jwtUtils.createToken(user.getId().toString());
        return Resp.ok(token);
    }

}
