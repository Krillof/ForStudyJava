package com.example;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.example")
@PropertySource("classpath:prop.properties")
@Component
public class SpringConfig {
}
