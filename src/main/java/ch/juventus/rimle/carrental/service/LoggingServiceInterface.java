package ch.juventus.rimle.carrental.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LoggingServiceInterface {

    void displayReq(HttpServletRequest request);
}
