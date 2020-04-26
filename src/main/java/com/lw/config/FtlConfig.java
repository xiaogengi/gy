package com.lw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FtlConfig extends WebMvcConfigurerAdapter {

    final static String URL = "/getFtl/**";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler(URL).addResourceLocations(getClassesPath());
       registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    public static String getClassesPath(){
        String classesPath=Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1);
        return classesPath + "templates/";
    }
}
