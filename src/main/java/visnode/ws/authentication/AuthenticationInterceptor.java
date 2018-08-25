package visnode.ws.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import visnode.ws.OpenAccess;

/**
 * Authentication interceptor
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    /** Token Service */
    private final AuthenticationTokenService tokenService;

    public AuthenticationInterceptor(AuthenticationTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse response, Object o) throws Exception {
        if (o instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) o;
            if (method.hasMethodAnnotation(OpenAccess.class)) {
                return super.preHandle(hsr, response, o);
            }
            if (tokenService.isValid(hsr.getHeader(AuthenticationToken.HEADER))) {
                return super.preHandle(hsr, response, o);
            }
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return super.preHandle(hsr, response, o);
    }

}
