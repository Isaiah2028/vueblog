package com.luyuan.service.impl;

import com.luyuan.entity.Blog;
import com.luyuan.mapper.BlogMapper;
import com.luyuan.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
