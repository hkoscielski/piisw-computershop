package com.piisw.computershop.service;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.piisw.computershop.domain.CategoryEntity;
import com.piisw.computershop.domain.Image;
import com.piisw.computershop.domain.ProductAttrEntity;
import com.piisw.computershop.domain.ProductEntity;
import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.AttributeDTO;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import com.piisw.computershop.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	private CollectionModelMapper collectionModelMapper;

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	public void shouldReturnProductResponseDtos() {
		//given
		Image image1 = new Image(1L, "image1.png", 123123123, "image/png");
		CategoryEntity category1 = new CategoryEntity(1L, "Accessories");
		ProductEntity entity1 = new ProductEntity(1L, category1, image1, Collections.emptyList());
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
		CategoryEntity category2 = new CategoryEntity(2L, "CPU");
		ProductEntity entity2 = new ProductEntity(2L, category2, image2, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes2 = Arrays.asList(
				new ProductAttrEntity(5L, "chipsetManufacturer", "Chipset manufacturer", "AMD", true, entity2),
				new ProductAttrEntity(6L, "chipset", "Chipset", "Radeon RX 590", true, entity2)
		);
		List<ProductAttrEntity> additionalAttributes2 = Arrays.asList(
				new ProductAttrEntity(7L, "coreSpeed", "Core speed", "1565 MHz", false, entity2),
				new ProductAttrEntity(8L, "memorySpeed", "Memory speed", "8000 MHz", false, entity2)
		);
		entity2.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes2, additionalAttributes2)));

		Map<String, AttributeDTO> mainAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("chipsetManufacturer", new AttributeDTO("Chipset manufacturer", "NVIDIA"))
				.put("chipset", new AttributeDTO("Chipset", "GeForce GTX 1050 Ti"))
				.build();
		Map<String, AttributeDTO> additionalAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("coreSpeed", new AttributeDTO("Core speed", "1341 MHz"))
				.put("", new AttributeDTO("Memory speed", "7008 MHz"))
				.build();
		ProductResponseDTO dto1 = new ProductResponseDTO(1L, image1.getId(), mainAttributesMap1, additionalAttributesMap1);

		Map<String, AttributeDTO> mainAttributesMap2 = ImmutableMap.<String, AttributeDTO>builder()
				.put("chipsetManufacturer", new AttributeDTO("Chipset manufacturer", "AMD"))
				.put("chipset", new AttributeDTO("Chipset", "Radeon RX 590"))
				.build();
		Map<String, AttributeDTO> additionalAttributesMap2 = ImmutableMap.<String, AttributeDTO>builder()
				.put("coreSpeed", new AttributeDTO("Core speed", "1565 MHz"))
				.put("", new AttributeDTO("Memory speed", "8000 MHz"))
				.build();
		ProductResponseDTO dto2 = new ProductResponseDTO(2L, image2.getId(), mainAttributesMap2, additionalAttributesMap2);

		List<ProductEntity> entitites = Arrays.asList(entity1, entity2);
		Page<ProductEntity> entitiesPage = new PageImpl<>(entitites, PageRequest.of(1, 20), entitites.size());
		List<ProductResponseDTO> dtos = Arrays.asList(dto1, dto2);
		Page<ProductResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(productRepository.findAll(ArgumentMatchers.<Pageable>any())).willReturn(entitiesPage);
		given(collectionModelMapper.mapPage(entitiesPage, ProductResponseDTO.class)).willReturn(dtosPage);

		//when
		Page<ProductResponseDTO> productResponseDTOPage = productService.findAll(PageRequest.of(1, 20));

		//then
		assertEquals(2, productResponseDTOPage.getContent().size());
		assertThat(productResponseDTOPage.getContent(), everyItem(notNullValue(ProductResponseDTO.class)));
	}

	@Test
	public void shouldReturnProductResponseDto() {
		//given
		Image image = new Image(1L, "image1.png", 123123123, "image/png");
		CategoryEntity category = new CategoryEntity(1L, "Accessories");
		ProductEntity entity = new ProductEntity(1L, category, image, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes = Arrays.asList(
				new ProductAttrEntity(1L, "chipsetManufacturer", "Chipset manufacturer", "NVIDIA", true, entity),
				new ProductAttrEntity(2L, "chipset", "Chipset", "GeForce GTX 1050 Ti", true, entity)
		);
		List<ProductAttrEntity> additionalAttributes = Arrays.asList(
				new ProductAttrEntity(3L, "coreSpeed", "Core speed", "1341 MHz", false, entity),
				new ProductAttrEntity(4L, "memorySpeed", "Memory speed", "7008 MHz", false, entity)
		);
		entity.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes, additionalAttributes)));

		Map<String, AttributeDTO> mainAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("chipsetManufacturer", new AttributeDTO("Chipset manufacturer", "NVIDIA"))
				.put("chipset", new AttributeDTO("Chipset", "GeForce GTX 1050 Ti"))
				.build();
		Map<String, AttributeDTO> additionalAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("coreSpeed", new AttributeDTO("Core speed", "1341 MHz"))
				.put("memorySpeed", new AttributeDTO("Memory speed", "7008 MHz"))
				.build();
		ProductResponseDTO dto1 = new ProductResponseDTO(1L, image.getId(), mainAttributesMap1, additionalAttributesMap1);

		given(productRepository.findById(1L)).willReturn(Optional.of(entity));
		given(collectionModelMapper.map(entity, ProductResponseDTO.class)).willReturn(dto1);

		//when
		ProductResponseDTO productResponseDTO = productService.findById(dto1.getId());

		//then
		assertNotNull(productResponseDTO);
		assertEquals(entity.getId(), productResponseDTO.getId());
		assertEquals(entity.getImage().getId(), productResponseDTO.getImageId());
		assertEquals(mainAttributes.size(), productResponseDTO.getMainAttributes().size());
		assertEquals(mainAttributes.get(0).getName(), productResponseDTO.getMainAttributes().get("chipsetManufacturer").getName());
		assertEquals(mainAttributes.get(0).getValue(), productResponseDTO.getMainAttributes().get("chipsetManufacturer").getValue());
		assertEquals(mainAttributes.get(1).getName(), productResponseDTO.getMainAttributes().get("chipset").getName());
		assertEquals(mainAttributes.get(1).getValue(), productResponseDTO.getMainAttributes().get("chipset").getValue());

		assertEquals(additionalAttributes.size(), productResponseDTO.getAdditionalAttributes().size());
		assertEquals(additionalAttributes.get(0).getName(), productResponseDTO.getAdditionalAttributes().get("coreSpeed").getName());
		assertEquals(additionalAttributes.get(0).getValue(), productResponseDTO.getAdditionalAttributes().get("coreSpeed").getValue());
		assertEquals(additionalAttributes.get(1).getName(), productResponseDTO.getAdditionalAttributes().get("memorySpeed").getName());
		assertEquals(additionalAttributes.get(1).getValue(), productResponseDTO.getAdditionalAttributes().get("memorySpeed").getValue());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void shouldNotFoundProductResponseDtoAndThrowResourceNotFoundException() {
		//given
		Image image = new Image(1L, "image1.png", 123123123, "image/png");
		CategoryEntity category = new CategoryEntity(1L, "Accessories");
		ProductEntity entity = new ProductEntity(1L, category, image, Collections.emptyList());
		List<ProductAttrEntity> mainAttributes = Arrays.asList(
				new ProductAttrEntity(1L, "chipsetManufacturer", "Chipset manufacturer", "NVIDIA", true, entity),
				new ProductAttrEntity(2L, "chipset", "Chipset", "GeForce GTX 1050 Ti", true, entity)
		);
		List<ProductAttrEntity> additionalAttributes = Arrays.asList(
				new ProductAttrEntity(3L, "coreSpeed", "Core speed", "1341 MHz", false, entity),
				new ProductAttrEntity(4L, "memorySpeed", "Memory speed", "7008 MHz", false, entity)
		);
		entity.setProductAttrEntities(Lists.newArrayList(Iterables.concat(mainAttributes, additionalAttributes)));

		Map<String, AttributeDTO> mainAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("chipsetManufacturer", new AttributeDTO("Chipset manufacturer", "NVIDIA"))
				.put("chipset", new AttributeDTO("Chipset", "GeForce GTX 1050 Ti"))
				.build();
		Map<String, AttributeDTO> additionalAttributesMap1 = ImmutableMap.<String, AttributeDTO>builder()
				.put("coreSpeed", new AttributeDTO("Core speed", "1341 MHz"))
				.put("memorySpeed", new AttributeDTO("Memory speed", "7008 MHz"))
				.build();
		ProductResponseDTO dto1 = new ProductResponseDTO(1L, image.getId(), mainAttributesMap1, additionalAttributesMap1);

		given(productRepository.findById(1L)).willReturn(Optional.empty());

		//when
		productService.findById(dto1.getId());
	}
}