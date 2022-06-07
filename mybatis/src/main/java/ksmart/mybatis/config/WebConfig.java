package ksmart.mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart.mybatis.interceptor.CommonInterseptor;
import ksmart.mybatis.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
		private final CommonInterseptor commonInterseptor;
		private final LoginInterceptor loginInterseptor;
		
		public  WebConfig(CommonInterseptor commonInterseptor,LoginInterceptor loginInterseptor) {
		
			this.commonInterseptor = commonInterseptor;
			this.loginInterseptor = loginInterseptor;
		}
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			
			registry.addInterceptor(commonInterseptor)
					.addPathPatterns("/**")
					.excludePathPatterns("/css/**")
					.excludePathPatterns("/js/**")
					.excludePathPatterns("/favicon.ico");
			
			registry.addInterceptor(loginInterseptor)
					.addPathPatterns("/**")
					.excludePathPatterns("/css/**")
					.excludePathPatterns("/js/**")
					.excludePathPatterns("/favicon.ico")
					.excludePathPatterns("/member/addMember")
					.excludePathPatterns("/login")
					.excludePathPatterns("/logout");
					
			WebMvcConfigurer.super.addInterceptors(registry);
		
		}
	
}
