package com.parikshit.main.rest.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class MapperConfigurations {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
