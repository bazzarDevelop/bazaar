package com.qyfou.bazaar.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class PicConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/goodsImage/**").addResourceLocations("file:/root/image/goods/");
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/userImage/**").addResourceLocations("file:/root/image/user/");
        super.addResourceHandlers(registry);
    }
}


