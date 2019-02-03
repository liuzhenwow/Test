package com.liuzhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulcrudApplication.class, args);
	}

	@Bean
	public ViewResolver myViewResolver(){
	    return new MyViemResolver();
    }

    private static class MyViemResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
