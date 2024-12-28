package com.lijin.study.springcloud.service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("appDataSource1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource appDataSource1() {
        System.out.println("xxxxxxxxxxxxxxxxds-1");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}
