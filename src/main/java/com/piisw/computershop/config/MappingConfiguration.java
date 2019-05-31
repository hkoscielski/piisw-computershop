package com.piisw.computershop.config;

import com.piisw.computershop.domain.ProductAttrEntity;
import com.piisw.computershop.domain.ProductEntity;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.AttributeDTO;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import org.modelmapper.Converter;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class MappingConfiguration {

	@Bean
	public ExpressionMap<ProductEntity, ProductResponseDTO> productEntityToDtoMapping() {
		Converter<List<ProductAttrEntity>, Map<String, AttributeDTO>> mainAttrToNameAndValueMappingConverter =
				context -> context.getSource().stream()
						.filter(ProductAttrEntity::getIsMain)
						.collect(Collectors.toMap(ProductAttrEntity::getCode, productAttrEntity -> new AttributeDTO(productAttrEntity.getName(), productAttrEntity.getValue())));
		Converter<List<ProductAttrEntity>, Map<String, AttributeDTO>> additionalAttrToNameAndValueMappingConverter =
				context -> context.getSource().stream()
						.filter(attr -> !attr.getIsMain())
						.collect(Collectors.toMap(ProductAttrEntity::getCode, productAttrEntity -> new AttributeDTO(productAttrEntity.getName(), productAttrEntity.getValue())));

		return mapping -> {
			mapping.using(mainAttrToNameAndValueMappingConverter)
					.map(ProductEntity::getProductAttrEntities, ProductResponseDTO::setMainAttributes);
			mapping.using(additionalAttrToNameAndValueMappingConverter)
					.map(ProductEntity::getProductAttrEntities, ProductResponseDTO::setAdditionalAttributes);
		};
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(ProductEntity.class, ProductResponseDTO.class)
				.addMappings(productEntityToDtoMapping());
		return modelMapper;
	}

	@Bean
	@DependsOn("modelMapper")
	public CollectionModelMapper collectionModelMapper() {
		return new CollectionModelMapper();
	}
}
