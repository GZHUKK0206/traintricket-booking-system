package big_work.big_work.filter;


import big_work.big_work.Pojo.Result;
import big_work.big_work.utils.Jwtutils;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;

import java.io.IOException;
import java.security.URIParameter;

@Slf4j
/*@WebFilter(urlPatterns="/*")*/
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();
        log.info("请求的url:",url);

        if (url.contains("login")){
            log.info("登录，放行...");
            filterChain.doFilter(servletRequest,servletResponse);
            return; // 不要继续执行
        }

        String jwt = req.getHeader("token");

        if(!StringUtils.hasLength(jwt)){
            log.info("请求token为空");
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return;
        }

        try {
            System.out.println(Jwtutils.parseJWT(jwt));

        } catch (Exception e) {
            e.printStackTrace();
            log.info("请求token为空");
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return;
        }
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
