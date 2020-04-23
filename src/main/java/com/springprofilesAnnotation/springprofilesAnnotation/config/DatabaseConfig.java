package com.springprofilesAnnotation.springprofilesAnnotation.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatabaseConfig {
	
	@SuppressWarnings("rawtypes")  
    @Bean(name = "h2DataSource")
    @Profile("dev")
    public javax.sql.DataSource h2DataSource() 
    {
    	System.out.println("Entering inside of h2DataSource");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:C:/temp/msc1");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
 
    @SuppressWarnings("rawtypes")
    @Bean(name = "mySqlDataSource")
    @Profile("test")
    @Primary
    public javax.sql.DataSource mySqlDataSource() 
    {
    	System.out.println("Entering inside of mysql");
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost/msc");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}