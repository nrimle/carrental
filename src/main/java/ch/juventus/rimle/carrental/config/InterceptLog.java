package ch.juventus.rimle.carrental.config;

import ch.juventus.rimle.carrental.service.LoggingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class InterceptLog implements HandlerInterceptor {

    final LoggingService loggingService;

    public InterceptLog(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Only logs relevant Methods, e.g. no OPTIONS
        if (request.getMethod().equals(HttpMethod.GET.name())
                || request.getMethod().equals(HttpMethod.DELETE.name())
                || request.getMethod().equals(HttpMethod.PUT.name())
                || request.getMethod().equals(HttpMethod.POST.name())) {
            loggingService.displayReq(request);
        }
        return true;
    }
}