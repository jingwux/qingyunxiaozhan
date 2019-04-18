package top.sicso.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.sicso.blog.interceptor.UserSecurityInterceptor;
import top.sicso.blog.pojo.SystemSetting;

import java.util.Arrays;

/**
 * web页面配置类，拦截器地址在此注册
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport implements EnvironmentAware {


    private UserSecurityInterceptor securityInterceptor;

    @Autowired
    public WebConfig(UserSecurityInterceptor securityInterceptor) {
        super();
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/", "/login.html", "/login", "/static/**", "/**.ico");//配置登录拦截器拦截路径
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public SystemSetting systemSetting(Environment env) {
        return SystemSetting.builder()
                .picHome(env.getProperty("home"))
                .build();
    }

    @Override
    public void setEnvironment(Environment env) {
        systemSetting(env);
    }
}
