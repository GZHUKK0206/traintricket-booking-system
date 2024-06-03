package big_work.big_work.Interceptor;


import big_work.big_work.Pojo.Result;
import big_work.big_work.utils.Jwtutils;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {


        String url = req.getRequestURL().toString();
        System.out.println(url);
        /*log.info("请求的url:",url);*/

        if (url.contains("login")||url.contains("register")){
            log.info("登录，放行...");

            return true; // 不要继续执行
        }

        String jwt = req.getHeader("token");
        System.out.println(jwt);
        System.out.println(StringUtils.hasLength(jwt));
        if(!StringUtils.hasLength(jwt)){
            log.info("请求token为空");
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return false;
        }

        try {
            System.out.println(jwt);
            Jwtutils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("请求token为空");
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(noLogin);
            return false;
        }
        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
