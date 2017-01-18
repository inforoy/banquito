package com.bank.credit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        AppBasicLoggingConfiguration.class,
        AppBasicPropertiesConfiguration.class,
        AppBasicControllerConfiguration.class,
        AppBasicServiceConfiguration.class})
public class AppBasicConfiguration {

}
