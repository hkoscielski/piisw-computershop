package com.piisw.computershop.config;

import com.piisw.computershop.mapper.CollectionModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class MappingConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@DependsOn("modelMapper")
	public CollectionModelMapper collectionModelMapper() {
		return new CollectionModelMapper();
	}
}
