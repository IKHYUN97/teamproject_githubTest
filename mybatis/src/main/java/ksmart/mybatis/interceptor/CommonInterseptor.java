package ksmart.mybatis.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CommonInterseptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterseptor.class);

	/*
	 * 핸들러를 호출하기 전에 호출되는 메서드
	 * 트루 : 콘트럴러 진입 풜스:콘트럴러 진입 놉
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Set<String> pramKeys = request.getParameterMap().keySet();
		
		
		StringJoiner param = new StringJoiner(",");
		if(pramKeys != null) {
			for(String key : pramKeys) {
				param.add(key + ":" + request.getParameter(key));
			}
		}
		log.info("AccessInfo===========================================================");
		log.info("PORT                       :::::            {}", request.getServerPort());
		log.info("SERVERName                       :::::            {}", request.getServerName());
		log.info("URI                       :::::            {}", request.getRequestURI());
		log.info("HTTPMETHOD      ::::: {}",request.getMethod());
		if(param != null) log.info("PARAMETER                       :::::            {}", param);
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
