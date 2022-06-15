package com.longbridge.product.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix="product")
public class ProductConfiguration {

    //This is a configuration for
    //Using Lombok DATA to give it feature of getter & setters
    //calling product.currencies from application.yaml file
    private List<String> currencies;
}
