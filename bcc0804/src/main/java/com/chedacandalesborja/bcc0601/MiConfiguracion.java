package com.chedacandalesborja.bcc0601;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiConfiguracion {
    @Bean
    ModelMapper modelMapper (){
        return new ModelMapper();
    }
}