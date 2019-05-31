package com.piisw.computershop.mapper;

import com.google.common.collect.Iterables;
import com.piisw.computershop.domain.Image;
import com.piisw.computershop.domain.ProductAttrEntity;
import com.piisw.computershop.domain.ProductEntity;
import com.piisw.computershop.payload.AttributeDTO;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.Converter;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CollectionModelMapperTest {

	@TestConfiguration
	static class MappingTestConfiguration {

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

	@Autowired
	private CollectionModelMapper collectionModelMapper;

	@Test
	public void shouldMapEntityToDto() {
		//given
		Image image = new Image(1L, "image1.png", 123123123, "image/png");
		ProductEntity entity = new ProductEntity(1L, image, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes = Arrays.asList(
				new ProductAttrEntity(1L, "chipsetManufacturer", "Chipset manufacturer", "NVIDIA", true, entity),
				new ProductAttrEntity(2L, "chipset", "Chipset", "GeForce GTX 1050 Ti", true, entity)
		);
		List<ProductAttrEntity> additionalAttributes = Arrays.asList(
				new ProductAttrEntity(3L, "coreSpeed", "Core speed", "1341 MHz", false, entity),
				new ProductAttrEntity(4L, "memorySpeed", "Memory speed", "7008 MHz", false, entity)
		);
		entity.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes, additionalAttributes)));

		//when
		ProductResponseDTO dto = collectionModelMapper.map(entity, ProductResponseDTO.class);

		//then
		assertEquals(entity.getId(), dto.getId());
		assertEquals(entity.getImage().getId(), dto.getId());

		assertEquals(mainAttributes.size(), dto.getMainAttributes().size());
		assertEquals(mainAttributes.get(0).getName(), dto.getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes.get(0).getValue(), dto.getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes.get(1).getName(), dto.getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes.get(1).getValue(), dto.getMainAttributes().get("chipset").getValue());

		assertEquals(additionalAttributes.size(), dto.getAdditionalAttributes().size());
		assertEquals(additionalAttributes.get(0).getName(), dto.getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes.get(0).getValue(), dto.getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes.get(1).getName(), dto.getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes.get(1).getValue(), dto.getAdditionalAttributes().get("memorySpeed").getValue());
	}

	@Test
	public void shouldMapPageEntityToPageDto() {
		//given
		Image image1 = new Image(1L, "image1.png", 123123123, "image/png");
		ProductEntity entity1 = new ProductEntity(1L, image1, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes1 = Arrays.asList(
				new ProductAttrEntity(1L, "chipsetManufacturer", "Chipset manufacturer", "NVIDIA", true, entity1),
				new ProductAttrEntity(2L, "chipset", "Chipset", "GeForce GTX 1050 Ti", true, entity1)
		);
		List<ProductAttrEntity> additionalAttributes1 = Arrays.asList(
				new ProductAttrEntity(3L, "coreSpeed", "Core speed", "1341 MHz", false, entity1),
				new ProductAttrEntity(4L, "memorySpeed", "Memory speed", "7008 MHz", false, entity1)
		);
		entity1.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes1, additionalAttributes1)));

		Image image2 = new Image(2L, "image2.png", 321321, "image/png");
		ProductEntity entity2 = new ProductEntity(2L, image2, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes2 = Arrays.asList(
				new ProductAttrEntity(5L, "chipsetManufacturer", "Chipset manufacturer", "AMD", true, entity2),
				new ProductAttrEntity(6L, "chipset", "Chipset", "Radeon RX 590", true, entity2)
		);
		List<ProductAttrEntity> additionalAttributes2 = Arrays.asList(
				new ProductAttrEntity(7L, "coreSpeed", "Core speed", "1565 MHz", false, entity2),
				new ProductAttrEntity(8L, "memorySpeed", "Memory speed", "8000 MHz", false, entity2)
		);
		entity2.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes2, additionalAttributes2)));

		List<ProductEntity> entitites = Arrays.asList(entity1, entity2);
		Page<ProductEntity> entitiesPage = new PageImpl<>(entitites, PageRequest.of(1, 20), entitites.size());

		//when
		Page<ProductResponseDTO> dtosPage = collectionModelMapper.mapPage(entitiesPage, ProductResponseDTO.class);

		//then
		List<ProductResponseDTO> dtosPageContent = dtosPage.getContent();
		List<ProductEntity> entitiesPageContent = entitiesPage.getContent();

		assertEquals(entitiesPage.getTotalElements(), dtosPage.getTotalElements());

		assertEquals(entitiesPageContent.get(0).getId(), dtosPageContent.get(0).getId());
		assertEquals(entitiesPageContent.get(0).getImage().getId(), dtosPageContent.get(0).getImageId());
		assertEquals(mainAttributes1.size(), dtosPageContent.get(0).getMainAttributes().size());
		assertEquals(mainAttributes1.get(0).getName(), dtosPageContent.get(0).getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes1.get(0).getValue(), dtosPageContent.get(0).getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes1.get(1).getName(), dtosPageContent.get(0).getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes1.get(1).getValue(), dtosPageContent.get(0).getMainAttributes().get("chipset").getValue());
		assertEquals(additionalAttributes1.size(), dtosPageContent.get(0).getAdditionalAttributes().size());
		assertEquals(additionalAttributes1.get(0).getName(), dtosPageContent.get(0).getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes1.get(0).getValue(), dtosPageContent.get(0).getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes1.get(1).getName(), dtosPageContent.get(0).getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes1.get(1).getValue(), dtosPageContent.get(0).getAdditionalAttributes().get("memorySpeed").getValue());

		assertEquals(entitiesPageContent.get(1).getId(), dtosPageContent.get(1).getId());
		assertEquals(entitiesPageContent.get(1).getImage().getId(), dtosPageContent.get(1).getImageId());
		assertEquals(mainAttributes2.size(), dtosPageContent.get(1).getMainAttributes().size());
		assertEquals(mainAttributes2.get(0).getName(), dtosPageContent.get(1).getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes2.get(0).getValue(), dtosPageContent.get(1).getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes2.get(1).getName(), dtosPageContent.get(1).getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes2.get(1).getValue(), dtosPageContent.get(1).getMainAttributes().get("chipset").getValue());
		assertEquals(additionalAttributes2.size(), dtosPageContent.get(1).getAdditionalAttributes().size());
		assertEquals(additionalAttributes2.get(0).getName(), dtosPageContent.get(1).getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes2.get(0).getValue(), dtosPageContent.get(1).getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes2.get(1).getName(), dtosPageContent.get(1).getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes2.get(1).getValue(), dtosPageContent.get(1).getAdditionalAttributes().get("memorySpeed").getValue());
	}

	@Test
	public void shouldMapListEntityToListDto() {
		//given
		Image image1 = new Image(1L, "image1.png", 123123123, "image/png");
		ProductEntity entity1 = new ProductEntity(1L, image1, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes1 = Arrays.asList(
				new ProductAttrEntity(1L, "chipsetManufacturer", "Chipset manufacturer", "NVIDIA", true, entity1),
				new ProductAttrEntity(2L, "chipset", "Chipset", "GeForce GTX 1050 Ti", true, entity1)
		);
		List<ProductAttrEntity> additionalAttributes1 = Arrays.asList(
				new ProductAttrEntity(3L, "coreSpeed", "Core speed", "1341 MHz", false, entity1),
				new ProductAttrEntity(4L, "memorySpeed", "Memory speed", "7008 MHz", false, entity1)
		);
		entity1.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes1, additionalAttributes1)));

		Image image2 = new Image(2L, "image2.png", 321321, "image/png");
		ProductEntity entity2 = new ProductEntity(2L, image2, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes2 = Arrays.asList(
				new ProductAttrEntity(5L, "chipsetManufacturer", "Chipset manufacturer", "AMD", true, entity2),
				new ProductAttrEntity(6L, "chipset", "Chipset", "Radeon RX 590", true, entity2)
		);
		List<ProductAttrEntity> additionalAttributes2 = Arrays.asList(
				new ProductAttrEntity(7L, "coreSpeed", "Core speed", "1565 MHz", false, entity2),
				new ProductAttrEntity(8L, "memorySpeed", "Memory speed", "8000 MHz", false, entity2)
		);
		entity2.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes2, additionalAttributes2)));

		List<ProductEntity> entitites = Arrays.asList(entity1, entity2);

		//when
		List<ProductResponseDTO> dtos = collectionModelMapper.mapAll(entitites, ProductResponseDTO.class);

		//then
		assertEquals(entitites.size(), dtos.size());

		assertEquals(entitites.get(0).getId(), dtos.get(0).getId());
		assertEquals(entitites.get(0).getImage().getId(), dtos.get(0).getImageId());
		assertEquals(mainAttributes1.size(), dtos.get(0).getMainAttributes().size());
		assertEquals(mainAttributes1.get(0).getName(), dtos.get(0).getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes1.get(0).getValue(), dtos.get(0).getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes1.get(1).getName(), dtos.get(0).getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes1.get(1).getValue(), dtos.get(0).getMainAttributes().get("chipset").getValue());
		assertEquals(additionalAttributes1.size(), dtos.get(0).getAdditionalAttributes().size());
		assertEquals(additionalAttributes1.get(0).getName(), dtos.get(0).getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes1.get(0).getValue(), dtos.get(0).getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes1.get(1).getName(), dtos.get(0).getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes1.get(1).getValue(), dtos.get(0).getAdditionalAttributes().get("memorySpeed").getValue());

		assertEquals(entitites.get(1).getId(), dtos.get(1).getId());
		assertEquals(entitites.get(1).getImage().getId(), dtos.get(1).getImageId());
		assertEquals(mainAttributes2.size(), dtos.get(1).getMainAttributes().size());
		assertEquals(mainAttributes2.get(0).getName(), dtos.get(1).getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes2.get(0).getValue(), dtos.get(1).getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes2.get(1).getName(), dtos.get(1).getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes2.get(1).getValue(), dtos.get(1).getMainAttributes().get("chipset").getValue());
		assertEquals(additionalAttributes2.size(), dtos.get(1).getAdditionalAttributes().size());
		assertEquals(additionalAttributes2.get(0).getName(), dtos.get(1).getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes2.get(0).getValue(), dtos.get(1).getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes2.get(1).getName(), dtos.get(1).getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes2.get(1).getValue(), dtos.get(1).getAdditionalAttributes().get("memorySpeed").getValue());
	}
}