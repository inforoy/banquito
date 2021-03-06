package com.bank.credit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class AppBasicPropertiesConfiguration {
    /**
     * PropertySources bean.
     *
     * @return {@link PropertySourcesPlaceholderConfigurer}
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
