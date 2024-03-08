package com.example.app.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:/config/tarifas.properties")
public class Tarifas {
    @Value("100")
    private Integer tarifaConsulta;
    @Value("5")
    private Integer tarifaReceta;
    @Value("50")
    private Integer tarifaRevisionAdulto;
    @Value("30")
    private Integer tarifaRevisonJubilado;

}
