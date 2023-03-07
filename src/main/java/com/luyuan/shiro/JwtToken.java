package com.luyuan.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: IsaiahLu
 * @date: 2023/3/7 17:39
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }


    @Override
    public Object getCredentials() {
        return token;
    }
}
