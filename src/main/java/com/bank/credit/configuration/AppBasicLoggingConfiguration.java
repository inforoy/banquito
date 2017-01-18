package com.bank.credit.configuration;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBasicLoggingConfiguration {

    @Bean
    public ConsoleAppender consoleAppender()
    {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.ALL);
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d %-5p [%c{1}] %m %n");
        consoleAppender.setLayout(patternLayout);
        return consoleAppender;
    }
}
