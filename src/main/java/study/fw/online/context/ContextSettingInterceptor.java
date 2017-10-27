package study.fw.online.context;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import study.fw.core.context.ContextHolder;

/*컨트롤러 앞단의 인터셉터를 이용해서 스레드 로컬에 정보를 저장하는 클래스*/
public class ContextSettingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Http request URI에서 service id를 구해서 context에 세팅한다. 로깅 시 활용 등
        String serviceId = request.getRequestURI().substring(request.getContextPath().length() + 1);
        ContextHolder.setContext("SVC_ID", serviceId);

        // Http request에서 요청자의 IP 가져오기
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        ContextHolder.setContext("USER_IP", ip);

        return true;
    }
}
