package top.sicso.blog.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.sicso.blog.pojo.SystemSetting;

/**
 * web页面配置类，拦截器地址在此注册
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport implements EnvironmentAware {


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Date2LocalDateConverter());
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
