package com.itbge.filter;

import com.itbge.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("token");

        if (token == null) {
            throw new ServletException("未登录或令牌不存在");
        }

        try {
            Claims claims = JwtUtils.getClaimsFromToken(token);
            if (JwtUtils.isTokenExpired(token)) {
                throw new ServletException("令牌已过期");
            }

            request.setAttribute("claims", claims);
        } catch (ExpiredJwtException e) {
            throw new ServletException("令牌已过期", e);
        } catch (SignatureException e) {
            throw new ServletException("令牌签名无效", e);
        } catch (Exception e) {
            throw new ServletException("令牌解析错误", e);
        }

        chain.doFilter(request, response);
    }
}
