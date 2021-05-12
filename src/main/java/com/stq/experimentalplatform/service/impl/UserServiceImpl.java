package com.stq.experimentalplatform.service.impl;

import com.stq.experimentalplatform.entity.User;
import com.stq.experimentalplatform.mapper.UserMapper;
import com.stq.experimentalplatform.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
