package com.yyc.security.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/22: 20:33
 * @Description: 通过自定义AccessDeniedHandler我们可以自定义403响应的内容
 */
@Slf4j
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info("User '" + auth.getName()
                    + "' attempted to access the protected URL: "
                    + request.getRequestURI());
        }
        response.sendRedirect(request.getContextPath() + "/403");

    }

}
