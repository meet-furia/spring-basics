package demo;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
    @Bean
    @Scope(scopeName = "prototype")
    public Doctor doctor() {
        return new Doctor();
    }
}
