package io.github.brunoonofre64.dslist.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageBundleConfig {

    @Bean
    public ReloadableResourceBundleMessageSource exceptionResourceBundleMessageSource() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setDefaultEncoding("UTF-8");
        bundle.setBasename("classpath:exception");
        return bundle;
    }
}