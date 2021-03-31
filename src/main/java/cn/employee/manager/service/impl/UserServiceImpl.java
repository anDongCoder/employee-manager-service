package cn.employee.manager.service.impl;

import cn.employee.manager.dto.UserDTO;
import cn.employee.manager.dto.UserSearchDTO;
import cn.employee.manager.enums.DeleteFlagEnum;
import cn.employee.manager.model.User;
import cn.employee.manager.mapper.UserMapper;
import cn.employee.manager.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liandong
 * @since 2021-03-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean addUser(UserDTO userDTO) {
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .phoneNumber(userDTO.getPhoneNumber())
                .identityCardNumber(userDTO.getIdentityCardNumber())
                .userType(userDTO.getUserType())
                .sex(userDTO.getSex())
                .position(userDTO.getPosition())
                .remark(userDTO.getRemark())
                .imageUrl(userDTO.getImageUrl())
                .build();
        return save(user);
    }

    @Override
    public Page<UserDTO> searchUser(UserSearchDTO userSearchDTO) {
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
        if (Objects.nonNull(userSearchDTO.getIdentityCardNumber())) {
            wrapper.eq(User::getIdentityCardNumber, userSearchDTO.getIdentityCardNumber());
        }
        if (Objects.nonNull(userSearchDTO.getName())) {
            wrapper.eq(User::getName, userSearchDTO.getName());
        }
        if (Objects.nonNull(userSearchDTO.getPhoneNumber())) {
            wrapper.eq(User::getPhoneNumber, userSearchDTO.getPhoneNumber());
        }
        if (Objects.nonNull(userSearchDTO.getPosition())) {
            wrapper.eq(User::getPosition, userSearchDTO.getPosition());
        }
        if (Objects.nonNull(userSearchDTO.getSex())) {
            wrapper.eq(User::getSex, userSearchDTO.getSex());
        }
        if (Objects.nonNull(userSearchDTO.getUserId())) {
            wrapper.eq(User::getId, userSearchDTO.getUserId());
        }

        wrapper.eq(User::getDel,DeleteFlagEnum.NO_DELETE.getCode());
        IPage<User> page = page(new Page<>(userSearchDTO.getPageIndex(), userSearchDTO.getPageSize()), wrapper);
        List<User> records = page.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return new Page(0, 0);
        }
        List<UserDTO> userDTOList = records.stream()
                .map(user -> UserDTO.builder()
                        .name(user.getName())
                        .imageUrl(user.getImageUrl())
                        .phoneNumber(user.getPhoneNumber())
                        .identityCardNumber(user.getIdentityCardNumber())
                        .sex(user.getSex())
                        .build())
                .collect(Collectors.toList());
        Page<UserDTO> result = new Page<>(userSearchDTO.getPageIndex(), userSearchDTO.getPageSize());
        result.setRecords(userDTOList);
        return result;
    }

    @Override
    public User getUser(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda().eq(User::getUsername, username);
        return getOne(wrapper);
    }
}
