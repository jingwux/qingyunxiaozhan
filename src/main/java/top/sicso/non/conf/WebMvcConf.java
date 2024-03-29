package top.sicso.non.conf;

import top.sicso.blog.pojo.SystemSetting;
import top.sicso.non.interceptor.UserSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;

/**
 * web页面配置类，拦截器地址在此注册
 */
//@Configuration
public class WebMvcConf extends WebMvcConfigurationSupport implements EnvironmentAware {


    private UserSecurityInterceptor securityInterceptor;

    @Autowired
    public WebMvcConf(UserSecurityInterceptor securityInterceptor) {
        super();
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/", "/login.html", "/login","/img/**");//配置登录拦截器拦截路径
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
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
