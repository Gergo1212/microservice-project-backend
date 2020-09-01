package com.codecool.microserviceprojectbackend.apigateway.secutiry;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenServices jwtTokenServices;

    JwtTokenFilter(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }

    // this is called for every request that comes in (unless its filtered out before in the chain)
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtTokenServices.getTokenFromRequest((HttpServletRequest) req);
        System.out.println(token);
        if (token != null && jwtTokenServices.validateToken(token)) {
            Authentication auth = jwtTokenServices.parseUserFromTokenInfo(token);
            // Marks the user as authenticated.
            // If this code does not run, the request will fail for routes that are configured to need authentication
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // process the next filter.
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        ((HttpServletResponse) res).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) res).setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        ((HttpServletResponse) res).setHeader("Access-Control-Max-Age", "86400");
        System.out.println(response.getHeaderNames());
        System.out.println(response.getHeaders("Access-Control-Allow-Origin"));

        response.addHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
//
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req, res);
        } else {
            filterChain.doFilter(req, res);
        }
        //filterChain.doFilter(req, res);
    }

}
