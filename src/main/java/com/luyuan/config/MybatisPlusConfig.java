package com.luyuan.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import javafx.scene.control.Pagination;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: IsaiahLu
 * @date: 2023/3/7 15:49
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.luyuan.mapper")
public class MybatisPlusConfig {

    public PaginationInnerInterceptor paginationInterceptor(){
        PaginationInnerInterceptor paginationInnerInterceptor= new PaginationInnerInterceptor();
        return paginationInnerInterceptor;
    }


}
