package profesorconfiguracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/inicio").setViewName("home");
        
        registry.addViewController("/logeo").setViewName("login");
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/logout").setViewName("home");
        
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/custom-error").setViewName("error");
    }
}