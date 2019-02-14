package com.stackroute.deliverymanager;

import com.stackroute.deliverymanager.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryManagerApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/*");
		return filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(DeliveryManagerApplication.class, args);
	}

}

