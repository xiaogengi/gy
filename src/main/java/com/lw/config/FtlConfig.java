package com.lw.config;

import com.lw.public_parameter.PublicParameter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FtlConfig extends WebMvcConfigurerAdapter {

    final static String URL = "/File/**";



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler(URL).addResourceLocations(PublicParameter.IMG_URL);
    }


    public static void main(String[] args) {
        System.out.println(PublicParameter.IMG_URL);
    }
}
