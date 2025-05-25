package com.ortega.demointerceptor.interceptores;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Calendario_Interceptor implements HandlerInterceptor {

  @Value("${config.calendar.open}")
  private int open;
  @Value("${config.calendar.close}")
  private int close;

  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler) throws Exception {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        if (hora < open || hora > close) {
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          return false;
        }
        StringBuilder msg = new StringBuilder();
        msg.append("Acceso permitido desde las ");
        msg.append(open);
        msg.append(" hasta las ");
        msg.append(close);
        msg.append(" horas");
        request.setAttribute("Mensaje", msg.toString());
        return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
  }

}
