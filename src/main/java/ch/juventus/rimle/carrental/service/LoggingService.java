package ch.juventus.rimle.carrental.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class LoggingService implements LoggingServiceInterface {

    /**
     * Logs the metadata of a http request
     * @param request http request
     */
    @Override
    public void displayReq(HttpServletRequest request) {
        StringBuilder reqMessage = new StringBuilder();
        Map<String, String> parameters = getParameters(request);

        reqMessage.append("REQUEST ");
        reqMessage.append("method = [").append(request.getMethod()).append("]");
        reqMessage.append(" path = [").append(request.getRequestURI()).append("] ");

        if (!parameters.isEmpty()) {
            reqMessage.append(" parameters = [").append(parameters).append("] ");
        }
        log.info("log Request: {}", reqMessage);
    }

    /**
     * Extracts the request parameters from the http request
     * @param request http request
     * @return parameters
     */
    private Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameters = new HashMap<>();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String paramValue = request.getParameter(paramName);
            parameters.put(paramName, paramValue);
        }
        return parameters;
    }
}
