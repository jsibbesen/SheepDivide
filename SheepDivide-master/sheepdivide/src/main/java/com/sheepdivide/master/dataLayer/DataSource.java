package com.sheepdivide.master.dataLayer;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


public class DataSource {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return (DataSource) DataSourceBuilder.create().build();
    }
}
