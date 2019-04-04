package com.liuzhen.config;

import com.liuzhen.filter.MyFilter;
import com.liuzhen.listener.MyListener;
import com.liuzhen.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyServletConfig {
    //配置三大组件
    //servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myservlet");
        return servletRegistrationBean;
    }

    //过滤器 filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        Filter filter = new MyFilter();
        filterRegistrationBean.setFilter(filter);
        List<String> list = new ArrayList<String>();
        list.add("/myservlet");
        list.add("/hello");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }

    //监听器listener
    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return myListenerServletListenerRegistrationBean;
    }

    //配置嵌入式容器
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainer() {
        return new EmbeddedServletContainerCustomizer() {
            //定制嵌入式容器
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//                下面这段代码的功能就相当于server.port=9099
//                configurableEmbeddedServletContainer.setPort(9091);
            }
        };
    }
}
