package com.luyuan.service.impl;

import com.luyuan.entity.User;
import com.luyuan.mapper.UserMapper;
import com.luyuan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author IsaiahLu
 * @since 2023-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
