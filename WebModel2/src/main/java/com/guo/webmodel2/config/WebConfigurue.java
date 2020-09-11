package com.guo.webmodel2.config;

import com.guo.webmodel2.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurue implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        //如果是Windows系统
//        if (os.toLowerCase().startsWith("win")) {
//            registry.addResourceHandler("/app_file/**")
//                    // /app_file/**表示在磁盘filePathWindow目录下的所有资源会被解析为以下的路径
//                    .addResourceLocations("file:" + filePathWindow);
//        } else {  //linux 和mac
//            registry.addResourceHandler("/app_file/**")
//                    .addResourceLocations("file:" + filePathLinux) ;
//        }
//
//        super.addResourceHandlers(registry);

    }
    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效\

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("加载拦截路径");
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html","/css/**","/fonts/**","/js/**","/images/**","/admin/**");

    }
}
