package com.luyuan.controller;


import com.luyuan.common.DbResponse;
import com.luyuan.common.ResponseConstant;
import com.luyuan.entity.User;
import com.luyuan.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author IsaiahLu
 * @since 2023-03-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("index")
    public DbResponse test(){
        DbResponse dbResponse= new DbResponse();
        User user = userService.getById(1l);
        dbResponse.setCode(ResponseConstant.RES_SUCCESS_CODE);
        dbResponse.setMsg(ResponseConstant.SELECT_SUCCESS_MSG);
        dbResponse.setData(user);
        return  dbResponse;

    }



}
