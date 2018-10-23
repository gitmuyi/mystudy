package com.yyc.security.config;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yyc.security.filter.AuthenticationAccessDeniedHandler;
import com.yyc.security.filter.UrlAccessDecisionManager;
import com.yyc.security.filter.UrlFilterInvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 *
 * @author zhaoxinguo on 2017/9/13.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 需要放行的URL
     */
    private static final String[] AUTH_WHITELIST = {
            "/login", "/**/*.js", "static/js/*.js"};

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;


    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(getObjectPostProcessor())
                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .failureHandler(getAuthenticationFailureHandler())
                .successHandler(getAuthenticationSuccessHandler())
                .and().logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }

    private ObjectPostProcessor getObjectPostProcessor() {
        return new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        };
    }

    private AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.sendRedirect("/index");

            }
        };
    }

    private AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                StringBuffer sb = new StringBuffer();
                sb.append("{\"status\":\"error\",\"msg\":\"");
                if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
                    sb.append("用户名或密码输入错误，登录失败!");
                } else if (exception instanceof DisabledException) {
                    sb.append("账户被禁用，登录失败，请联系管理员!");
                } else {
                    sb.append("登录失败!");
                }
                sb.append("\"}");
                out.write(sb.toString());
                out.flush();
                out.close();
            }
        };
    }


    // 该方法是登录的时候会进入
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }


}
