package com.luyuan.shiro;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.luyuan.common.DbResponse;
import com.luyuan.common.ResponseConstant;
import com.luyuan.utils.JwtUtils;
import com.sun.org.apache.regexp.internal.RE;
import freemarker.template.utility.StringUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Author: IsaiahLu
 * @date: 2023/3/7 17:20
 */

@Component
public class JwtFilter extends AuthenticatingFilter {

    @Autowired
    JwtUtils jwtUtils;

    /**
     * 生成token
     *
     * @param servletRequest
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse response) throws Exception {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String jwt = request.getHeader("Authorization");
        JwtToken jwtToken = new JwtToken(jwt);

        if (StringUtils.isNotBlank(jwt)) {
            return null;
        }

        return jwtToken;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String jwt = request.getHeader("Authorization");

        if (StringUtils.isBlank(jwt)) {
            return true;
        } else {

            //校验jwt
            Claims claim = jwtUtils.getClaimByToken(jwt);
            if (null == claim || jwtUtils.isTokenExpired(claim.getExpiration())) {
                throw new ExpiredCredentialsException("token已失效，请重新登录");
            }
            //执行登录
            return executeLogin(servletRequest, servletResponse);

        }
    }

    /**
     * 登录失败
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Throwable cause = e.getCause() == null ? e : e.getCause();
        DbResponse dbResponse = new DbResponse();
        dbResponse.setCode(500);
        dbResponse.setMsg(cause.getMessage());
        String json = JSONUtil.toJsonStr(dbResponse);

        try {
            httpServletResponse.getWriter().println(json);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return false;
    }
}
