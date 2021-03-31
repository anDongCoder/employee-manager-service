package cn.employee.manager.service.impl;

import cn.employee.manager.model.LoginLog;
import cn.employee.manager.mapper.LoginLogMapper;
import cn.employee.manager.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liandong
 * @since 2021-03-31
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
