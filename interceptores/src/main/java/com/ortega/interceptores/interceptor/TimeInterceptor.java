package com.ortega.interceptores.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor{
  private static final String START_TIME = "inicio";

  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
    long startTime = System.currentTimeMillis();
    req.setAttribute(START_TIME, startTime);
    return true;
  }

  public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
    // calcular el tiempo de ejecución
    long startTime = (Long) req.getAttribute(START_TIME);
    long endTime = System.currentTimeMillis();
    long executeTime = endTime - startTime;

    System.out.println("Tiempo de ejecución: " + executeTime + " ms" + " on Req: " + req.getRequestURI());
  }
}
