package com.zujuan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/14 17:39
 */
//配置文件映射  客户端访问staticMapping 映射到  localDirectory
    //解决jar包运行时文件访问不了的bug

@Configuration
public class WebAppconfig implements WebMvcConfigurer {
    @Value("${upload.staticMapping}")
    private String staticMapping;

    @Value("${upload.localDirectory}")
    private String localDirectory;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticMapping).addResourceLocations("file:"+localDirectory);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
